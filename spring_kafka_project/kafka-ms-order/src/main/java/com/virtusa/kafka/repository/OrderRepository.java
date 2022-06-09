package com.virtusa.kafka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.kafka.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}
