package KedelidzeKrutyakov.deal.service;

import KedelidzeKrutyakov.deal.Creator;
import KedelidzeKrutyakov.deal.api.DTO.LoanApplicationRequestDTO;
import KedelidzeKrutyakov.deal.exception.EmailUniquenessException;
import KedelidzeKrutyakov.deal.exception.PassportNumberUniquenessException;
import KedelidzeKrutyakov.deal.exception.UniquenessCheckException;
import KedelidzeKrutyakov.deal.persistence.entity.Client;
import KedelidzeKrutyakov.deal.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(LoanApplicationRequestDTO larDTO) {
        return Creator.createClient(larDTO);
    }

    public void saveClient(Client client) throws UniquenessCheckException {
        checkUniqueness(client);
        clientRepository.save(client);
    }

    private void checkUniqueness(Client client) {
        checkEmailUniqueness(client.getEmail());
        checkPassportUniqueness(client.getPassportSeries(), client.getPassportNumber());
    }

    private void checkEmailUniqueness(String email) {
        if (clientRepository.existsByEmail(email)) {
            throw new EmailUniquenessException(
                    "Client with email " + email + " already exists" );
        }
    }

    private void checkPassportUniqueness(String passportSeries, String passportNumber) {
        if (clientRepository.existsByPassportSeriesAndPassportNumber(passportSeries, passportNumber)) {
            throw  new PassportNumberUniquenessException(
                    "Client with passport " + passportSeries + passportNumber + " already exists" );
        }
    }
}
