package com.Elisa.biz.Repositories;

import com.Elisa.biz.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@AllArgsConstructor
@Data
@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private  CustomerRepository repositoryTest;
    @AfterEach
    void tearDown() {
        repositoryTest.deleteAll();
    }

 /*   @Test
    void customerEmailExists() {
        String emailEx = "banga@gmail.com";
        Customer tresor = new Customer();
        tresor.setEmail(emailEx);
        tresor.setPassword("12345");
        repositoryTest.save(tresor);

        assertTrue(repositoryTest.customerEmailExists(emailEx));
    }
    @Test
    void customerEmailNotExists() {
        String emailEx = "banga@gmail.com";
        assertFalse(repositoryTest.customerEmailExists(emailEx));
    }
    */

}

