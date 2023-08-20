package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
