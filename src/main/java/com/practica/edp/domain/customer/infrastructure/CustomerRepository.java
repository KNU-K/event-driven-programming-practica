package com.practica.edp.domain.customer.infrastructure;

import com.practica.edp.domain.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
