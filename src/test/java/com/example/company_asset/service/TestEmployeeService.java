package com.example.company_asset.service;

import com.example.company_asset.model.Employee;
import com.example.company_asset.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestEmployeeService {
    @Autowired
    EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;


    @Test
    public void TestaddEmployee()
    {
        Employee e = new Employee(1111,"mocking guy");
        when(employeeRepository.save(e)).thenReturn(e);
        assertEquals("Employee Added successfully",employeeService.addEmployee(e));

    }

    @Test
    public void TestgetEmployee()
    {
        when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(1111,"mock name"),new Employee(5555,"hello")).collect(Collectors.toList()));
        assertEquals(2,employeeService.getEmployee().size());
    }

    @Test
    public void TestgetSingleEmployee()
    {
        when(employeeRepository.findById(9876)).thenReturn(Optional.of(new Employee(9876, "test employee")));
        assertEquals("test employee",employeeService.getSingleEmployee(9876).get().getName());
    }

    @Test
    public void TestdeleteEmployee()
    {
        employeeService.deleteEmployee(1111);
        int id=1111;
            verify(employeeRepository,times(1)).deleteById(id);

    }

}
