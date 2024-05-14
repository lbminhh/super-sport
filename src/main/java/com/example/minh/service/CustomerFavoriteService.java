package com.example.minh.service;

import com.example.minh.model.request.CustomerFavoriteRequest;

public interface CustomerFavoriteService {

    String add(CustomerFavoriteRequest customerFavoriteRequest);

    String delete(CustomerFavoriteRequest customerFavoriteRequest);

}
