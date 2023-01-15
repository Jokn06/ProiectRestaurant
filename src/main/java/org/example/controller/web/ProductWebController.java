package org.example.controller.web;

import lombok.RequiredArgsConstructor;
import org.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ProductWebController {

    private final ProductService prodService;
    @GetMapping("/product")
    public String gotoProduct() {
        return "product.html";
    }

    @GetMapping("/product/allProducts")
    public String gotoAllProductsService(Model model) {
        model.addAttribute("products",prodService.allProducts());
        return "allProduct";
    }


}
