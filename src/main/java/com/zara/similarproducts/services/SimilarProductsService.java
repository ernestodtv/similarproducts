package com.zara.similarproducts.services;

import com.api.openapi.ProductDetail;

import java.util.Set;

public interface SimilarProductsService {

  Set<ProductDetail> getSimilarProducts(String productId);

}
