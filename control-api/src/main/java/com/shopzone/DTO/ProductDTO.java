package com.shopzone.DTO;


import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductDTO {
    Long id;
    String name;
    int price;
    String emoji;
    String description;
    String image;
    List<String> images;
}
