package com.employee.employee.backend.controller;

import com.employee.employee.backend.dto.EmployeeDTO;
import com.employee.employee.backend.model.Employee;
import com.employee.employee.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allemployee")
    public List<EmployeeDTO> allEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("addemployee")
    public EmployeeDTO addEmployee (@RequestBody EmployeeDTO employeeDTO){
        return employeeService.addEmployee(employeeDTO);
    }
}
