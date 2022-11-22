package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

//    http://localhost:8089/add?num1=15&num2=20
    @GetMapping("/add")
    public double add(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return num1 + num2;
    }

//    http://localhost:8089/sub/10/5
    @GetMapping("/sub/{num1}/{num2}")
    public double substract(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1 - num2;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO) {
        double result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3();
        ResponseEntity<Double> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);
        return responseEntity;
    }

}
