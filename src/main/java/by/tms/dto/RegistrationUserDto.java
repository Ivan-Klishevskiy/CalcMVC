package by.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationUserDto {

    @NotBlank(message = "Must not be blank")
    @NotEmpty(message = "Must not be empty")
    private String name;

    @NotBlank(message = "Must not be blank")
    @NotEmpty(message = "Must not be empty")
    private String username;

    @NotBlank(message = "Must not be blank")
    @NotEmpty(message = "Must not be empty")
    private String password;
}
