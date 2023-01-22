package org.example.controller.web;

import lombok.RequiredArgsConstructor;
import org.example.model.customer.CreateCustomerRequest;
import org.example.model.customer.CustomerRequest;
import org.example.model.customer.UpdateCustomerRequest;
import org.example.service.CustomerService;
import org.example.utils.IdRequest;
import org.example.utils.UpdateRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CustomerWebController {

    private final CustomerService customerService;

    @GetMapping("/adminCustomerPage")
    public String gotoAdminProduct() {
        return "/adminCustomerPage";
    }

    @PostMapping("/adminCustomerPage/update-customer")
    public String updateCustomer(@ModelAttribute(value = "updateCustomerRequest") UpdateCustomerRequest request,
                                 Model model) {
        CustomerRequest customerRequest = CustomerRequest.builder()
                .id(request.getId())
                .name(request.getName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .build();
        customerService.updateCustomer(customerRequest);

        model.addAttribute("customers", customerService.getAllCustomers());
        return "adminCustomerPage";
    }

    @GetMapping("/adminCustomerPage/allCustomers")
    public String goToAllCustomersAdminList(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "/adminCustomerPage";
    }

    @GetMapping("/customer/goToCreateCustomerPage")
    public String goToCreateChefPage() {
        return "createCustomer";
    }

    @GetMapping("/adminCustomerPage/goToUpdateCustomerPage")
    public String goToUpdateCustomerPage(@ModelAttribute(value = "deleteRequest") UpdateRequest request, Model model) {
        model.addAttribute("customerId", request.getId());
        return "updateCustomerPage";
    }


    @PostMapping("/customer/createNewCustomer")
    public String createCustomer(@ModelAttribute(value = "createCustomerRequest")
                                     CreateCustomerRequest request,
                                 Model model) {
        CustomerRequest customerRequest = CustomerRequest.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .build();
        customerService.createCustomer(customerRequest);

        model.addAttribute("customers", customerService.getAllCustomers());
        return "/adminCustomerPage";
    }



    @PostMapping("/adminCustomerPage/delete")
    public String deleteChef(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        customerService.deleteById(request.getId());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "/adminCustomerPage";
    }

}