package com.zara.similarproducts.controllers;

import com.zara.similarproducts.api.ProductApi;
import com.zara.similarproducts.model.ProductDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping
public class SimilarProductsController implements ProductApi {

  @Override
  public ResponseEntity<Set<ProductDetail>> getProductSimilar(String productId) {
    return null;
  }
}
