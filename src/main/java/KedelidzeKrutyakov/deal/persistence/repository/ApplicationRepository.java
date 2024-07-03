package KedelidzeKrutyakov.deal.persistence.repository;

import KedelidzeKrutyakov.deal.persistence.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
