package com.example.minh.controller;

import com.example.minh.entity.AccountCustomer;
import com.example.minh.entity.Customer;
import com.example.minh.entity.CustomerAddress;
import com.example.minh.entity.Evaluate;
import com.example.minh.model.request.AccountCustomerRequest;
import com.example.minh.model.request.CustomerAddressRequest;
import com.example.minh.model.request.CustomerCartRequest;
import com.example.minh.model.request.CustomerFavoriteRequest;
import com.example.minh.model.request.CustomerRequest;
import com.example.minh.model.request.EvaluateRequest;
import com.example.minh.model.response.ApiResponse;
import com.example.minh.model.response.CustomerResponse;
import com.example.minh.service.AccountCustomerService;
import com.example.minh.service.CustomerAddressService;
import com.example.minh.service.CustomerCartService;
import com.example.minh.service.CustomerEvaluteService;
import com.example.minh.service.CustomerFavoriteService;
import com.example.minh.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerAddressService customerAddressService;

    @Autowired
    AccountCustomerService accountCustomerService;

    @Autowired
    CustomerFavoriteService customerFavoriteService;

    @Autowired
    CustomerCartService customerCartService;

    @Autowired
    CustomerEvaluteService customerEvaluteService;

    @PostMapping("/add")
    public ApiResponse<CustomerResponse> addBrand(@RequestBody @Valid CustomerRequest customerRequest) {
        ApiResponse<CustomerResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("add customer successfully!");
        apiResponse.setResult(customerService.add(customerRequest));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<CustomerResponse> updateBrand(@RequestBody @Valid CustomerRequest customerRequest, @PathVariable UUID id) {
        ApiResponse<CustomerResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("update customer successfully!");
        apiResponse.setResult(customerService.update(customerRequest, id));
        return apiResponse;
    }

    @GetMapping("/list")
    public ApiResponse<List<Customer>> getAllSizes() {
        ApiResponse<List<Customer>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get all customer!");
        apiResponse.setResult(customerService.getAllCustomers());
        return apiResponse;
    }

    @PostMapping("/address/create")
    public ApiResponse<String> createAddress(@RequestBody @Valid CustomerAddressRequest customerAddressRequest) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("add customer address successfully!");
        apiResponse.setResult(customerAddressService.add(customerAddressRequest));
        return apiResponse;
    }

    @PutMapping("/address/update/{id}")
    public ApiResponse<String> updateBrand(@RequestBody @Valid CustomerAddressRequest customerAddressRequest, @PathVariable Long id) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("update customer address successfully!");
        apiResponse.setResult(customerAddressService.update(customerAddressRequest, id));
        return apiResponse;
    }

    @GetMapping("/address/list")
    public ApiResponse<List<CustomerAddress>> getAllCustomerAddress() {
        ApiResponse<List<CustomerAddress>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get all customer address!");
        apiResponse.setResult(customerAddressService.getAllCustomerAddress());
        return apiResponse;
    }

    @PostMapping("/account/create")
    public ApiResponse<AccountCustomer> createAccount(@RequestBody @Valid AccountCustomerRequest accountCustomerRequest) {
        ApiResponse<AccountCustomer> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("add customer address successfully!");
        apiResponse.setResult(accountCustomerService.add(accountCustomerRequest));
        return apiResponse;
    }

    @PutMapping("/account/update/{id}")
    public ApiResponse<AccountCustomer> updateAccount(@RequestBody @Valid AccountCustomerRequest accountCustomerRequest, @PathVariable UUID id) {
        ApiResponse<AccountCustomer> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("update customer address successfully!");
        apiResponse.setResult(accountCustomerService.update(accountCustomerRequest, id));
        return apiResponse;
    }

    @GetMapping("/account/list")
    public ApiResponse<List<AccountCustomer>> getAllAccount() {
        ApiResponse<List<AccountCustomer>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get all customer address!");
        apiResponse.setResult(accountCustomerService.getAllAccountCustomers());
        return apiResponse;
    }

    @PostMapping("/favorite/create")
    public ApiResponse<String> addFavorite(@RequestBody @Valid CustomerFavoriteRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(customerFavoriteService.add(request));
        apiResponse.setMessage("add customer favorite successfully!");
        return apiResponse;
    }

    @DeleteMapping("/favorite/delete")
    public ApiResponse<String> deleteFavorite(@RequestBody @Valid CustomerFavoriteRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(customerFavoriteService.delete(request));
        apiResponse.setMessage("delete customer favorite successfully!");
        return apiResponse;
    }

    @PostMapping("/cart/create")
    public ApiResponse<String> addCart(@RequestBody @Valid CustomerCartRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(customerCartService.add(request));
        apiResponse.setMessage("add customer cart successfully!");
        return apiResponse;
    }

    @DeleteMapping("/cart/delete")
    public ApiResponse<String> deleteCart(@RequestBody @Valid CustomerCartRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(customerCartService.delete(request));
        apiResponse.setMessage("delete customer favorite successfully!");
        return apiResponse;
    }

    @PutMapping("/cart/update")
    public ApiResponse<String> updateCart(@RequestBody @Valid CustomerCartRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(customerCartService.update(request));
        apiResponse.setMessage("delete customer favorite successfully!");
        return apiResponse;
    }

    @PostMapping("/evaluate/create")
    public ApiResponse<Evaluate> addEvaluate(@RequestBody @Valid EvaluateRequest request) {
        ApiResponse<Evaluate> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(customerEvaluteService.add(request));
        apiResponse.setMessage("add customer cart successfully!");
        return apiResponse;
    }
}
