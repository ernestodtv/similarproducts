package com.zara.similarproducts.services;

import com.api.openapi.ProductDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

  @Value("${productdetail.url}")
  private String productDetailUrl;

  private final RestTemplate restTemplate;

  public ProductDetailServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public ProductDetail getProductDetail(String productId) {
    var resourceUrl = buildResourceUrl(productId);
    var httpEntity = buildHttpEntity();

    var response = restTemplate.exchange(
        resourceUrl,
        HttpMethod.GET,
        httpEntity,
        new ParameterizedTypeReference<ProductDetail>() {}
    );

    return response.getBody();
  }

  private String buildResourceUrl(String productId) {
    return productDetailUrl.replace("{productId}", productId);
  }

  private HttpEntity<String> buildHttpEntity() {
    var httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    return new HttpEntity<>(httpHeaders);
  }

}
