package com.turkcell.rentacar.inventoryService.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;

import com.turkcell.rentacar.inventoryService.concretes.Brand;
import com.turkcell.rentacar.inventoryService.business.abstracts.BrandRepository;
import com.turkcell.rentacar.inventoryService.business.messages.Messages;
import com.turkcell.rentacar.inventoryService.core.business.abstracts.MessageService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    MessageService messageService;
    public void brandNameCanNotBeDuplicated(String brandName) {
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);
        if (brand.isPresent()) {
            throw new BusinessException("brandExist");
        }
    }
        public void brandNameIsExist(String brandName){
            Optional<Brand> brand=brandRepository.findByNameIgnoreCase(brandName);
            if(!brand.isPresent()){
                throw new BusinessException(messageService.getMessages(Messages.BrandErrors.BrandNameExists));
            }
        }
    }

