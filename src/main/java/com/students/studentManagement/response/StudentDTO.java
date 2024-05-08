package com.students.studentManagement.response;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentDTO {
    @NotEmpty(message = "Field must not be empty")
    @NotBlank(message = "Field must not be empty")
    private String name;
    @NotNull(message="Age is Required")
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    @Max(value = 25, message = "Age must be less than or equal to 25")
    private int age;
    @NotEmpty(message = "Field must not be empty")
    @NotBlank(message = "Field must not be empty")
    private String gender;
    @NotEmpty(message = "Email must not be empty")
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Invalid email")
    private String email;

    @NotEmpty(message = "Password must not be empty")
    @NotBlank(message = "Password must not be empty")
    private String password;
}
