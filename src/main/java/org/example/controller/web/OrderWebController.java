package org.example.controller.web;

import lombok.RequiredArgsConstructor;
import org.example.model.order.CreateOrderRequest;
import org.example.model.order.OrderRequest;
import org.example.model.order.OrderRequestTwo;
import org.example.service.OrderService;
import org.example.service.ProductService;
import org.example.utils.IdRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderWebController {

    private final OrderService orderService;

    private final ProductService productService;

//    @GetMapping("/order")
//    public String goToOrder() {
//        return "adminOrderPage";
//    }

    @GetMapping("/adminOrderPage")
    public String gotoAllOrdersService(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "adminOrderPage";
    }

//    @PostMapping("/adminOrderPage/create-new-order")
//    public String goToCreateOrderPage(Model model) {
//
//
//    }


    @PostMapping("/adminOrderPage/create-new-order")
    public String createNewOrder(@ModelAttribute(value = "createOrderRequest") CreateOrderRequest request,
                                 Model model) {
        List<Integer> productList = request.getOrders();

        model.addAttribute("products", productList);
        return "createOrderTwo";
    }



    @PostMapping("/adminOrderPage/create-new-ordertwo")
    public String createNewOrderTwo(@ModelAttribute(value = "createOrderRequest") OrderRequestTwo request,
                                    Model model) {
        List<Integer> productList = request.getProductsId();
        OrderRequest orderRequest = OrderRequest.builder()
                .dateStart(request.getDateStart())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .customerName(request.getCustomerName())
                .productsId(  productList )
                .build();
        orderService.createOrder(orderRequest);

        model.addAttribute("orders", orderService.findAll());
        return "/adminOrderPage";
    }

    @GetMapping("/adminOrderPage/goToCreateOrderPage")
    public String goToCreateOrderPage(Model model) {
        model.addAttribute("products", productService.allProducts());
        return "createOrder";
    }

    @PostMapping("/adminOrderPage/delete")
    public String deleteOrder(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        orderService.deleteById(request.getId());
        model.addAttribute("products", orderService.getAllOrders());
        return "/adminOrderPage";
    }


}
