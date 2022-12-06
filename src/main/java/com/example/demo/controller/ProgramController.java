package com.example.demo.controller;

import com.example.demo.models.Result;
import com.example.demo.request.ProgramRequest;
import com.example.demo.request.UpdateProgramRequest;
import com.example.demo.service.ProgramService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/program")
public class ProgramController {

    @Autowired
    ProgramService service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @PostMapping("/create")
    public ResponseEntity<Result> createProgram(@Valid @RequestBody ProgramRequest program) {
        return service.createProgram(program);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> updateProgram(@Valid @RequestBody UpdateProgramRequest program) {
        return service.updateProgram(program);
    }

    @DeleteMapping(value = "/delete/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> deleteProgram(@PathVariable("id") Long id) {
        return service.deleteProgram(id);
    }


    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> getAllProgram() {
        return service.getAllProgram();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> getProgramById(@PathVariable("id") Long id) {
        return service.getProgramById(id);
    }



}
