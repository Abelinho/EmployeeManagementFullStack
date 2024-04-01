package com.abel.employee.controller;

import com.abel.employee.dto.EmployeeDto;
import com.abel.employee.services.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3001")
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

private final EmployeeServiceImpl employeeServiceImpl;

@PostMapping("employees")
public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){

    return employeeServiceImpl.createEmployee(employeeDto);
}

@GetMapping("employees")
public List<EmployeeDto> getAlEmployees(){

    return employeeServiceImpl.getAllEmployees();
}

}
