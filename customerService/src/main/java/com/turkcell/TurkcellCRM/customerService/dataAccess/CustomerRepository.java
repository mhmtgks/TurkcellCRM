package com.turkcell.TurkcellCRM.customerService.dataAccess;

import com.turkcell.TurkcellCRM.customerService.dtos.request.SearchCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.SearchCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreateCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query("Select new com.turkcell.TurkcellCRM.customerService.dtos.response." +
//            "SearchCustomerResponse(c.id, c.first_name, c.last_name, c.second_name, c.nationality_id)" +
//            " from customer c" +
//            " where ( :#{#request.getNationalityId()} <= 0 or c.nationality_id= :#{#request.getNationalityId()})" +
//            " and ( :#{#request.getCustomerId()} is null or c.id= :#{#request.getCustomerId()})")
//    @Query("SELECT c FROM Customer c WHERE c.motherName = 'asd'")
//    List<CreateCustomerResponse> search(CreateCustomerRequest request);


    Optional<Customer> findByNationalityNumber(String nationalityId);
}
