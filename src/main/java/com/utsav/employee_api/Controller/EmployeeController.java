package com.utsav.employee_api.Controller;

import com.utsav.employee_api.Employee;
import com.utsav.employee_api.EmployeeRequestDTO;
import com.utsav.employee_api.EmployeeResponseDTO;
import com.utsav.employee_api.Services.EmployeeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@RestController
public class EmployeeController {

    private final EmployeeServices employeeServices;
    public EmployeeController(EmployeeServices employeeServices){
        this.employeeServices=employeeServices;
    }

    @GetMapping("/getall")
    public ResponseEntity<Page<Employee>> getall(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return ResponseEntity.ok(employeeServices.getAll(pageable));
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<EmployeeResponseDTO> getbyid(@PathVariable long id){
        Employee employee=employeeServices.getById(id);
        EmployeeResponseDTO dto=new EmployeeResponseDTO(employee.getId(), employee.getName());
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/employees/search")
    public ResponseEntity<List<Employee>> getByName(@RequestParam String name){
        return ResponseEntity.ok(employeeServices.searchByName(name));
    }

    @PostMapping("/employees")
    public ResponseEntity<String> post(
            @Valid @RequestBody EmployeeRequestDTO request) {

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());

        Employee savedEmployee = employeeServices.create(employee);

        return ResponseEntity.status(201)
                .body("Employee created successfully with ID: "
                        + savedEmployee.getId());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateData(@PathVariable long id,@RequestBody Employee updateEmployee){
        boolean val= employeeServices.update(id,updateEmployee);
        if(val){
            return ResponseEntity.ok("Employee updated successfully");
        }
        return ResponseEntity.status(404).body("Employee not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteData(@PathVariable long id){
        boolean val=employeeServices.deleteEmployee(id);
        if(val){
            return ResponseEntity.ok("employee deleted");
        }
        return ResponseEntity.status(404).body("invalid id entered");
    }
}