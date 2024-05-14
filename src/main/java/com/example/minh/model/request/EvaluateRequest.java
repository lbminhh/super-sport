package com.example.minh.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvaluateRequest {

    String customerID;

    String productDetailID;

    String comment;

    Integer rating;
}
