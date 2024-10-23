package com.example.LocationsBack.Configuration;

import com.example.LocationsBack.Repository.VehiculeRepository;
import com.example.LocationsBack.Service.VehiculeService;
import com.example.LocationsBack.ServiceImpl.VehiculeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class VehiculeConfiguration {
    @Bean
    public VehiculeService vehiculeService(VehiculeRepository vehiculeRepository){
        return new VehiculeServiceImpl(vehiculeRepository);
    }
}
