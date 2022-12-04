package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        BeanUtils.copyProperties(propertyDTO, propertyEntity);
        propertyEntity = propertyRepository.save(propertyEntity);
        BeanUtils.copyProperties(propertyEntity, propertyDTO);
        return propertyDTO;
    }
}
