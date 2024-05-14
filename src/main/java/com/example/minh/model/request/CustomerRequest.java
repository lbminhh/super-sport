package com.example.minh.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {

    @NotNull(message = "customer name can not be null!")
    String fullname;

    @NotNull(message = "customer email can not be null!")
    String email;

    @NotNull(message = "customer phone number can not be null!")
    String phoneNumber;

    @NotNull(message = "customer gender can not be null!")
    Integer gender;

    Integer status;

    @NotNull(message = "customer date of birth can not be null!")
    Date dateOfBirth;

    String description;
}
