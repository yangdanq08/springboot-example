package com.example.oms_backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//public class OrderDto {

//public class OrderDto {
//    private Long id;
//    private Long customerId;
//    private String productName;
//    private int quantity;
//    private double price;
//
//}


public class OrderDto {
    private Long id;
    private Long customerId;
    private String orderDate;
    private int quantity;
    private double total;

}

