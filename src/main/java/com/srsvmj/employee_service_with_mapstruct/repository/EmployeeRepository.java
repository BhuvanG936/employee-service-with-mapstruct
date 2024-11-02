package com.srsvmj.employee_service_with_mapstruct.repository;


import com.srsvmj.employee_service_with_mapstruct.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
