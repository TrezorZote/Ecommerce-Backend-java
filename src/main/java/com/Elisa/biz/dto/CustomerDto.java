package com.Elisa.biz.dto;

import com.Elisa.biz.OrderClass;
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
public class CustomerDto implements Serializable {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
/*{
        "email": "ulrich@gmail.com",
        "firstName": "ulrich",
        "lastName": "du continent",
        "password": "12345",
        "orders": []

}*/