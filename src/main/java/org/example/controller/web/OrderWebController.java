package org.example.controller.web;

import lombok.RequiredArgsConstructor;
import org.example.model.order.CreateOrderRequest;
import org.example.model.order.CreateOrderTwoRequest;
import org.example.model.order.OrderRequest;
import org.example.service.OrderService;
import org.example.utils.IdRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderWebController {

    private final OrderService orderService;

//    @GetMapping("/order")
//    public String goToOrder() {
//        return "adminOrderPage";
//    }

    @GetMapping("/adminOrderPage")
    public String gotoAllOrdersService(Model model) {
        model.addAttribute("orders",orderService.getAllOrders());
        return "adminOrderPage";
    }

    @PostMapping("/adminOrderPage/create-new-order")
    public String createNewOrder(@ModelAttribute(value = "createOrderRequest") CreateOrderRequest request,
                                 Model model) {
        OrderRequest orderRequest = OrderRequest.builder()
//                .customerId(request.getCustomerId())
//                .phoneNumber(request.getPhoneNumber())
//                .address(request.getAddress())
//                .dateStart(request.getDateStart())
                .orders(request.getOrders())
                .build();
        orderService.createOrder(orderRequest);

        model.addAttribute("orders", orderService.findAll());
        return "createOrderTwo";
    }

    @PostMapping("/adminOrderPage/create-new-ordertwo")
    public String createNewOrderTwo(@ModelAttribute(value = "createOrderRequest") CreateOrderTwoRequest request,
                                    Model model) {
        OrderRequest orderRequest = OrderRequest.builder()
//                .customerId(request.getCustomerId())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
//                .name(request.getName())
//                .dateStart(request.getDateStart())
//                .orders(request.getOrders())
                .build();
        orderService.createOrder(orderRequest);

        model.addAttribute("orders", orderService.findAll());
        return "/adminOrderPage";
    }

    @GetMapping("/adminOrderPage/goToCreateOrderPage")
    public String goToCreateOrderPage() {
        return "createOrder";
    }

    @PostMapping("/adminOrderPage/delete")
    public String deleteOrder(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        orderService.deleteById(request.getId());
        model.addAttribute("products", orderService.getAllOrders());
        return "/adminOrderPage";
    }



}
