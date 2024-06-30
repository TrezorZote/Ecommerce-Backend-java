package com.Elisa.biz.Repositories;

import com.Elisa.biz.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
@Query( value =
        "SELECT CAST(COUNT(*) AS BIT) "
        + "FROM Customer AS c "
        + "WHERE c.email = ?1", nativeQuery = true)
    Boolean customerEmailExists(String email);

}
