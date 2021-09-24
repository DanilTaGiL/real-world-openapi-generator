package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response<R> {
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final R result;
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Error error;

    public static <R> Response<R> success(R result) {
        return new Response(result, null);
    }

    public static <R> Response<R> error(Integer code, String description) {
        return new Response(null, new Error(code, description));
    }
}
