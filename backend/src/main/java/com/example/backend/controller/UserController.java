package com.example.backend.controller;

import com.example.backend.dao.UserRepository;
import com.example.backend.dao.entity.User;
import com.example.backend.dto.Response;
import com.example.backend.exception.ObjectNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @Operation(description = "")
    @GetMapping("/static")
    public Response<User> getStaticUser() {
        return Response.success(new User(1L, "Test", "", 99L));
    }

    @Operation(description = "Get user by *id*", responses = {
            @ApiResponse(description = "OK", responseCode = "200"),
            @ApiResponse(description = "User not found", responseCode = "404")
    })
    @GetMapping("/{id}")
    public Response<User> getUser(
            @Parameter(description = "")
            @PathVariable("id") Long id
    ) {
        var response = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("user with id " + id + " doesn't exist!"));
        return Response.success(response);
    }

    @Operation(description = "Post new user", responses = {
            @ApiResponse(description = "OK", responseCode = "200")
    })
    @PostMapping
    public Response<User> addNewUser(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "")
            @RequestBody User user
    ) {
        var response = userRepository.save(user);
        return Response.success(response);
    }

    @Operation(description = "Provided user update", responses = {
            @ApiResponse(description = "OK", responseCode = "200"),
            @ApiResponse(description = "User not found", responseCode = "404")
    })
    @PutMapping
    public Response<User> updateUser(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "")
            @RequestBody User user
    ) {
        var userId = user.getId();
        userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException("user with id " + userId + " doesn't exist!"));
        var response = userRepository.save(user);
        return Response.success(response);
    }

    @Operation(description = "Delete user by *id*", responses = {
            @ApiResponse(description = "OK", responseCode = "200"),
            @ApiResponse(description = "User not found", responseCode = "404")
    })
    @DeleteMapping("/{id}")
    public Response<User> deleteUser(
            @Parameter(description = "")
            @PathVariable("id") Long id
    ) {
        var user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("user with id " + id + " doesn't exist!"));
        userRepository.deleteById(id);
        return Response.success(user);
    }
}
