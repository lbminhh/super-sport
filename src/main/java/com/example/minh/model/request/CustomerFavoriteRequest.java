package com.example.minh.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerFavoriteRequest {

    String productDetailID;

    String customerID;

}
