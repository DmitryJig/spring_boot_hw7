package com.example.spring_data_hw7.controllers;

import com.example.spring_data_hw7.model.Product;
import com.example.spring_data_hw7.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.findProductById(id).get();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.save(product);
    }

    // Далее 2 метода удаления продукта, Get и DeleteMapping
    //  http://localhost:8189/app/products/delete/20
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

    @DeleteMapping
    public void normalDeleteById(@RequestParam(name = "id") Long id){
        productService.deleteById(id);
    }

    //http://localhost:8189/app/products/cost_between?min=100&max=1000
    @GetMapping("/cost_between")
    public List<Product> searchByCostBetween (@RequestParam(name = "min") Double minCost, @RequestParam(name = "max") Double maxCost){
        return productService.findAllByCostBetween(minCost, maxCost);
    }

    // http://localhost:8189/app/products/cost_greater?cost=1000
    @GetMapping("/cost_greater")
    public List<Product> searchByCostGraeterThan (@RequestParam(name = "cost") Double minCost){
        return productService.findAllByCostGreaterThanEqual(minCost);
    }

    // http://localhost:8189/app/products/cost_less?cost=1000
    @GetMapping("/cost_less")
    public List<Product> searchByCostLessThan (@RequestParam(name = "cost") Double maxCost){
        return productService.findAllByCostIsLessThanEqual(maxCost);
    }
}
