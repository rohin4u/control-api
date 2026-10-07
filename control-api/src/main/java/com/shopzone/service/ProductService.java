package com.shopzone.service;


import com.shopzone.DTO.ProductDTO;
import com.shopzone.DTO.ResponseDTO;
import com.shopzone.abstraction.ProductInterface;
import com.shopzone.entity.Product;
import com.shopzone.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductInterface {



    ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Override
    public Product saveProduct(ProductDTO productDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        Product product = Product.builder().name(productDTO.getName())
                        .price(productDTO.getPrice())
                                .emoji(productDTO.getEmoji())
                                        .description(productDTO.getDescription())
                                                .image(productDTO.getImage())
                                                        .images(productDTO.getImages()).build();

        try {
            Product savedProduct = productRepository.save(product);
            if(savedProduct !=null){

                responseDTO.setMessage("Product saved successfully");

                return savedProduct;

            }
        }catch (Exception e){
            responseDTO.setMessage(e.getMessage());
            return new Product();
        }

        return new Product();
    }

    @Override
    public List<ProductDTO> showProducts() {
        List<Product> productList = productRepository.findAll();

        List<ProductDTO> productDTOList = new ArrayList<>();

        for(Product product : productList){
            ProductDTO productDTO = ProductDTO.builder().name(product.getName())

                    .id(product.getId())
                    .price(product.getPrice())
                    .image(product.getImage())
                    .description(product.getDescription())
                    .images(product.getImages())
                    .emoji(product.getEmoji())
                    .build();
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }


}
