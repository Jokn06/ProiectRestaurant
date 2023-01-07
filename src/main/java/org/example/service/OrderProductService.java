package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.entity.OrderProduct;
import org.example.exception.BusinessException;
import org.example.mapper.OrderProductMapper;
import org.example.model.orderProduct.OrderProductRequest;
import org.example.model.orderProduct.OrderProductResponse;
import org.example.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;
    private final OrderProductMapper orderProductMapper;

    public OrderProductResponse createPerson(OrderProductRequest personRequest) {
        OrderProduct orderProduct = orderProductMapper.map(personRequest);
        return orderProductMapper.map(orderProductRepository.save(orderProduct));
    }

    public List<OrderProductResponse> getAllOrderProducts() {

        return orderProductMapper.map(orderProductRepository.findAll());
    }

    public List<OrderProductResponse> findAll() {

        return orderProductMapper.map(orderProductRepository.findAll());
    }

    public OrderProductResponse save(OrderProductRequest personRequest) {
        return orderProductMapper.map(orderProductRepository.save(orderProductMapper.map(personRequest)));
    }

    public OrderProductResponse findById(Integer id) {
        OrderProduct orderProduct = orderProductRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find person with ID" + id));
        return orderProductMapper.map(orderProduct);
    }

    public void updateProduct(Integer id, OrderProductRequest orderProductRequest) {
        OrderProduct orderProductToUpdate = orderProductRepository.findById(orderProductRequest.getId()).orElseThrow(
                () -> new BusinessException(String.format("OrderProduct with id: %s is not found", id))
        );
        orderProductToUpdate.setProduct(orderProductRequest.getProduct());

    }

    public void deleteById(Integer id) {
        OrderProduct orderProduct = orderProductRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find OrderProduct with ID" + id));
        orderProductRepository.delete(orderProduct);
    }
}
