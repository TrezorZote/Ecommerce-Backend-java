package com.Elisa.biz;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(nullable = false, updatable = false)
private Long id;
private String category;
private String description;
private String location;
private int quantity;
private int price;


}
