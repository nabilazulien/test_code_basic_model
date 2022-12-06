package com.example.demo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateProgramRequest {

    @ApiModelProperty(example = "1", required = true)
    private Long id;


    @ApiModelProperty(example = "nama program", required = true)
    private String program_name;


    @ApiModelProperty(example = "deskripsi", required = true)
    private String description;

    @ApiModelProperty(example = "true", required = true)
    private boolean soft_delete;

    public UpdateProgramRequest() {
    }

    public UpdateProgramRequest(Long id, String program_name, String description, boolean soft_delete) {
        this.id = id;
        this.program_name = program_name;
        this.description = description;
        this.soft_delete = soft_delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSoft_delete() {
        return soft_delete;
    }

    public void setSoft_delete(boolean soft_delete) {
        this.soft_delete = soft_delete;
    }
}
