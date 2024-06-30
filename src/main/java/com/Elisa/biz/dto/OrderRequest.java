package com.Elisa.biz.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest implements Serializable {
   private Long customerId;
   private List<Detail>  detail;
}
/*{
        "customerId": "2",
        "detail": [{ "productId":"1","qty":"2"},{ "productId":"2","qty":"2"}]

}*/
