package com.srsvmj.employee_service_with_mapstruct.service;


import com.srsvmj.employee_service_with_mapstruct.dto.EmployeeDTO;


import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);
}
