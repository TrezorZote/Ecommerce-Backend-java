package com.Elisa.biz.Repositories;

import com.Elisa.biz.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
