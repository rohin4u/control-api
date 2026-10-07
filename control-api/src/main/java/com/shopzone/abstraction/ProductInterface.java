package com.shopzone.abstraction;

import com.shopzone.DTO.ProductDTO;
import com.shopzone.DTO.ResponseDTO;
import com.shopzone.entity.Product;

import java.util.List;

public interface ProductInterface {

    public Product saveProduct(ProductDTO productDTO);

    public List<ProductDTO> showProducts();
}
