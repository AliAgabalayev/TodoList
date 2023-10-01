package com.todo.list.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Objects;

@Data
public class ResetPasswordRequest {


    private String email;


    private String password;


    private String confirmPassword;

    @JsonIgnore
    public boolean isPasswordMatched() {
        return Objects.equals(password, confirmPassword);
    }

}
