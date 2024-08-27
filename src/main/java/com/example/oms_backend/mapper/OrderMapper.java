package com.example.oms_backend.mapper;

import com.example.oms_backend.dto.OrderDto;
import com.example.oms_backend.entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//public class OrderMapper {
//    public static OrderDto mapToOrderDto(Order order){
//        return new OrderDto(
//                order.getId(),
//                order.getCustomerId(),
//                order.getProductName(),
//                order.getQuantity(),
//                order.getPrice()
//        );
//
//    }


    public class OrderMapper {
        public static OrderDto mapToOrderDto(Order order){
            return new OrderDto(
                    order.getId(),
                    order.getCustomerId(),
                    order.getOrderDate(),
                    order.getQuantity(),
                    order.getTotal()
            );

        }



    public static Order mapToOrder(OrderDto orderDto){
        return new Order(
                orderDto.getId(),
                orderDto.getCustomerId(),
                orderDto.getOrderDate(),
                orderDto.getQuantity(),
                orderDto.getTotal()
        );

//        return new Order(
//                orderDto.getId(),
//                orderDto.getOrderDate(),
//                orderDto.getProductName(),
//                orderDto.getQuantity(),
//                orderDto.getPrice()
//        );
    }
}
