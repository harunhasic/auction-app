package com.atlantbh.auction.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MapValidationErrorService {

    public Optional<ResponseEntity<?>> MapValidationService(BindingResult result) {

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