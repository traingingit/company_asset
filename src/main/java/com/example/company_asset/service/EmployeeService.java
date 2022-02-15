package com.example.company_asset.service;

import com.example.company_asset.model.Employee;
import com.example.company_asset.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployee()
    {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getSingleEmployee(int employee_id)
    {
        return employeeRepository.findById(employee_id);
    }

    public String addEmployee(Employee emp) {
        employeeRepository.save(emp);
        return "Employee Added successfully";
    }

    public String deleteEmployee(int employee_id) {
        employeeRepository.deleteById(employee_id);
        return "Employee deleted";
    }


}
