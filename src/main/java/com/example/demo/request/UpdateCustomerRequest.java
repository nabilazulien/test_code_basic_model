package com.example.demo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class UpdateCustomerRequest {

    @ApiModelProperty(example = "001", required = true)
    private UUID id;

    @ApiModelProperty(example = "nama panjang", required = true)
    private String fullName;

    @ApiModelProperty(example = "dob", required = true)
    private String dob;


    @ApiModelProperty(example = "email", required = true)
    private String email;

}
