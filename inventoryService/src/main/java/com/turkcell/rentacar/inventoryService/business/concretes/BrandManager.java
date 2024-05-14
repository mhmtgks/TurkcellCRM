package com.turkcell.rentacar.inventoryService.business.concretes;

import com.turkcell.rentacar.inventoryService.business.abstracts.BrandService;
import com.turkcell.rentacar.inventoryService.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.responses.CreateBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.responses.GetAllBrandResponse;
import com.turkcell.rentacar.inventoryService.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.inventoryService.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.inventoryService.dataAccess.BrandRepository;
import com.turkcell.rentacar.inventoryService.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    private ModelMapperService modelMapperService;

    private BrandBusinessRules brandBussinessRules;

    @Override
    public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBussinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        Brand createdBrand = brandRepository.save(brand);

        CreateBrandResponse createdBrandResponse =
                this.modelMapperService.forResponse().map(createdBrand, CreateBrandResponse.class);
        return createdBrandResponse;
    }
    @Override
    public List<GetAllBrandResponse> getAll() {
        List<GetAllBrandResponse> brandResponses = new ArrayList<>();
        List<Brand> brands = brandRepository.findAll();
        for (Brand brand : brands) {
            GetAllBrandResponse brandResponse =
                    this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class);
            brandResponses.add(brandResponse);
        }
        return brandResponses;
    }
}
