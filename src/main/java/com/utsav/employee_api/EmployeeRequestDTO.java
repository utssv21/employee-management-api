
package com.utsav.employee_api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class EmployeeRequestDTO {

    @NotBlank(message = "Employee name cannot be blank")
    private String name;

    @Positive(message = "Salary must be greater than zero")
    private int salary;

    public EmployeeRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
