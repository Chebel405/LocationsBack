package com.example.LocationsBack.Configuration;

import com.example.LocationsBack.Repository.ClientRepository;
import com.example.LocationsBack.Service.ClientService;
import com.example.LocationsBack.ServiceImpl.ClientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ClientConfiguration {

    @Bean
    public ClientService clientService(ClientRepository clientRepository){
        return new ClientServiceImpl(clientRepository);
    }
}
