package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SomeDtoWithByteArray {
    private Long id;
    private String name;
    @ToString.Exclude
    private byte[] bytes;
}
