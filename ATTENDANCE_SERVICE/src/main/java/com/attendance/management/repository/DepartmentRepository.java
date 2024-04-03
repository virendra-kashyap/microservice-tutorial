package com.attendance.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.management.dto.DepartmentDTO;

public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Long> {

}
