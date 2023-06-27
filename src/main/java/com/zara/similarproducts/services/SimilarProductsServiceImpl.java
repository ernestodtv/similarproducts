package com.zara.similarproducts.services;

import com.api.openapi.ProductDetail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@AllArgsConstructor
public class SimilarProductsServiceImpl implements SimilarProductsService {

  private final SimilarProductIdsService similarProductIdsService;

  @Override
  public Set<ProductDetail> getSimilarProducts(String productId) {
    var similarProductIds = similarProductIdsService.getSimilarProductIds(productId);
    return null;
  }

}
