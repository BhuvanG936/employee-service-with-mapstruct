package com.srsvmj.employee_service_with_mapstruct.service.impl;

import com.srsvmj.employee_service_with_mapstruct.dto.EmployeeDTO;
import com.srsvmj.employee_service_with_mapstruct.entity.Employee;
import com.srsvmj.employee_service_with_mapstruct.exception.ResourceNotFoundException;
import com.srsvmj.employee_service_with_mapstruct.mapper.EmployeeMapper;
import com.srsvmj.employee_service_with_mapstruct.repository.EmployeeRepository;
import com.srsvmj.employee_service_with_mapstruct.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDTO);

        Employee savedEmployee =  employeeRepository.save(employee);

        return EmployeeMapper.MAPPER.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee Not Exist with the given id: "+id));

        return EmployeeMapper.MAPPER.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(EmployeeMapper.MAPPER::mapToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployee) {

        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee does not exist with given id: "+id));

        employee.setId(updatedEmployee.getId());
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj =  employeeRepository.save(employee);

        return EmployeeMapper.MAPPER.mapToEmployeeDTO(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee Not Exist with the given id: "+id));

        employeeRepository.delete(employee);
    }

/*    @Override
    public EmployeeDTO mapToEmployeeDTO(Employee employee) {

        return EmployeeMapper.MAPPER.mapToEmployeeDTO(employee);
    }

    @Override
    public Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return EmployeeMapper.MAPPER.mapToEmployee(employeeDTO);
    }*/
}