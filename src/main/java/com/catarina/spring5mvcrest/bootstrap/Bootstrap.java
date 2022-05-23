package com.catarina.spring5mvcrest.bootstrap;

import com.catarina.spring5mvcrest.domain.Category;
import com.catarina.spring5mvcrest.domain.Customer;
import com.catarina.spring5mvcrest.repositories.CategoryRepository;
import com.catarina.spring5mvcrest.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
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

        Customer john = new Customer();
        john.setFirstname("John");
        john.setLastname("Doe");
        john.setId(1L);

        customerRepository.save(john);

        System.out.println("Initial data loaded");
    }

}
