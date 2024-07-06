package KedelidzeKrutyakov.deal.api.controller;

import KedelidzeKrutyakov.deal.Creator;
import KedelidzeKrutyakov.deal.api.DTO.*;
import KedelidzeKrutyakov.deal.api.feign.ConveyorApi;
import KedelidzeKrutyakov.deal.enums.ApplicationStatus;
import KedelidzeKrutyakov.deal.exception.UniquenessCheckException;
import KedelidzeKrutyakov.deal.persistence.entity.Application;
import KedelidzeKrutyakov.deal.persistence.entity.Client;
import KedelidzeKrutyakov.deal.persistence.entity.Credit;
import KedelidzeKrutyakov.deal.persistence.repository.ApplicationRepository;
import KedelidzeKrutyakov.deal.service.ApplicationService;
import KedelidzeKrutyakov.deal.service.ClientService;
import KedelidzeKrutyakov.deal.service.CreditService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static KedelidzeKrutyakov.deal.Creator.createCredit;

@RequiredArgsConstructor
@RestController
@RequestMapping("/deal")
public class DealController {

    private final ClientService clientService;
    private final ApplicationService applicationService;
    private final CreditService creditService;
    private final ConveyorApi conveyorApi;


    @PostMapping("/application")
    public ResponseEntity<List<LoanOfferDTO>> calculateLoanOffers(
            @RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO) {

        Client newClient = clientService.createClient(loanApplicationRequestDTO);
        clientService.saveClient(newClient);

        Application newApplication =
                applicationService.createApplication(loanApplicationRequestDTO, newClient);
        applicationService.saveApplication(newApplication);

        List<LoanOfferDTO> loanOffers = conveyorApi.getLoanOffers(loanApplicationRequestDTO);
        loanOffers.forEach(offer -> offer.setApplicationId(newApplication.getId()));

        return ResponseEntity.ok(loanOffers);
    }


    @PutMapping("/offer")
    public void applyOffer(@RequestBody LoanOfferDTO loanOfferDTO) {
        applicationService.applyOffer(loanOfferDTO);
    }


    @PutMapping("/calculate/{applicationId}")
    public void finishRegistration(
            @RequestBody FinishRegistrationRequestDTO finishRegistrationRequestDTO,
            @PathVariable Long applicationId) {

        Application application = applicationService.findApplicationById(applicationId);
        ScoringDataDTO scoringDataDTO = Creator.createScoringDataDTO(
                finishRegistrationRequestDTO, application);

        CreditDTO creditDTO = conveyorApi.getCredit(scoringDataDTO);
        Credit credit = creditService.createCredit(creditDTO);
        creditService.saveCredit(credit);

        application.setCredit(credit);
        applicationService.updateApplicationStatus(application, ApplicationStatus.PREPARE_DOCUMENTS);
        applicationService.saveApplication(application);
    }
}
