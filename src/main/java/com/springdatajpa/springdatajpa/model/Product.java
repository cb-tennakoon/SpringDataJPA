package com.springdatajpa.springdatajpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name="product",
        schema ="jpa",
        uniqueConstraints ={
           @UniqueConstraint(
                   name = "sku_unique",
                   columnNames = "sku"
           )
    }
)
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"

    )
    @SequenceGenerator(name = "product_generator", sequenceName = "product__seq",allocationSize = 1)
    @Column(name = "id",updatable = false,nullable = false)
    private Long id;


    //GenerationType.AUTO --> The GenerationType.AUTO is the default generation type and lets the persistence provider choose the generation strategy.
    //GenerationType.IDENTITY --> The GenerationType.IDENTITY is the easiest to use but not the best one from a performance point of view.
    // It relies on an auto-incremented database column and lets the database generate a new value with each insert operation.
    // From a database point of view, this is very efficient because the auto-increment columns are highly optimized, and it doesn’t require any additional statements.
    //GenerationType.SEQUENCE --> The GenerationType.SEQUENCE is to generate primary key values and uses a database sequence to generate unique values.
    //It requires additional select statements to get the next value from a database sequence.
    //But this has no performance impact on most applications.
    //And if your application has to persist a huge number of new entities, you can use some Hibernate-specific optimizations to reduce the number of statements.
    //GenerationType.TABLE -->The GenerationType.TABLE gets only rarely used nowadays.
    //It simulates a sequence by storing and updating its current value in a database table which requires the use of pessimistic locks that put all transactions into sequential order.
    //This slows down your application, and you should, therefore, prefer the GenerationType.SEQUENCE, if your database supports sequences, which most popular databases do.
    @Column(name ="sku",nullable = false)
    //stock keeping unit
    private String sku;

    @Column(name ="name", length = 100)
    private String name;

    @Column(name ="description", length = 300)
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

}
