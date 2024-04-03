package com.attendance.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.management.dto.EmployeeDTO;

public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Long> {

}
