package com.attendance.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.attendance.management.dto.DepartmentDTO;
import com.attendance.management.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentServiceInt {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public long add(DepartmentDTO departmentDTO) {
		return departmentRepository.save(departmentDTO).getId();
	}

	@Override
	public void delete(long id) {
		Optional<DepartmentDTO> existDto = getById(id);
		if (existDto.isPresent()) {
			departmentRepository.deleteById(id);
		}
	}

	@Override
	public List<DepartmentDTO> list() {
		return departmentRepository.findAll();
	}

	@Override
	public Optional<DepartmentDTO> getById(long id) {
		return departmentRepository.findById(id);
	}

	@Override
	public void update(DepartmentDTO departmentDTO) {
		Optional<DepartmentDTO> existDto = getById(departmentDTO.getId());
		if (existDto.isPresent()) {
			departmentRepository.save(departmentDTO);
		}
	}
}