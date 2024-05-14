package com.turkcell.TurkcellCRM.searchService.repositories;

import com.turkcell.TurkcellCRM.searchService.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchRepository extends MongoRepository<Customer,String> {
}
