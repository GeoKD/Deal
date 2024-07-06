package KedelidzeKrutyakov.deal.api.DTO;

import KedelidzeKrutyakov.deal.enums.EmploymentStatus;
import KedelidzeKrutyakov.deal.enums.Position;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Period;


@Data
public class EmploymentDTO {
    private EmploymentStatus employmentStatus;
    private String employerINN;
    private BigDecimal salary;
    private Position position;
    private Integer workExperienceTotal;
    private Integer workExperienceCurrent;
}
