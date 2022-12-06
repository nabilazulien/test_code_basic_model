package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue
    @Type(type = ("uuid-char"))
    private UUID id;
    private String fullName;
    private String dob;
    private String email;
}
