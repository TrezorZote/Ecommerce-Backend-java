package com.Elisa.biz;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(nullable = false, updatable = false)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderClass> orders = new ArrayList<>();


}


