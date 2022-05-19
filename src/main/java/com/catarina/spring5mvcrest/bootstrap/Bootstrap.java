package com.catarina.spring5mvcrest.bootstrap;

import com.catarina.spring5mvcrest.domain.Category;
import com.catarina.spring5mvcrest.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;

public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category fresh = new Category();
        fruits.setName("Fresh");

        Category exotic = new Category();
        fruits.setName("Exotic");

        categoryRepository.save(fruits);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);

        System.out.println("Initial data loaded");
    }

}
