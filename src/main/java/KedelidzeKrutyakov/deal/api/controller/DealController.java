package KedelidzeKrutyakov.deal.api.controller;

import KedelidzeKrutyakov.deal.api.DTO.*;

import KedelidzeKrutyakov.deal.service.ApplicationService;
import KedelidzeKrutyakov.deal.service.ClientService;
import KedelidzeKrutyakov.deal.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deal")
public class DealController {

    private final ClientService clientService;
    private final ApplicationService applicationService;
    private final CreditService creditService;

    @Autowired
    public DealController (
            ClientService clientService,
            ApplicationService applicationService,
            CreditService creditService) {
        this.clientService = clientService;
        this.applicationService = applicationService;
        this.creditService = creditService;
    }

    /*
    По API приходит LoanApplicationRequestDTO
    На основе LoanApplicationRequestDTO создаётся сущность Client и сохраняется в БД.
    Создаётся Application со связью на только что созданный Client и сохраняется в БД.
    Отправляется POST запрос на /conveyor/offers МС conveyor через FeignClient. Каждому элементу из списка
    List<LoanOfferDTO> присваивается id созданной заявки (Application)
    Ответ на API - список из 4х LoanOfferDTO от "худшего" к "лучшему".
     */
    @PostMapping("/application")
    public void calculateLoanOffers(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO) {

    }

    /*
    По API приходит LoanOfferDTO
    Достаётся из БД заявка(Application) по applicationId из LoanOfferDTO.
    В заявке обновляется статус, история статусов(List<ApplicationStatusHistoryDTO>), принятое предложение
    LoanOfferDTO устанавливается в поле appliedOffer.
    Заявка сохраняется.
     */
    @PutMapping("/offer")
    public void applyOffer(@RequestBody LoanOfferDTO loanOfferDTO) {

    }

    /*
    По API приходит объект FinishRegistrationRequestDTO и параметр applicationId (Long).
    Достаётся из БД заявка(Application) по applicationId.
    ScoringDataDTO насыщается информацией из FinishRegistrationRequestDTO и Client, который хранится в Application
    Отправляется POST запрос на /conveyor/calculation МС conveyor с телом ScoringDataDTO через FeignClient.
    На основе полученного из кредитного конвейера CreditDTO создаётся сущность Credit и сохраняется в базу со статусом CALCULATED.
    В заявке обновляется статус, история статусов.
    Заявка сохраняется.
     */
    @PutMapping("/calculate/{id}")
    public void finishRegistration(
            @RequestBody FinishRegistrationRequestDTO finishRegistrationRequestDTO,
            @PathVariable Long applicationId) {

    }
}
