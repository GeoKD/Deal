package KedelidzeKrutyakov.deal.persistence.repository;

import KedelidzeKrutyakov.deal.persistence.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
