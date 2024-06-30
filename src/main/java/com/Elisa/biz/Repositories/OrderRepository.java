package com.Elisa.biz.Repositories;

import com.Elisa.biz.OrderClass;
import com.Elisa.biz.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderClass,Long> {
    @Query("SELECT new com.Elisa.biz.dto.OrderDto(o.id, o.customer.id, i.id, i.product.id, i.quantity) " +
            "FROM OrderClass o " +
            "JOIN o.selected i " +
            "JOIN i.product p")
    List<OrderDto> findAllOrdersWithDetails();
}
