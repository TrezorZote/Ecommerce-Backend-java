package com.Elisa.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto implements Serializable {
    private String category;
    private String description;
    private String location;
    private int quantity;
    private int price;

}
/*{
        "category": "skinny jeans",
        "description": "black jeans ",
        "location": "au continent",
        "quantity": "40",
        "price": "15"

}*/
