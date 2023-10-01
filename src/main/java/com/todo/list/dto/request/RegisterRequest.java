package com.todo.list.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


import java.util.Objects;

@Data
public class RegisterRequest {

    private String email;
    private String fullName;


    private String password;


    private String confirmPassword;

    @JsonIgnore
    public boolean isPasswordsMatched() {
        return Objects.nonNull(password) && password.equals(confirmPassword);
    }

}
