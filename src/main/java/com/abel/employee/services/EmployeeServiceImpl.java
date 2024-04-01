package com.abel.employee.services;

import com.abel.employee.dto.EmployeeDto;
import com.abel.employee.entity.Employee;
import com.abel.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //Employee employee = new Employee();
        System.out.println(employeeDto.toString());
        //BeanUtils.copyProperties(employeeDto,employee);
        Employee employee = Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .build();

        employeeRepository.save(employee);
        return employeeDto;


    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

       List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDto> empDto = employees.stream()
               .map(employee->new EmployeeDto(employee.getId(),
                       employee.getFirstName(),
                       employee.getLastName(),
                       employee.getEmail()
                       )).collect(Collectors.toList());
        return empDto;
    }
}
