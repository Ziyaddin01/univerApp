package com.example.univerapp.model.request;

import jakarta.validation.Valid;
import lombok.Data;

@Data
@Valid
public class TeacherRequest {
    private String firstName;
    private String lastName;
    private String subject;
    private String email;
}
