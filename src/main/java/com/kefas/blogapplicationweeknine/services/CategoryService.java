package com.kefas.blogapplicationweeknine.services;

import com.kefas.blogapplicationweeknine.dto.CategoryDto;
import java.util.List;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);

	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

//    com.kefas.blogapplicationweeknine.dto.CategoryDto createCategory(com.kefas.blogapplicationweeknine.dto.CategoryDto categoryDto);
//
//	com.kefas.blogapplicationweeknine.dto.CategoryDto updateCategory(com.kefas.blogapplicationweeknine.dto.CategoryDto categoryDto, Integer categoryId);

	void deleteCategory(Integer categoryId);

	CategoryDto getCategory(Integer categoryId);

	List<CategoryDto> getCategories();

}
