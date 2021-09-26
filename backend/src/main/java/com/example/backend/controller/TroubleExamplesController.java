package com.example.backend.controller;

import com.example.backend.dto.Response;
import com.example.backend.dto.SomeDtoWithByteArray;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/trouble")
@RequiredArgsConstructor
public class TroubleExamplesController {
    @Operation(description = "")
    @PostMapping("/byte-array")
    public Response<SomeDtoWithByteArray> getByteArray(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "")
            @RequestBody byte[] file
    ) {
        return Response.success(new SomeDtoWithByteArray(1L, "Test", "hello".getBytes()));
    }

    @Operation(description = "")
    @PostMapping("/raw-byte-array")
    public byte[] getRawByteArray(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "")
            @RequestBody byte[] file
    ) {
        return file;
    }

    @Operation(description = "", responses = {
            @ApiResponse(description = "OK", responseCode = "200", content = @Content(schema = @Schema(format = "binary")))
    })
    @PostMapping("/raw-byte-array-backend-fix")
    public byte[] getRawByteArrayFix(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "")
            @RequestBody byte[] file
    ) {
        return file;
    }

    @Operation(description = "")
    @GetMapping("/list-string")
    public Response<List<String>> getListString(
            @Parameter(description = "")
            @RequestParam List<String> strings
    ) {
        return Response.success(strings);
    }

    @Operation(description = "")
    @GetMapping("/raw-list-string")
    public List<String> getRawListString(
            @Parameter(description = "")
            @RequestParam List<String> strings
    ) {
        return strings;
    }

    @Operation(description = "")
    @PostMapping("/list-files")
    public Response<List<File>> getListFiles(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "")
            @RequestBody List<File> files
    ) {
        return Response.success(files);
    }

    @Operation(description = "")
    @PostMapping("/raw-list-files")
    public List<File> getRawListFiles(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "")
            @RequestBody List<File> files
    ) {
        return files;
    }
}
