package com.example.univerapp.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    @NotNull(message = "FirstName cannot be null")
    private String first_name;
    @NotNull(message = "LastName cannot be null")
    private String last_name;
    private String email;
    private String phone_number;
    private Integer age;
}
