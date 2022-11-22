package com.mycompany.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorDTO {

    private double num1;
    private double num2;

    @JsonProperty("num33333") // JSON key 이름 나타내기 위해 사용
    private double num3;
}
