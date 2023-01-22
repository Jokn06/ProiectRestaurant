package org.example.controller.web;

import lombok.RequiredArgsConstructor;
import org.example.model.product.CreateProductRequest;
import org.example.model.product.ProductRequest;
import org.example.model.product.UpdateProductRequest;
import org.example.service.ProductService;
import org.example.utils.IdRequest;
import org.example.utils.UpdateRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ProductWebController {

    private final ProductService prodService;

    @GetMapping("/product")
    public String gotoProduct() {
        return "allProducts";
    }

    @GetMapping("/product/allProducts")
    public String gotoAllProductsService(Model model) {
        model.addAttribute("products",prodService.allProducts());
        return "allProducts";
    }

    @GetMapping("/adminProductPage")
    public String gotoAdminProduct() {
        return "/adminProductPage";
    }

    @GetMapping("/adminProductPage/allProducts")
    public String gotoAllAdminProductsService(Model model) {
        model.addAttribute("products",prodService.allProducts());
        return "/adminProductPage";
    }

    @PostMapping("/adminProductPage/update-product")
    public String updateProduct(@ModelAttribute(value = "updateProductRequest") UpdateProductRequest request,
                             Model model) {
        ProductRequest productRequest = ProductRequest.builder()
                .id(request.getId())
                .name(request.getName())
                .weight(request.getWeight())
                .price(request.getPrice())
                .build();
       prodService.updateProduct(productRequest);

        model.addAttribute("products", prodService.allProducts());
        return "adminProductPage";
    }

    @PostMapping("product/createNewProduct")
    public String createProduct(@ModelAttribute(value = "createProductRequest")
                                    CreateProductRequest request,
                             Model model) {
       ProductRequest productRequest = ProductRequest.builder()
               .id(request.getId())
               .name(request.getName())
               .weight(request.getWeight())
               .price(request.getPrice())
                .build();
        prodService.createProduct(productRequest);

        model.addAttribute("products", prodService.allProducts());
        return "adminProductPage";
    }

    @PostMapping("/adminProductPage/delete")
    public String deleteProduct(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        prodService.deleteProduct(request.getId());
        model.addAttribute("products", prodService.allProducts());
        return "/adminProductPage";
    }

    @GetMapping("/adminProductPage/goToUpdateProductPage")
    public String goToUpdateProductPage(@ModelAttribute(value = "deleteRequest") UpdateRequest request, Model model) {
        model.addAttribute("productId", request.getId());
        return "updateProductPage";
    }
    @GetMapping("/adminProductPage/goToCreateProductPage")
    public String goToCreateProductPage() {
        return "createProduct";
    }
}
