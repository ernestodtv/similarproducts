 package com.zara.similarproducts.error;

 import com.zara.similarproducts.domain.ErrorResponse;
 import exceptions.ProductDetailException;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.ExceptionHandler;
 import org.springframework.web.bind.annotation.RestControllerAdvice;

 @RestControllerAdvice
 @Slf4j
 public class ProductDetailExceptionControllerAdvice {

     @ExceptionHandler({ProductDetailException.class})
     public ResponseEntity<ErrorResponse> handleProductDetailException(ProductDetailException exception) {
       var errorResponse = ErrorResponse.builder()
           .status(HttpStatus.INTERNAL_SERVER_ERROR)
           .message(exception.getMessage())
           .build();
         return ResponseEntity.internalServerError().body(errorResponse);
     }
 }
