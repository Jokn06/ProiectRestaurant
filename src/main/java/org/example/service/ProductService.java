package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Product;
import org.example.exception.BusinessException;
import org.example.mapper.ProductMapper;
import org.example.model.product.ProductRequest;
import org.example.model.product.ProductResponse;
import org.example.model.product.RequestUpdatePrice;
import org.example.model.product.UpdateName;
import org.example.repository.ProductRepository;
import org.example.repository.MyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final MyRepository myRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productMapper.map(productRequest);
        return productMapper.map(productRepository.save(product));
    }

    public List<ProductResponse> allProducts() {
        return productMapper.map(productRepository.findAll());
    }

    public ProductResponse findById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new BusinessException(String.format("The product with id: %s not exist", id)));
        return productMapper.map(product);
    }

    public List<ProductResponse> findByName(String name) {
        List<Product> listFromDB = myRepository.findByProductName(name);
        return createProductList(listFromDB);
    }

    static List<ProductResponse> createProductList(List<Product> productListFromDB) {
        List<ProductResponse> productListForResponse = new ArrayList<>();
        for (Product product : productListFromDB) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setPrice(product.getPrice());
            productResponse.setName(product.getName());
            productResponse.setDescription(product.getDescription());
            productResponse.setWeight(product.getWeight());
            productListForResponse.add(productResponse);
        }
        return productListForResponse;
    }

    public void updateProductName(UpdateName updateName) {
        Product productToUpdate = productRepository.findById(updateName.getId()).orElseThrow(()
                -> new BusinessException(String.format("The product with id: %s not exist! ", updateName.getId()))
        );
        productToUpdate.setName(updateName.getName());
    }

    public void updateProductPrice(RequestUpdatePrice requestUpdatePrice) {
        Product productToUpdate = productRepository.findById(requestUpdatePrice.getId()).orElseThrow(()
                -> new BusinessException(String.format("The product with id: %s not exist!", requestUpdatePrice.getId()))
        );
        productToUpdate.setPrice(requestUpdatePrice.getProductPrice());
    }

    public void deleteProduct(Integer id) {
        Product productToDelete = productRepository.findById(id).orElseThrow(()
                -> new BusinessException(String.format("The product with id: %s not exist", id))
        );
        productRepository.delete(productToDelete);
    }


}


