package com.lastdoctor.customer;

import java.util.Optional;

public interface CustomerDao {
    Optional<Customer> findUserById(Integer customerId);

    Customer createCustomer(Customer customer);

    Optional<Customer> findCustomerByEmail(String email);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Integer customerId);
}
