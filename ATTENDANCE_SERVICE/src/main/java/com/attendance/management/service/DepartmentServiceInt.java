package com.attendance.management.service;

import java.util.List;
import java.util.Optional;

import com.attendance.management.dto.DepartmentDTO;

public interface DepartmentServiceInt {

	public long add(DepartmentDTO departmentDTO);

	public void delete(long id);

	public List<DepartmentDTO> list();

	public Optional<DepartmentDTO> getById(long id);

	public void update(DepartmentDTO departmentDTO);

}
