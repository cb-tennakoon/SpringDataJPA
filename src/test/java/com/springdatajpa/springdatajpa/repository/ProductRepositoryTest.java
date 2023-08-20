package com.springdatajpa.springdatajpa.repository;

import com.mysql.cj.log.Log;
import com.springdatajpa.springdatajpa.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //Create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");
        //save product
        Product savedObject = productRepository.save(product);
        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        //find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        //Optional class -It is a public final class and used to deal with NullPointerException in Java application.

        //update entity information
        product.setName("Update product 1");
        product.setDescription("Update product description");
        //save updates entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        System.out.println(product.getName());
        System.out.println(product.getId());
    }

    @Test
    void saveAllMethod() {
        //Create product
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("200ABC");
        product2.setPrice(new BigDecimal(100));
        product2.setActive(true);
        product2.setImageUrl("product2.png");
        //save product
        Product savedObject2 = productRepository.save(product2);
        //display product info
        System.out.println(savedObject2.getId());
        System.out.println(savedObject2.toString());

        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("300ABC");
        product3.setPrice(new BigDecimal(100));
        product3.setActive(true);
        product3.setImageUrl("product3.png");
        //save product
        Product savedObject3 = productRepository.save(product3);
        //display product info
        System.out.println(savedObject3.getId());
        System.out.println(savedObject3.toString());

        Product product4 = new Product();
        product4.setName("product 4");
        product4.setDescription("product 4 description");
        product4.setSku("400ABC");
        product4.setPrice(new BigDecimal(100));
        product4.setActive(true);
        product4.setImageUrl("product4.png");
        //save product
        Product savedObject4 = productRepository.save(product4);
        //display product info
        System.out.println(savedObject4.getId());
        System.out.println(savedObject4.toString());

        productRepository.saveAll(List.of(product2, product3, product4));
    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        //find an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
        productRepository.deleteAll();

    }

    @Test
    void countMethod() {
        long a = productRepository.count();
        System.out.println(a);
    }
}

