package KedelidzeKrutyakov.deal.persistence.entity;

import KedelidzeKrutyakov.deal.enums.Gender;
import KedelidzeKrutyakov.deal.enums.MartialStatus;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String email;
    private Gender gender;
    private MartialStatus martialStatus;
    private Byte dependentAmount;
    private String passportSeries;
    private String passportNumber;
    private LocalDate passportIssueDate;
    private String passportIssueBranch;
    @JdbcTypeCode(SqlTypes.JSON)
    private Employment employment;
    private String account;
}
