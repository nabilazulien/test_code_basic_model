package com.example.demo.controller;

import com.example.demo.models.Customer;
import com.example.demo.models.Result;
import com.example.demo.request.CustomerRequest;
import com.example.demo.request.UpdateCustomerRequest;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Result> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        return customerService.createData(customerRequest);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> updateCustomer(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        log.info("ini update");
        return customerService.updateData(updateCustomerRequest);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> getCustomerById(@PathVariable("id") String id) {
        return customerService.getData(id);
    }

    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> getCustomerAll() {
        return customerService.getAll();
    }

    @DeleteMapping(value = "/delete/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> deleteProgram(@PathVariable("id") String id) {
        return customerService.deleteData(id);
    }
}
