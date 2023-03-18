package com.prakritikishore.a2zEcomm.repository;

import com.prakritikishore.a2zEcomm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
