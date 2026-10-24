package com.utsav.employee_api;

public class EmployeeResponseDTO {
    private long id;
    private String name;

    public EmployeeResponseDTO(long id,String name){
        this.id=id;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
