package com.attendance.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.attendance.management.dto.EmployeeDTO;
import com.attendance.management.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeServiceInt {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public long add(EmployeeDTO employeeDTO) {
		return employeeRepository.save(employeeDTO).getId();
	}

	@Override
	public void delete(long id) {
		Optional<EmployeeDTO> existDto = getById(id);
		if (existDto.isPresent()) {
			employeeRepository.deleteById(id);
		}
	}

	@Override
	public List<EmployeeDTO> list() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<EmployeeDTO> getById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void update(EmployeeDTO employeeDTO) {
		Optional<EmployeeDTO> existDto = getById(employeeDTO.getId());
		if (existDto.isPresent()) {
			employeeRepository.save(employeeDTO);
		}
	}

}
