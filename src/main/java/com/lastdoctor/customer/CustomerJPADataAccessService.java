package com.lastdoctor.customer;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("jpa")
public class CustomerJPADataAccessService implements CustomerDao {
    private final CustomerRepository customerRepository;

    public CustomerJPADataAccessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findUserById(Integer customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String customerEmail) {
        return customerRepository.findCustomerByEmail(customerEmail);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}
