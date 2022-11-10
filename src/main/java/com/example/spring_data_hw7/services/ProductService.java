package com.example.spring_data_hw7.services;

import com.example.spring_data_hw7.model.Product;
import com.example.spring_data_hw7.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findAllByCostBetween(Double min, Double max){
        return productRepository.findAllByCostBetween(min, max);
    }

    public List<Product> findAllByCostGreaterThanEqual(Double minCost){
        return productRepository.findAllByCostGreaterThan(minCost);
    }

    public List<Product> findAllByCostIsLessThanEqual(Double maxCost){
        return productRepository.findAllByCostIsLessThan(maxCost);
    }
}
