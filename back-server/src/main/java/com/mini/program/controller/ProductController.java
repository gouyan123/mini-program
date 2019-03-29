//package com.mini.program.controller;
//
//import com.mini.program.entity.Category;
//import com.mini.program.entity.Product;
//import com.mini.program.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class ProductController {
//    @Autowired
//    private ProductRepository repository;
//
//    @GetMapping("/product")
//    public List<Product> findByCategoryId(Category category){
//        return repository.findByCategory(category);
//    }
//}
