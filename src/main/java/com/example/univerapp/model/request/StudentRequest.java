package com.example.univerapp.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
@Valid
public class StudentRequest {
    @NotBlank(message = "First name cannot be blak")
    private String first_name;
    @NotBlank(message = "Last name cannot be blank")
    private String last_name;
    @Email(message = "Email should be blank")
    private String email;
    private String phone_number;
    private Integer age;
}
