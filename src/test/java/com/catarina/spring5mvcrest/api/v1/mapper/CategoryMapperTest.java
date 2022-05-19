package com.catarina.spring5mvcrest.api.v1.mapper;

import com.catarina.spring5mvcrest.api.v1.model.CategoryDTO;
import com.catarina.spring5mvcrest.domain.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    void categoryToCategoryDTO() {
        Category category = new Category();
        category.setName("Bad");
        category.setId(1L);

        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        assertEquals(Long.valueOf(1L), categoryDTO.getId());
        assertEquals("Bad", categoryDTO.getName());
    }
}