package com.turkcell.rentacar.inventoryService.business.concrete;

import com.turkcell.rentacar.inventoryService.business.abstracts.BrandService;
import com.turkcell.rentacar.inventoryService.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.requests.UpdateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.response.CreateBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.response.GetAllBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.response.UpdateBrandResponse;
import com.turkcell.rentacar.inventoryService.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.inventoryService.business.abstracts.BrandRepository;
import com.turkcell.rentacar.inventoryService.core.mapping.ModelMapperService;
import com.turkcell.rentacar.inventoryService.business.abstracts.BrandRepository;
import com.turkcell.rentacar.inventoryService.concretes.Brand;
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
    private BrandBusinessRules brandBusinessRules;
//AOP

    @Override
    public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {

        brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());


        Brand brand=this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        Brand createdBrand=brandRepository.save(brand);
        CreateBrandResponse createBrandResponse=this.modelMapperService.forResponse().map(createdBrand,CreateBrandResponse.class);
        return createBrandResponse;
    }

    @Override
    public void delete(int id) {
        Brand brand=brandRepository.getById(id);
        brandBusinessRules.brandNameIsExist(brand.getName());
         brandRepository.delete(brand);
         System.out.println(brand.getId());

    }
//    @Override
//    public void delete(DeleteBrandRequest deleteBrandRequest) {
////        Optional<Brand> brand1=brandRepository.findByName(deleteBrandRequest.getName());
//        Brand brand=this.modelMapperService.forRequest().map(deleteBrandRequest,Brand.class);
//       // Optional<Brand> brand2=brandRepository.findById(brand.getId());
//
//       brandRepository.delete(brand);
////        brandBusinessRules.brandNameIsExist(brand.getName());
////        brandRepository.delete(brand);
////        System.out.println(brand.getId());
//
//    }

    @Override
    public List<GetAllBrandResponse> getAll() {

        List<Brand> brands=brandRepository.findAll();
        List<GetAllBrandResponse> brands2=new ArrayList<>();
        for(Brand brand1:brands){
            brandBusinessRules.brandNameIsExist(brand1.getName());
            brands2.add(this.modelMapperService.forResponse().map(brand1,GetAllBrandResponse.class));
        }
        return brands2;
    }

    @Override
    public GetAllBrandResponse getById(int id) {
        return modelMapperService.forResponse().map(brandRepository.getById(id), GetAllBrandResponse.class);
    }

    @Override
    public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);

        brand.setUpdatedDate(LocalDateTime.now());
        Brand brand2=brandRepository.save(brand);
        UpdateBrandResponse updateBrandResponse=this.modelMapperService.forResponse().map(brand2,UpdateBrandResponse.class);
//        updateBrandResponse.setUpdatedDate(brand2.getUpdatedDate());
        return updateBrandResponse;
    }
}
