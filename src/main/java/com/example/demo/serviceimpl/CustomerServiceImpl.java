package com.example.demo.serviceimpl;

import com.example.demo.models.Customer;
import com.example.demo.models.Program;
import com.example.demo.models.Result;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.request.CustomerRequest;
import com.example.demo.request.UpdateCustomerRequest;
import com.example.demo.service.CustomerService;
import com.example.demo.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    StringUtil stringUtil;
    @Autowired
    CustomerRepository customerRepository;

    private Result result;

    @Override
    public ResponseEntity<Result> createData(CustomerRequest customerRequest) {
        result = new Result();
        try{
            Optional<Customer> fullName = customerRepository.findByFullName(customerRequest.getFullName());
            if (fullName.isPresent()){
                result.setMessage("Error : full name sudah ada");
                result.setCode(HttpStatus.BAD_REQUEST.value());
                return ResponseEntity.badRequest().body(result);
            }
            Customer customer = new Customer();
            customer.setId(UUID.randomUUID());
            customer.setDob(customerRequest.getDob());
            customer.setEmail(customerRequest.getEmail());
            customer.setFullName(customerRequest.getFullName());
            customerRepository.save(customer);
            result.setMessage("sukses");
            result.setCode(HttpStatus.OK.value());
            return ResponseEntity.ok().body(result);
        }catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public ResponseEntity<Result> updateData(UpdateCustomerRequest updateCustomerRequest) {
        result = new Result();
        try{
            Optional<Customer> customer = customerRepository.findById(updateCustomerRequest.getId());
            if (!customer.isPresent()){
                result.setMessage("Error : data tidak ditemukan");
                result.setCode(HttpStatus.BAD_REQUEST.value());
                return ResponseEntity.badRequest().body(result);
            }
            customer.get().setDob(updateCustomerRequest.getDob());
            customer.get().setEmail(updateCustomerRequest.getEmail());
            customer.get().setFullName(updateCustomerRequest.getFullName());
            customerRepository.save(customer.get());
            result.setMessage("sukses");
            result.setCode(HttpStatus.OK.value());
            return ResponseEntity.ok().body(result);
        }catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public ResponseEntity<Result> getData(String id) {
        result = new Result();
        Optional<Customer> customerById = customerRepository.findById(UUID.fromString(id));
        if (!customerById.isPresent()){
            result.setMessage("Error : id tidak ditemukan");
            result.setCode(HttpStatus.BAD_REQUEST.value());
            result.setSuccess(false);
        }else {
            Map<String, Customer> items = new HashMap<>();
            items.put("items", customerById.get());
            result.setData(items);
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Result> getAll() {
        result = new Result();
        try {
            Map<String, List<Customer>> items = new HashMap<>();
            Customer customer = new Customer();
            Example<Customer> example = Example.of(customer);
            items.put("items", customerRepository.findAll(example, Sort.by(Sort.Direction.ASC,"id")));
            result.setData(items);
        } catch (Exception e) {
            log.error(stringUtil.getError(e));
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Result> deleteData(String id) {
        result = new Result();
        Optional<Customer> customerById = customerRepository.findById(UUID.fromString(id));
        if (!customerById.isPresent()) {
            result.setSuccess(false);
            result.setMessage("Error: Tidak ada customer dengan id " + id);
            result.setCode(HttpStatus.BAD_REQUEST.value());
        }else {
            customerRepository.deleteById(UUID.fromString(id));
            result.setMessage("Berhasil delete program!");
            result.setCode(HttpStatus.OK.value());
        }
        return ResponseEntity.ok(result);
    }
}
