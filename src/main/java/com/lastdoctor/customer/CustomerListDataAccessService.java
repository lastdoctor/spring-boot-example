package com.lastdoctor.customer;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("list")
public class CustomerListDataAccessService implements CustomerDao {
    @Override
    public Optional<Customer> findUserById(Integer customerId) {
        return Optional.empty();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Integer customerId) {

    }
}
 