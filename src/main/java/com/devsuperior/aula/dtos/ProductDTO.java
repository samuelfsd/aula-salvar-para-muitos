package com.devsuperior.aula.dtos;

import java.util.ArrayList;
import java.util.List;

import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;

public class ProductDTO {

  private Long id;
  private String name;
  private Double price;

  private List<CategoryDTO> categories = new ArrayList<>();

  public ProductDTO(Long id, String name, Double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public ProductDTO(Product product) {
    id = product.getId();
    name = product.getName();
    price = product.getPrice();

    for (Category category : product.getCategories()) {
      categories.add(new CategoryDTO(category));
    }
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public List<CategoryDTO> getCategories() {
    return categories;
  }

}
