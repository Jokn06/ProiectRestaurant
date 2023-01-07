package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.orderProduct.OrderProductRequest;
import org.example.model.orderProduct.OrderProductResponse;
import org.example.service.OrderProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("orderProduct")
@RequiredArgsConstructor
@Validated
public class OrderProductController {

    private final OrderProductService orderProductService;

    @PostMapping("create")
    public OrderProductResponse createPerson(@RequestBody @Valid OrderProductRequest orderProductRequest) {
        return orderProductService.createPerson(orderProductRequest);
    }

    @GetMapping("list")
    public List<OrderProductResponse> getAllOrderProducts() {

        return orderProductService.getAllOrderProducts();
    }

//    @GetMapping
//    public List<PersonResponse> findAll() {
//        return personService.findAll();
//    }

    @GetMapping("{id}")
    public OrderProductResponse findById(@PathVariable("id") Integer id) {

        return orderProductService.findById(id);
    }

//    @PostMapping
//    public PersonResponse save(@RequestBody PersonRequest personRequest) {
//        return personService.save(personRequest);
//    }

    @PatchMapping("update/{id}")
    public void updatePersonById(@PathVariable Integer id, @RequestBody @Valid OrderProductRequest orderProductRequest) {
        orderProductService.updateProduct(id, orderProductRequest);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {

        orderProductService.deleteById(id);
    }
}
