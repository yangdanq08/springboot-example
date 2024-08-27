package com.example.oms_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.oms_backend.entity.OrderList;

public interface OrderListRepository {


    public interface OrderRepository extends JpaRepository<OrderList, Long> {
    }

}
