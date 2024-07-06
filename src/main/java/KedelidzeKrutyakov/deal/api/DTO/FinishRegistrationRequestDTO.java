package KedelidzeKrutyakov.deal.api.DTO;

import KedelidzeKrutyakov.deal.enums.Gender;
import KedelidzeKrutyakov.deal.enums.MartialStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FinishRegistrationRequestDTO  {
    private Gender gender;
    private MartialStatus martialStatus;
    private Integer dependentAmount;
    private LocalDate passportIssueDate;
    private String passportIssueBranch;
    private EmploymentDTO employment;
    private String account;
}

