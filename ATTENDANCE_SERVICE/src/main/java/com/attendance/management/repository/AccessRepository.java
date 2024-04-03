package com.attendance.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.management.dto.AccessDTO;

public interface AccessRepository extends JpaRepository<AccessDTO, Long> {

}
