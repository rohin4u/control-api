package com.shopzone.DTO;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseDTO {

    String message;
}
