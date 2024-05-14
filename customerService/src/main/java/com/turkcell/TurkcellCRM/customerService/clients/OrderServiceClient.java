package com.turkcell.TurkcellCRM.customerService.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="orderservice",url = "http://localhost:9015/orderservice/api/v1")
public interface OrderServiceClient
{
    @GetMapping("/orders")
    int getCustomerIdByOrderId(@RequestParam("orderId") String orderId);

}
