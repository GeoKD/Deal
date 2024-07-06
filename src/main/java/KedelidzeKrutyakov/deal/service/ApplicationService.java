package KedelidzeKrutyakov.deal.service;

import KedelidzeKrutyakov.deal.Creator;
import KedelidzeKrutyakov.deal.api.DTO.ApplicationStatusHistoryDTO;
import KedelidzeKrutyakov.deal.api.DTO.LoanApplicationRequestDTO;
import KedelidzeKrutyakov.deal.api.DTO.LoanOfferDTO;
import KedelidzeKrutyakov.deal.enums.ApplicationStatus;
import KedelidzeKrutyakov.deal.persistence.entity.Application;
import KedelidzeKrutyakov.deal.persistence.entity.Client;
import KedelidzeKrutyakov.deal.persistence.repository.ApplicationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application createApplication(LoanApplicationRequestDTO larDTO, Client client) {
        return Creator.CreateApplication(larDTO, client);
    }

    public Application findApplicationById( Long applicationId ) throws EntityNotFoundException {
        Optional<Application> applicationOptional =
                applicationRepository.findById( applicationId );

        if (applicationOptional.isPresent()) {
            return applicationOptional.get();
        }
        else {
            throw new EntityNotFoundException(
                    "Application with id " + applicationId + " doesn't exist" );
        }
    }

    public void saveApplication(Application application) {
        applicationRepository.save(application);
    }

    public void applyOffer(LoanOfferDTO loDTO) throws EntityNotFoundException {
        Application application = findApplicationById(loDTO.getApplicationId());
        application.setAppliedOffer(loDTO);
        updateApplicationStatus(application, ApplicationStatus.APPROVED);
        saveApplication(application);
    }

    public void updateApplicationStatus( Application application, ApplicationStatus newStatus) {
        ApplicationStatusHistoryDTO applicationStatusHistoryDTO = new ApplicationStatusHistoryDTO();
        applicationStatusHistoryDTO.setStatus(application.getStatus());
        applicationStatusHistoryDTO.setTime(LocalDateTime.now());
        applicationStatusHistoryDTO.setChangeType(newStatus);
        application.setStatus(newStatus);
        application.getStatusHistory().add(applicationStatusHistoryDTO);
    }
}