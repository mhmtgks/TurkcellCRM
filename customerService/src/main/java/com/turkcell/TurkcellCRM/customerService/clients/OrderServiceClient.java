package com.turkcell.TurkcellCRM.customerService.clients;


import com.turkcell.TurkcellCRM.customerService.dtos.response.SearchCustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name="orderservice",url = "http://localhost:9015/orderservice/api/v1")
public interface OrderServiceClient
{
    @GetMapping("/orders")
    List<SearchCustomerResponse> getOrders();

}
