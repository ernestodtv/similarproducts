package com.zara.similarproducts.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

  private HttpStatus status;
  private String message;

}
