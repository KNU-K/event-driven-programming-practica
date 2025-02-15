package com.practica.edp.domain.product.infrastructure;

import com.practica.edp.domain.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {
}
