package com.atlantbh.auction.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Class that checks if the user validation on the  controller level has any errors, and maps them if they are present.
 *
 * @author Harun Hasic
 */
public final class MapValidationErrors {

    private MapValidationErrors() {

    }

    public static Optional<ResponseEntity<?>> checkForErrors(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return Optional.of(new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST));
        }
        return Optional.empty();
    }
}