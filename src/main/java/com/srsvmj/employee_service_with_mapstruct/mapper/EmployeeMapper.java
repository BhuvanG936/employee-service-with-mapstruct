package com.srsvmj.employee_service_with_mapstruct.mapper;

import com.srsvmj.employee_service_with_mapstruct.dto.EmployeeDTO;
import com.srsvmj.employee_service_with_mapstruct.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    //Convert Employee JPA Entity to EmployeeDTO

    EmployeeDTO mapToEmployeeDTO(Employee employee);

    //Convert EmployeeDTO  to Employee JPA Entity
    Employee mapToEmployee(EmployeeDTO employeeDTO);


}
