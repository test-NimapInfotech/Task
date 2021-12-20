package com.machine.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machine.entity.Category;

public interface CategoryRepositry extends JpaRepository<Category, Long> {

	Category getByName(String name);
}
