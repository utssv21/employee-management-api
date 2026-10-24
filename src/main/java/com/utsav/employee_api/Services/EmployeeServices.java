
package com.utsav.employee_api.Services;

import com.utsav.employee_api.Employee;
import com.utsav.employee_api.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import com.utsav.employee_api.EmployeeNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.*;

@Service
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;
    public EmployeeServices(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }


    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public List<Employee> searchByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
    public Employee getById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found with ID: " + id
                ));
    }

    public Employee create(Employee employee) {
        employee.setId(null);
        return employeeRepository.save(employee);
    }
    public boolean update(long id,Employee entry){
        if(!employeeRepository.existsById(id)){
            return false;
        }
        entry.setId(id);
        employeeRepository.save(entry);
        return true;
    }
    public boolean deleteEmployee(long id){
        if(!employeeRepository.existsById(id)){
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }
}
