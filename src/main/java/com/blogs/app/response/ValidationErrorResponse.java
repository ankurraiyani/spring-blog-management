package com.blogs.app.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ValidationErrorResponse {
    
    private List<Violation> violations = new ArrayList<>();

    @Data
    @AllArgsConstructor
    public class Violation {

        private final String fieldName;

        private final String message;
    }
}