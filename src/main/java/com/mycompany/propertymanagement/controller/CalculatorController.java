package com.mycompany.propertymanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
