package com.shopzone.controller;

import com.shopzone.DTO.ProductDTO;
import com.shopzone.DTO.ResponseDTO;
import com.shopzone.entity.Product;
import com.shopzone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_admin")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }


    @PostMapping("/save_product")
    public Product saveProduct(@RequestBody ProductDTO productDTO){

        System.out.println(productDTO);

        System.out.println("front hit the api");

        return productService.saveProduct(productDTO);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    @GetMapping("/show_product")
    public ResponseEntity<Object> showProducts(){

        List<ProductDTO> productDTOS = productService.showProducts();
        return ResponseEntity.ok(productDTOS);

    }


}
