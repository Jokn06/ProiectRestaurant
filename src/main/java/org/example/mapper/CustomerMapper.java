package org.example.mapper;

import org.example.entity.Customer;
import org.example.model.customer.CustomerRequest;
import org.example.model.customer.CustomerResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;


import java.util.List;

@Mapper(componentModel = "spring")
@ComponentScan
public interface CustomerMapper {

    Customer map(CustomerRequest customerRequest);

    CustomerResponse map(Customer customer);

    List<CustomerResponse> map(List<Customer> all);

}
