package KedelidzeKrutyakov.deal.api.DTO;

import KedelidzeKrutyakov.deal.enums.Gender;
import KedelidzeKrutyakov.deal.enums.MartialStatus;

import java.time.LocalDate;

public record FinishRegistrationRequestDTO (
        Gender gender,
        MartialStatus martialStatus,
        Integer dependentAmount,
        LocalDate passportIssueDate,
        String passportIssueBranch ) {}
