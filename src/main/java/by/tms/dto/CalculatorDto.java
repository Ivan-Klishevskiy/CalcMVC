package by.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorDto {

//    @NotBlank(message = "Must not be blank")
//    @NotEmpty(message = "Must not be empty")
//    @Pattern(regexp = "([0-9]*[.])?[0-9]+")
    private double first;

//    @NotBlank(message = "Must not be blank")
//    @NotEmpty(message = "Must not be empty")
//    @Pattern(regexp = "[+\\-*/]")
    private String sign;

//    @NotBlank(message = "Must not be blank")
//    @NotEmpty(message = "Must not be empty")
//    @Pattern(regexp = "([0-9]*[.])?[0-9]+")
    private double second;

    private double result;
}
