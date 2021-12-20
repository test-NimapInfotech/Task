package com.machine.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machine.entity.Product;

public interface ProductRepositry extends JpaRepository<Product, Long> {

}
