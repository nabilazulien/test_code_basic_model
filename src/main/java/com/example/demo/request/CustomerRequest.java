package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRequest {
    private String fullName;
    private String dob;
    private String email;
}
