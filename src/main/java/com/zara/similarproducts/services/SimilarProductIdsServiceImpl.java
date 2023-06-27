package com.zara.similarproducts.services;

import exceptions.SimilarProductIdsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SimilarProductIdsServiceImpl implements SimilarProductIdsService {

  @Value("${similarids.url}")
  private String similarIdsUrl;

  private final RestTemplate restTemplate;

  public SimilarProductIdsServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public List<String> getSimilarProductIds(String productId) {
    var resourceUrl = buildResourceUrl(productId);
    var httpEntity = buildHttpEntity();

    try {
      var response = restTemplate.exchange(
          resourceUrl,
          HttpMethod.GET,
          httpEntity,
          new ParameterizedTypeReference<List<String>>() {
          }
      );

      return response.getBody();
    } catch (RestClientException exception) {
      throw new SimilarProductIdsException("There was an error while trying to get the ids of similar products " +
          "for the product with id " + productId
          + " " + Arrays.toString(exception.getStackTrace()));
    }
  }

  private String buildResourceUrl(String productId) {
    return similarIdsUrl.replace("{productId}", productId);
  }

  private HttpEntity<String> buildHttpEntity() {
    var httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    return new HttpEntity<>(httpHeaders);
  }

}
