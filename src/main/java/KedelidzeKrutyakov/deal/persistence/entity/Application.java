package KedelidzeKrutyakov.deal.persistence.entity;

import KedelidzeKrutyakov.deal.api.DTO.ApplicationStatusHistoryDTO;
import KedelidzeKrutyakov.deal.api.DTO.LoanOfferDTO;
import KedelidzeKrutyakov.deal.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Client client;

    @OneToOne
    private Credit credit;

    private ApplicationStatus status;
    private LocalDate creationDate;

    @JdbcTypeCode(SqlTypes.JSON)
    private LoanOfferDTO appliedOffer;

    private LocalDate signDate;
    private String sesCode;

    @ElementCollection
    @JdbcTypeCode(SqlTypes.JSON)
    private List<ApplicationStatusHistoryDTO> statusHistory;
}
