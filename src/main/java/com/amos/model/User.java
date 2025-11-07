package com.amos.model;

import com.amos.dto.RestaurantDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;

    // When I first fetch the user I might not need the list of orders at first
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer") //one user can make many orders
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    private List<RestaurantDTO> favourites = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // whenever we delete the user all addresses related to the user will be deleted
    private List<Address> addresses = new ArrayList<>();




}
