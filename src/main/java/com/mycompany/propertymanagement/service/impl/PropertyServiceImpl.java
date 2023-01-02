package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        BeanUtils.copyProperties(propertyDTO, propertyEntity);
        return propertyEntity;
    }

    @Override
    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        PropertyDTO propertyDTO = new PropertyDTO();
        BeanUtils.copyProperties(propertyEntity, propertyDTO);
        return propertyDTO;
    }

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = this.convertDTOtoEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);
        return this.convertEntityToDTO(propertyEntity);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> properties = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();
        for (PropertyEntity entity: properties) {
            propList.add(this.convertEntityToDTO(entity));
        }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO dto = null;
        Optional<PropertyEntity> optEntity = propertyRepository.findById(propertyId);
        if (optEntity.isPresent()) {
            PropertyEntity pe = optEntity.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setDescription(propertyDTO.getDescription());

            dto = convertEntityToDTO(pe);

            propertyRepository.save(pe);
        }
        return dto;
    }
}
