package com.turkcell.TurkcellCRM.orderService.api.controllers;

import com.turkcell.TurkcellCRM.orderService.business.abstracts.ProductService;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.create.CreateProductRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.update.UpdateProductRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.create.CreateProductResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.get.GetProductResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.update.UpdateProductResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orderservice/api/v1/products")
public class ProductController {
    private ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return productService.add(createProductRequest);
    }

    @PutMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateProductResponse update(@Valid @RequestBody UpdateProductRequest updateProductRequest, @PathVariable int addressId) {
        return productService.update(updateProductRequest,addressId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetProductResponse getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetProductResponse> getAll() {
        return productService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id ){
        productService.delete(id);
    }
}
