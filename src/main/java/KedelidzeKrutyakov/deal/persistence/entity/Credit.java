package KedelidzeKrutyakov.deal.persistence.entity;

import KedelidzeKrutyakov.deal.api.DTO.PaymentScheduleElement;
import KedelidzeKrutyakov.deal.enums.CreditStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;
    private Integer term;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private BigDecimal psk;

    @ElementCollection
    @JdbcTypeCode(SqlTypes.JSON)
    private List<PaymentScheduleElement> paymentSchedule;

    private Boolean isInsuranceEnabled;
    private Boolean isSalaryClient;
    private CreditStatus status;
}
