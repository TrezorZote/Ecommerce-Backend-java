package com.Elisa.biz.dto;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderDto implements Serializable {
        private Long orderId;
        private Long customerId;
        private Long orderItemId;
        private Long productId;
        private Integer quantity;

        // Constructor
        public OrderDto(Long orderId, Long customerId, Long orderItemId, Long productId, Integer quantity) {
            this.orderId = orderId;
            this.customerId = customerId;
            this.orderItemId = orderItemId;
            this.productId = productId;
            this.quantity = quantity;
        }

        // Getters and setters (or use Lombok annotations like @Data)


}
