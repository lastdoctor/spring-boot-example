package com.lastdoctor.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = "jdbc")
public class CustomerJDBCDataAccessService implements CustomerDao {
    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    public CustomerJDBCDataAccessService(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    @Override
    public Optional<Customer> findUserById(Integer customerId) {
        var sql = """
                SELECT * FROM customers
                WHERE id = ?
                """;
        return jdbcTemplate.query(sql, customerRowMapper, customerId)
                .stream()
                .findFirst();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        var sql = """
                INSERT INTO customers(name, email, age)
                VALUES(?, ?, ?)
                RETURNING *;
                """;
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getAge());
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
