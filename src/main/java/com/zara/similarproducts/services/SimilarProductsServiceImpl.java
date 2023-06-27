package com.zara.similarproducts.services;

import com.api.openapi.ProductDetail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@AllArgsConstructor
public class SimilarProductsServiceImpl implements SimilarProductsService {

  private final SimilarProductIdsService similarProductIdsService;
  private final ProductDetailService productDetailService;

  @Override
  public Set<ProductDetail> getSimilarProducts(String productId) {
    var similarProductIds = similarProductIdsService.getSimilarProductIds(productId);

    var similarProducts = new HashSet<ProductDetail>();
    for (String similarProductId : similarProductIds) {
      var similarProduct = productDetailService.getProductDetail(similarProductId);
      similarProducts.add(similarProduct);
    }

    return similarProducts;
  }

}
