package com.utsav.employee_api.Repository;
import java.util.*;
import com.utsav.employee_api.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);
}