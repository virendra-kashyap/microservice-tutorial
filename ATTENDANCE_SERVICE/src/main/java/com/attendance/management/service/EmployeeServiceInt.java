package com.attendance.management.service;

import java.util.List;
import java.util.Optional;

import com.attendance.management.dto.EmployeeDTO;

public interface EmployeeServiceInt {

	public long add(EmployeeDTO employeeDTO);

	public void delete(long id);

	public List<EmployeeDTO> list();

	public Optional<EmployeeDTO> getById(long id);

	public void update(EmployeeDTO employeeDTO);

}