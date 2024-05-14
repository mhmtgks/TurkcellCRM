package com.turkcell.TurkcellCRM.customerService.business.abstracts;

import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreateContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdateContactInfoResponse;

import java.util.List;

public interface ContactInfoService {
    CreateContactInfoResponse add(CreateContactInfoRequest createContactInfoRequest);
    void delete(int id);
    GetContactInfoResponse getById(int id);
    UpdateContactInfoResponse update(UpdateContactInfoRequest updateContactInfoRequest, int contactInfoId);
    List<GetAllContactInfoResponse> getAll();
}
