package com.example.LocationsBack.Service;

import com.example.LocationsBack.Entity.Client;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@ComponentScan
public interface ClientService {

    Client createClient(Client client);

    List<Client> findAll();

    Optional<Client> findById(Long id);

    Client save(Client client);

    void deleteById(Long id);

    Client updateClient(Long id, Client client);


}
