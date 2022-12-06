package com.example.demo.service;

import com.example.demo.models.Result;
import com.example.demo.request.ProgramRequest;
import com.example.demo.request.UpdateProgramRequest;
import org.springframework.http.ResponseEntity;

public interface ProgramService {
    //implements create program
    ResponseEntity<Result> createProgram(ProgramRequest program);

    //implements update program
    ResponseEntity<Result> updateProgram(UpdateProgramRequest program);

    //implements get all program
    ResponseEntity<Result> getAllProgram();

    //implements get by program id
    ResponseEntity<Result> getProgramById(Long id);

    ResponseEntity<Result> deleteProgram(Long id);
}
