package com.turkcell.TurkcellCRM.customerService.business.rules;

import com.turkcell.TurkcellCRM.customerService.business.messages.CustomerMessages;
import com.turkcell.TurkcellCRM.customerService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.customerService.dataAccess.CustomerRepository;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private final CustomerRepository customerRepository;

    public void customerShouldBeExists(int customerId) {
        Optional<Customer> foundOptionalCustomer = customerRepository.findById(customerId);
        if (foundOptionalCustomer.isEmpty()) {
            throw new BusinessException(CustomerMessages.CUSTOMER_NOT_FOUND);
        }
    }

    public void customerAlreadyExists(String nationalityNumber) {
        Optional<Customer> foundOptionalCustomer = customerRepository.findByNationalityNumber(nationalityNumber);
        if (!foundOptionalCustomer.isEmpty()) {
            throw new BusinessException(CustomerMessages.CUSTOMER_ALREADY_EXISTS);
        }

    }
}
