package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.model.product.ProductRequest;
import org.example.model.product.ProductResponse;
import org.example.model.product.RequestUpdatePrice;
import org.example.model.product.UpdateName;
import org.example.service.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    @PostMapping("create")
    public ProductResponse createProduct(@RequestBody @Valid ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping("list")
    public List<ProductResponse> showAllProduct() {
        return productService.allProducts();
    }

    @GetMapping("find/{id}")
    public ProductResponse findById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @GetMapping("search/{name}")
    public List<ProductResponse> findByName(@PathVariable String name){
        return productService.findByName(name);
    }

    @PatchMapping("update-name")
    public void updateName(@RequestBody @Valid UpdateName updateName) {
        productService.updateProductName(updateName);
    }


    @PatchMapping("update-price")
    public void updatePrice(@RequestBody @Valid RequestUpdatePrice requestUpdatePrice) {
        productService.updateProductPrice(requestUpdatePrice);
    }

    @DeleteMapping("delete-id/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

}
