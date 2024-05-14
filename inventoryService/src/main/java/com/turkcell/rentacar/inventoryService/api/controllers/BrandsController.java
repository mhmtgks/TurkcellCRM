package com.turkcell.rentacar.inventoryService.api.controllers;

import com.turkcell.rentacar.inventoryService.business.abstracts.*;
import com.turkcell.rentacar.inventoryService.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.requests.UpdateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.response.CreateBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.response.GetAllBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.response.UpdateBrandResponse;
import com.turkcell.rentacar.inventoryService.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inventoryservice/api/v1/brands")//domaine ek gelicek ksıım doamine localhost diyoruz şimdilik kendi pcmizden çalışacağı için
//turkcell.com.tr/xproject/api/v1/brands
public class BrandsController {
    private com.turkcell.rentacar.business.abstracts.BrandService brandService;//IoC
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(@RequestBody CreateBrandRequest createBrandRequest){

        return  brandService.add(createBrandRequest);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@RequestBody int id){

        brandService.delete(id);
    }
//@DeleteMapping
//@ResponseStatus(HttpStatus.ACCEPTED)
//public void delete(@RequestBody DeleteBrandRequest deleteBrandRequest){
//
//    brandService.delete(deleteBrandRequest);
//}
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<GetAllBrandResponse> getAll(){

       return brandService.getAll();
    }
    @GetMapping("/brands/{id}")
    @ResponseStatus
    public GetAllBrandResponse getById(int id){

        return brandService.getById(id);
    }
    @PutMapping
    @ResponseStatus
    public UpdateBrandResponse update( @RequestBody UpdateBrandRequest brand){


        return brandService.update(brand);

    }

}

