package com.example.minh.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerCartRequest {

    String productDetailID;

    String customerID;

    Integer quantity;

}
