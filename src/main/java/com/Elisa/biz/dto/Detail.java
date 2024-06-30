package com.Elisa.biz.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Detail  implements Serializable {
    private Long productId;
    private int qty;
}
