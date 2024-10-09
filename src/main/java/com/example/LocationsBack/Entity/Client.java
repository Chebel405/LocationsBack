package com.example.LocationsBack.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    private Long id;

    @JsonProperty("nom")
    private String name;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;
}
