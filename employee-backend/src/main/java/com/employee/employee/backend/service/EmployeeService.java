package com.employee.employee.backend.service;

import com.employee.employee.backend.dto.EmployeeDTO;
import com.employee.employee.backend.model.Employee;
import com.employee.employee.backend.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<EmployeeDTO>  getAllEmployees(){
        List<Employee> employees = employeeRepo.findAll();
        return modelMapper.map(employees, new TypeToken<List<EmployeeDTO>>(){}.getType());
    }

    public EmployeeDTO addEmployee( EmployeeDTO employeeDTO){
        employeeRepo.save(modelMapper.map(employeeDTO,Employee.class));
        return employeeDTO;
    }
}
