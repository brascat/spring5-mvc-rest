package com.catarina.spring5mvcrest.services;

import com.catarina.spring5mvcrest.api.v1.mapper.CategoryMapper;
import com.catarina.spring5mvcrest.api.v1.model.CategoryDTO;
import com.catarina.spring5mvcrest.domain.Category;
import com.catarina.spring5mvcrest.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CategoryServiceImplTest {

    @Mock
    CategoryRepository categoryRepository;

    CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryService = new CategoryServiceImpl(categoryRepository, CategoryMapper.INSTANCE);
    }

    @Test
    public void getAllCategoriesTest() throws Exception {
        List<Category> categories = Arrays.asList(new Category(), new Category());

        when(categoryRepository.findAll()).thenReturn(categories);

        List<CategoryDTO> categoriesDTOs = categoryService.getAllCategories();

        assertEquals(2, categoriesDTOs.size());
    }

    @Test
    public void getCategoryByName() throws Exception  {
        Category category = new Category();
        category.setName("Peach");
        category.setId(1L);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        CategoryDTO categoryDTO = categoryService.getCategoryByName("Peach");

        assertEquals("Peach", categoryDTO.getName());
        assertEquals(1L, categoryDTO.getId());

    }
}