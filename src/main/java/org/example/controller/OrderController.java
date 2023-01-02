package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.OrderRequest;
import org.example.model.OrderResponse;
import org.example.service.OrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
@Validated
public class OrderController {

    private final OrderService orderService;

    @PostMapping("create")
    public OrderResponse createOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("list")
    public List<OrderResponse> getAllOrders() {

        return orderService.getAllOrders();
    }

    @GetMapping("{id}")
    public OrderResponse findById(@PathVariable("id") Integer id) {

        return orderService.findById(id);
    }

    @PatchMapping("update/{id}")
    public void updatePersonById(@PathVariable Integer id, @RequestBody @Valid OrderRequest orderRequest) {
        orderService.updateOrder(id, orderRequest);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {

        orderService.deleteById(id);
    }
}



