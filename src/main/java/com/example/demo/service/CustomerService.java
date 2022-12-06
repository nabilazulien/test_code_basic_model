package com.example.demo.service;

import com.example.demo.models.Result;
import com.example.demo.request.CustomerRequest;
import com.example.demo.request.UpdateCustomerRequest;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity <Result> createData (CustomerRequest customerRequest);
    ResponseEntity <Result> updateData (UpdateCustomerRequest updateCustomerRequest);
    ResponseEntity <Result> getData (String id);
    ResponseEntity <Result> getAll();
    ResponseEntity <Result> deleteData (String id);
}
