package KedelidzeKrutyakov.deal.api.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LoanApplicationRequestDTO (
        BigDecimal amount,
        Integer term,
        String firstName,
        String lastName,
        String middleName,
        String email,
        LocalDate birthDate,
        String passportSeries,
        String passportNumber ) {}
