package com.example.LocationsBack.ServiceImpl;

import com.example.LocationsBack.Entity.Client;
import com.example.LocationsBack.Repository.ClientRepository;
import com.example.LocationsBack.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.ofNullable(clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(Long id) { clientRepository.deleteById(id);

    }

    @Override
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            Client existeClient = optionalClient.get();
            existeClient.setName(client.getName());
            existeClient.setLastName(client.getLastName());
            existeClient.setBirthday(client.getBirthday());
            existeClient.setEmail(client.getEmail());
            existeClient.setPhone(client.getPhone());
        }
        return client;
    }
}
