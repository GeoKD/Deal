package KedelidzeKrutyakov.deal.persistence.entity;

import KedelidzeKrutyakov.deal.enums.EmploymentStatus;
import KedelidzeKrutyakov.deal.enums.Position;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Employment implements Serializable {
    private EmploymentStatus employmentStatus;
    private String employerINN;
    private BigDecimal salary;
    private Position position;
    private Integer workExperienceTotal;
    private Integer workExperienceCurrent;
}
