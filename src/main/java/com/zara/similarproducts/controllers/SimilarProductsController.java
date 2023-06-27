package com.zara.similarproducts.controllers;


import com.api.openapi.ProductApi;
import com.api.openapi.ProductDetail;
import com.zara.similarproducts.services.SimilarProductsService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping
public class SimilarProductsController implements ProductApi {

  private final SimilarProductsService similarProductsService;

  @Override
  public ResponseEntity<Set<ProductDetail>> getProductSimilar(String productId) {
    var similarProducts = similarProductsService.getSimilarProducts(productId);
    return null;
  }

}
