package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.customer.CustomerRequest;
import org.example.model.customer.CustomerResponse;
import org.example.service.CustomerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("create")
    public CustomerResponse createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

    @GetMapping("list")
    public List<CustomerResponse> getAllCustomers() {

        return customerService.getAllCustomers();
    }


    @GetMapping("{id}")
    public CustomerResponse findById(@PathVariable("id") Integer id) {

        return customerService.findById(id);
    }


    @PatchMapping("update")
    public void updateCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        customerService.updateCustomer( customerRequest);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {

        customerService.deleteById(id);
    }
}
