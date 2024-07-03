package KedelidzeKrutyakov.deal.persistence.entity;

import KedelidzeKrutyakov.deal.enums.CreditStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;
    private LocalDate term;
    private BigDecimal monthlyPayment;
    private Float rate;
    private BigDecimal psk;
    private LocalDate[] paymentSchedule;
    private Boolean isInsuranceEnabled;
    private Boolean isSalaryClient;
    private CreditStatus status;
}
