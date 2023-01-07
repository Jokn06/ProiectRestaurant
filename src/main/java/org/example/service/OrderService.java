package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Order;

import org.example.exception.BusinessException;
import org.example.mapper.OrderMapper;
import org.example.model.order.OrderRequest;
import org.example.model.order.OrderResponse;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = orderMapper.map(orderRequest);
        return orderMapper.map(orderRepository.save(order));
    }
    public List<OrderResponse> getAllOrders() {

        return orderMapper.map(orderRepository.findAll());
    }

    public OrderResponse findById(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find the order with ID" + id));
        return orderMapper.map(order);
    }

    public void updateOrder(Integer id, OrderRequest orderRequest) {
        Order orderToUpdate = orderRepository.findById(orderRequest.getId()).orElseThrow(
                () -> new BusinessException(String.format("Order with id: %s is not found", id))
        );
        orderToUpdate.setId(orderRequest.getId());
    }

    public void deleteById(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find the order with ID" + id));
        orderRepository.delete(order);
    }


}
