package com.example.spring_data_hw7.repositories;

import com.example.spring_data_hw7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    List<Product> findAllByCostBetween(Double min, Double max);

    List<Product> findAllByCostGreaterThan(Double minCost);

    List<Product> findAllByCostIsLessThan(Double maxCost);
}
