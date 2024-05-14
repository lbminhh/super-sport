package com.example.minh.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAddressRequest {

    UUID customerID;

    String province;

    String city;

    String district;

    String streetAddress;

    Boolean isActive;
}
