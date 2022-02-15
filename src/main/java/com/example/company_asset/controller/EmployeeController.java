package com.example.company_asset.controller;


import com.example.company_asset.model.AuthenticationRequest;
import com.example.company_asset.model.AuthenticationResponse;
import com.example.company_asset.model.Employee;
import com.example.company_asset.service.EmployeeService;
import com.example.company_asset.service.MyUserDetailService;
import com.example.company_asset.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/employees")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @GetMapping("/employees/{employee_id}")
    public Optional<Employee> getSingleEmployee(@PathVariable int employee_id)
    {
        return employeeService.getSingleEmployee(employee_id);
    }



    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee emp)
    {
        return employeeService.addEmployee(emp);
    }



    @DeleteMapping("/employees/{employee_id}")
    public String deleteEmployee(@PathVariable int employee_id)
    {
        return employeeService.deleteEmployee(employee_id);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
    {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );

        }catch (BadCredentialsException e)
        {
            throw new Exception("incorrect username or password",e);
        }
        final UserDetails userDetails= userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt =jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }


}
