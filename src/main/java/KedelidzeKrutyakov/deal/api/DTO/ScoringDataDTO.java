package KedelidzeKrutyakov.deal.api.DTO;

import KedelidzeKrutyakov.deal.enums.Gender;
import KedelidzeKrutyakov.deal.enums.MartialStatus;
import KedelidzeKrutyakov.deal.persistence.entity.Employment;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ScoringDataDTO {
    private BigDecimal amount;
    private Integer term;
    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;
    private LocalDate birthDate;
    private String passportSeries;
    private String passportNumber;
    private LocalDate passportIssueDate;
    private String passportIssueBranch;
    private MartialStatus martialStatus;
    private Integer dependentAmount;
    private EmploymentDTO employment;
    private String account;
    private Boolean insuranceEnabled;
    private Boolean salaryClient;
}
