package com.Elisa.biz;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class OrderClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long orderId;
    private LocalDateTime orderDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(targetEntity = OrderItem.class,cascade = CascadeType.ALL, mappedBy = "order")
    @ToString.Exclude
    private List<OrderItem> selected = new ArrayList<>();


}
