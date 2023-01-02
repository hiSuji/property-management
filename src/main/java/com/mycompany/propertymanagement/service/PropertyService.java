package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;

import java.util.List;

public interface PropertyService {
    PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO);
    PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity);
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
}
