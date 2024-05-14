package com.turkcell.TurkcellCRM.customerService.business.abstracts;

import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateAddressRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateAddressRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreateAddressResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAddressResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllAddressResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdateAddressResponse;

import java.util.List;

public interface AddressService {
    CreateAddressResponse add(CreateAddressRequest addressRequest);
    void delete(int id);
    GetAddressResponse getById(int id);
    UpdateAddressResponse update(UpdateAddressRequest updateAddressRequest, int addressId);
    List<GetAllAddressResponse> getAll();
}
