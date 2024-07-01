package KedelidzeKrutyakov.deal.store.entities;

import KedelidzeKrutyakov.deal.store.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
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

    // TODO: Разберись с принятым предложением
    // private LoanOfferDTO appliedOffer;

    private LocalDate signDate;
    private String sesCode;

    // TODO: Еще и история изменения статусов
    // private List<StatusChange> statusHistory
}
