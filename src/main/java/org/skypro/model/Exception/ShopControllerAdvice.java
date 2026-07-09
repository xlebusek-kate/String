package org.skypro.model.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> shopErrorResponseEntity (NoSuchProductException e){
        ShopError shopError = new ShopError(404, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(shopError);
    }

}
