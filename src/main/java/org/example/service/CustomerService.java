package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.entity.Customer;
import org.example.entity.User;
import org.example.exception.BusinessException;
import org.example.mapper.CustomerMapper;
import org.example.model.customer.CustomerRequest;
import org.example.model.customer.CustomerResponse;
import org.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customer = customerMapper.map(customerRequest);
        return customerMapper.map(customerRepository.save(customer));
    }

    public List<CustomerResponse> getAllCustomers() {

        return customerMapper.map(customerRepository.findAll());
    }

    public List<CustomerResponse> findAll() {

        return customerMapper.map(customerRepository.findAll());
    }

    public CustomerResponse save(CustomerRequest customerRequest) {
        return customerMapper.map(customerRepository.save(customerMapper.map(customerRequest)));
    }

    public CustomerResponse findById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find customer with ID" + id));
        return customerMapper.map(customer);
    }

    public void updateCustomer(Integer id, CustomerRequest customerRequest) {
        Customer customerToUpdate = customerRepository.findById(customerRequest.getId()).orElseThrow(
                () -> new BusinessException(String.format("Customer with id: %s is not found", id))
        );
        customerToUpdate.setName(customerRequest.getName());
        customerToUpdate.setAddress(customerRequest.getAddress());
        customerToUpdate.setPhoneNumber(customerRequest.getPhoneNumber());

    }

    public void deleteById(Integer id) {
       Customer customer = customerRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find customer with ID" + id));
        customerRepository.delete(customer);
    }
}
