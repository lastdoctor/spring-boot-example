package com.lastdoctor.customer;

import com.lastdoctor.customer.dto.CreateCustomerDto;
import com.lastdoctor.exception.DuplicateResourceException;
import com.lastdoctor.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jdbc") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer getCustomer(Integer id) {
        return customerDao.findUserById(id).orElseThrow(() ->
                new ResourceNotFoundException("customer with id [%s] not found".formatted(id)));
    }

    public Customer createCustomer(CreateCustomerDto createCustomerDto) {
        customerDao.findCustomerByEmail(createCustomerDto.getEmail())
                .orElseThrow(() -> new DuplicateResourceException("email is already exists"));
        var customer = new Customer();
        BeanUtils.copyProperties(createCustomerDto, customer);
        return customerDao.createCustomer(customer);
    }
}
