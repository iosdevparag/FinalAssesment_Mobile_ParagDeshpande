package com.bajaj.restaurant.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseController {

    public ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object data){
        Map<String, Object> response = new HashMap<>();
        response.put("message" ,message);
        response.put("data" ,data);

        return new ResponseEntity<>(response, status);
    }
}
