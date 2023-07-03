package com.lastdoctor.customer;

import com.lastdoctor.customer.dto.CreateCustomerDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        return customerService.createCustomer(createCustomerDto);
    }
}
