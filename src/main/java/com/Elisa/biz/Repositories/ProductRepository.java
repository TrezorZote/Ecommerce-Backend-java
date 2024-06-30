package com.Elisa.biz.Repositories;

import com.Elisa.biz.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
