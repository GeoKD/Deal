package KedelidzeKrutyakov.deal.api.feign;

import KedelidzeKrutyakov.deal.api.DTO.CreditDTO;
import KedelidzeKrutyakov.deal.api.DTO.LoanApplicationRequestDTO;
import KedelidzeKrutyakov.deal.api.DTO.LoanOfferDTO;
import KedelidzeKrutyakov.deal.api.DTO.ScoringDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient (name = "conveyor", url = "http://localhost:8082/conveyor")
public interface ConveyorApi {

    @PostMapping("/offers")
    List<LoanOfferDTO> getLoanOffers(
            @RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO);

    @PostMapping("/calculation")
    CreditDTO getCredit(
            @RequestBody ScoringDataDTO scoringDataDTO );
}
