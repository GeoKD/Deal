package KedelidzeKrutyakov.deal.api.controllers;

import KedelidzeKrutyakov.deal.store.entities.Client;
import KedelidzeKrutyakov.deal.store.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deal")
public class DealController {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("post")
    public void createString(@RequestBody Client client) {
        clientRepository.save(client);
    }
}
