package KedelidzeKrutyakov.deal.api.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreditDTO {
    private BigDecimal amount;
    private Integer term;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private BigDecimal psk;
    private Boolean insuranceEnabled;
    private Boolean salaryClient;
    private List<PaymentScheduleElement> paymentSchedule;
}
