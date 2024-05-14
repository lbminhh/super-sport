package com.example.minh.service;

import com.example.minh.model.request.CustomerCartRequest;

public interface CustomerCartService {

    String add(CustomerCartRequest request);

    String update(CustomerCartRequest request);

    String delete(CustomerCartRequest request);


}
