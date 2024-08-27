package com.example.oms_backend.service.impl;

import com.example.oms_backend.dto.OrderDto;
import com.example.oms_backend.entity.Order;
import com.example.oms_backend.exception.ResourceNotFoundException;
import com.example.oms_backend.mapper.OrderMapper;
import com.example.oms_backend.repository.OrderRepository;
import com.example.oms_backend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@service:  tell spring container to create the spring Bean for this class
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                new ResourceNotFoundException("Order is not existed with given id : " + orderId));
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map((order) -> OrderMapper.mapToOrderDto(order))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long orderId, OrderDto updatedOrder) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Order is not existed with given id : " + orderId)
        );
        //order.setCustomerId(updatedOrder.getCustomerId());
//        order.setProductName(updatedOrder.getProductName());
        order.setQuantity(updatedOrder.getQuantity());
        order.setTotal(updatedOrder.getTotal());

        Order savedOrder = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Order is not existed with given id : " + orderId)
        );
        orderRepository.deleteById(orderId);
    }
}
