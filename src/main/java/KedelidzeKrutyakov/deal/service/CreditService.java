package KedelidzeKrutyakov.deal.service;

import KedelidzeKrutyakov.deal.Creator;
import KedelidzeKrutyakov.deal.api.DTO.CreditDTO;
import KedelidzeKrutyakov.deal.persistence.entity.Credit;
import KedelidzeKrutyakov.deal.persistence.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditService {
    private final CreditRepository creditRepository;

    @Autowired
    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public Credit createCredit(CreditDTO creditDTO) {
        return Creator.createCredit(creditDTO);
    }

    public void saveCredit(Credit credit) {
        creditRepository.save(credit);
    }
}
