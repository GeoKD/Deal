package KedelidzeKrutyakov.deal;

import KedelidzeKrutyakov.deal.api.DTO.*;
import KedelidzeKrutyakov.deal.enums.ApplicationStatus;
import KedelidzeKrutyakov.deal.enums.CreditStatus;
import KedelidzeKrutyakov.deal.persistence.entity.Application;
import KedelidzeKrutyakov.deal.persistence.entity.Client;
import KedelidzeKrutyakov.deal.persistence.entity.Credit;

import java.time.LocalDate;

public class Creator {
    public static Application CreateApplication(LoanApplicationRequestDTO larDTO, Client client) {
        return Application.builder()
                .client(client)
                .creationDate(LocalDate.now())
                .status(ApplicationStatus.PREAPPROVAL)
                .build();
    }

    public static Client createClient (LoanApplicationRequestDTO larDTO) {
        return Client.builder()
                .lastName(larDTO.getLastName())
                .firstName(larDTO.getFirstName())
                .middleName(larDTO.getMiddleName())
                .birthDate(larDTO.getBirthDate())
                .email(larDTO.getEmail())
                .passportSeries(larDTO.getPassportSeries())
                .passportNumber(larDTO.getPassportNumber())
                .build();
    }

    public static ScoringDataDTO createScoringDataDTO(
            FinishRegistrationRequestDTO frrDTO, Application application) {
        Client client = application.getClient();
        LoanOfferDTO loanOfferDTO = application.getAppliedOffer();

        ScoringDataDTO scoringDataDTO = new ScoringDataDTO();
        scoringDataDTO.setAmount(loanOfferDTO.getRequestedAmount());
        scoringDataDTO.setTerm(loanOfferDTO.getTerm());
        scoringDataDTO.setFirstName(application.getClient().getFirstName());
        scoringDataDTO.setLastName(application.getClient().getLastName());
        scoringDataDTO.setMiddleName(application.getClient().getMiddleName());
        scoringDataDTO.setGender(frrDTO.getGender());
        scoringDataDTO.setBirthDate(client.getBirthDate());
        scoringDataDTO.setMartialStatus(frrDTO.getMartialStatus());
        scoringDataDTO.setDependentAmount(frrDTO.getDependentAmount());
        scoringDataDTO.setPassportSeries(client.getPassportSeries());
        scoringDataDTO.setPassportNumber(client.getPassportNumber());
        scoringDataDTO.setPassportIssueDate(frrDTO.getPassportIssueDate());
        scoringDataDTO.setPassportIssueBranch(frrDTO.getPassportIssueBranch());
        scoringDataDTO.setEmployment(frrDTO.getEmployment());
        scoringDataDTO.setAccount(frrDTO.getAccount());
        scoringDataDTO.setInsuranceEnabled(loanOfferDTO.getInsuranceEnabled());
        scoringDataDTO.setSalaryClient(loanOfferDTO.getSalaryClient());

        return scoringDataDTO;
    }

    public static Credit createCredit(CreditDTO creditDTO) {
        return Credit.builder()
                .amount(creditDTO.getAmount())
                .term(creditDTO.getTerm())
                .monthlyPayment(creditDTO.getMonthlyPayment())
                .rate(creditDTO.getRate())
                .psk(creditDTO.getPsk())
                .isInsuranceEnabled(creditDTO.getInsuranceEnabled())
                .isSalaryClient(creditDTO.getSalaryClient())
                .paymentSchedule(creditDTO.getPaymentSchedule())
                .status(CreditStatus.CALCULATED)
                .build();
    }
}
