package com.turkcell.TurkcellCRM.customerService.business.concretes;

import com.turkcell.TurkcellCRM.customerService.business.abstracts.ContactInfoService;
import com.turkcell.TurkcellCRM.customerService.business.rules.ContactInfoBusinessRules;

import com.turkcell.TurkcellCRM.customerService.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.customerService.dataAccess.ContactInfoRepository;
import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreateContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdateContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.ContactInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ContactInfoManager implements ContactInfoService {
    private ContactInfoRepository contactInfoRepository;
    private ModelMapperService modelMapperService;
    private ContactInfoBusinessRules contactInfoBusinnesRules;
    @Override
    public CreateContactInfoResponse add(CreateContactInfoRequest createContactInfoRequest) {
        ContactInfo contactInfo = modelMapperService.forRequest().map(createContactInfoRequest,ContactInfo.class);
        contactInfo.setCreatedDate(LocalDateTime.now());
        ContactInfo createdContactInfo = contactInfoRepository.save(contactInfo);
        return modelMapperService.forResponse().map(createdContactInfo,CreateContactInfoResponse.class);
    }

    @Override
    public void delete(int id) {
        contactInfoBusinnesRules.contactInfoShouldBeExists(id);
        contactInfoRepository.deleteById(id);

    }

    @Override
    public GetContactInfoResponse getById(int id) {
        ContactInfo contactInfo = contactInfoRepository.findById(id).orElse(null);
        GetContactInfoResponse getContactInfoResponse = modelMapperService.forResponse().map(contactInfo,GetContactInfoResponse.class);
        return getContactInfoResponse;
    }

    @Override
    public UpdateContactInfoResponse update(UpdateContactInfoRequest updateContactInfoRequest, int contactInfoId) {
        contactInfoBusinnesRules.contactInfoShouldBeExists(contactInfoId);
        ContactInfo contactInfoToUpdate= modelMapperService.forRequest().map(updateContactInfoRequest,ContactInfo.class);
        contactInfoToUpdate.setUpdatedDate(LocalDateTime.now());
        contactInfoToUpdate.setId(contactInfoId);
        ContactInfo updatedContactInfo = contactInfoRepository.save(contactInfoToUpdate);
        return modelMapperService.forResponse().map(updatedContactInfo,UpdateContactInfoResponse.class);
    }

    @Override
    public List<GetAllContactInfoResponse> getAll() {
        List<ContactInfo> contactInfos = contactInfoRepository.findAll();
        return contactInfos.stream().map(contactInfo -> modelMapperService.forResponse().map(contactInfo,GetAllContactInfoResponse.class)).toList();
    }
}
