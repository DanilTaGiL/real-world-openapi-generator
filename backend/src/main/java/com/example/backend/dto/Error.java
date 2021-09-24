package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Error {
    private final Integer code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String message;
}
