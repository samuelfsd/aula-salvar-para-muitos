package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.dtos.CategoryDTO;
import com.devsuperior.aula.dtos.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  @Autowired
  private CategoryRepository categoryRepository;

  public ProductDTO insert(ProductDTO dto) {
    Product product = new Product();

    product.setId(dto.getId());
    product.setName(dto.getName());
    product.setPrice(dto.getPrice());

    for (CategoryDTO category : dto.getCategories()) {
      Category cat = categoryRepository.getReferenceById(category.getId());
      
      // Category cat = new Category();
      // cat.setId(category.getId());
      // cat.setName(category.getName());
      product.getCategories().add(cat);
    }

    product = repository.save(product);

    return new ProductDTO(product);
  }
}
