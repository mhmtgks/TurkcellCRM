package com.turkcell.TurkcellCRM.searchService.business.abstracts;

import com.turkcell.TurkcellCRM.searchService.entities.Customer;
import com.turkcell.TurkcellCRM.commonPackage.CustomerCreatedEvent;

import java.util.List;

public interface SearchService {
    void  add(Customer customer);
    List<Customer> getAll();
}
