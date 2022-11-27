package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/properties")
    public PropertyDTO saveProperty(@RequestBody PropertyDTO propertyDTO) {
        return propertyService.saveProperty(propertyDTO);
    }
}
