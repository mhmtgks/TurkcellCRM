package com.turkcell.TurkcellCRM.orderService.business.abstracts;

import com.turkcell.TurkcellCRM.orderService.dtos.requests.create.CreateProductRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.update.UpdateProductRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.create.CreateProductResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.get.GetProductResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.update.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    CreateProductResponse add(CreateProductRequest productRequest);
    void delete(int id);
    GetProductResponse getById(int id);
    UpdateProductResponse update(UpdateProductRequest updateProductRequest, int productId);
    List<GetProductResponse> getAll();
}
