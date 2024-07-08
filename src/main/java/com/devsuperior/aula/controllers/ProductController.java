package com.devsuperior.aula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.aula.dtos.ProductDTO;
import com.devsuperior.aula.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

  @Autowired
  private ProductService service;

  @PostMapping
  public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) {
    return ResponseEntity.ok(service.insert(dto));
  }
}
