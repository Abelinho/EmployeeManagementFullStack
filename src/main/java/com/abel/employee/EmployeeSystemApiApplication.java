package com.abel.employee;

import com.abel.employee.entity.Employee;
import com.abel.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeSystemApiApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSystemApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1,"Abel","Leo","abelleo@gmail.com"));
		employeeList.add(new Employee(2,"Armstrong","Nnoli","ArmNnoli@gmail.com"));
		employeeList.add(new Employee(3,"jeff","Ekanem","jefEkanem@gmail.com"));


		employeeRepository.saveAll(
				employeeList
		);

	}
}


