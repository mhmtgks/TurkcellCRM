package com.turkcell.rentacar.inventoryService.business.abstracts;

import com.turkcell.rentacar.inventoryService.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.requests.DeleteBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.requests.UpdateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.response.CreateBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.response.GetAllBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.response.UpdateBrandResponse;
import com.turkcell.rentacar.inventoryService.concretes.Brand;

import java.util.List;

public interface BrandService {
    CreateBrandResponse add(CreateBrandRequest createBrandRequest);
   void delete(int id);
//void delete(DeleteBrandRequest deleteBrandRequest);
    List<GetAllBrandResponse> getAll();
    GetAllBrandResponse getById(int id);
    UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest);
}
