package com.turkcell.TurkcellCRM.orderService.business.concretes;

import com.turkcell.TurkcellCRM.orderService.business.abstracts.ProductService;
import com.turkcell.TurkcellCRM.orderService.core.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.orderService.dataAccess.ProductRepository;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.create.CreateProductRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.update.UpdateProductRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.create.CreateProductResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.get.GetProductResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.update.UpdateProductResponse;
import com.turkcell.TurkcellCRM.orderService.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ModelMapperService modelMapperService;
    private ProductRepository productRepository;
    @Override
    public CreateProductResponse add(CreateProductRequest productRequest) {
        Product product=modelMapperService.forRequest().map(productRequest, Product.class);
        Product dbProduct=productRepository.save(product);
        return modelMapperService.forResponse().map(dbProduct,CreateProductResponse.class);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public GetProductResponse getById(int id) {
        Product product=productRepository.findById(id).orElse(null);

        return modelMapperService.forResponse().map(product, GetProductResponse.class) ;
    }

    @Override
    public UpdateProductResponse update(UpdateProductRequest updateProductRequest, int productId) {
        Product product=productRepository.findById(productId).orElse(null);
        product.setId(productId);
        Product dbProduct=productRepository.save(product);
        return modelMapperService.forResponse().map(dbProduct,UpdateProductResponse.class);
    }

    @Override
    public List<GetProductResponse> getAll() {
        List<Product> products=productRepository.findAll();

        return  products.stream().map(product->  modelMapperService.forResponse().map(product, GetProductResponse.class)).toList();


    }
}
