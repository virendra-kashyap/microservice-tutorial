package com.attendance.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.attendance.management.dto.AccessDTO;
import com.attendance.management.repository.AccessRepository;

@Service
@Transactional
public class AccessServiceImpl implements AccessServiceInt {

	@Autowired
	AccessRepository accessRepository;

	@Override
	public long add(AccessDTO accessDTO) {
		return accessRepository.save(accessDTO).getId();
	}

	@Override
	public void delete(long id) {
		Optional<AccessDTO> existDto = getById(id);
		if (existDto.isPresent()) {
			accessRepository.deleteById(id);
		}
	}

	@Override
	public List<AccessDTO> list() {
		return accessRepository.findAll();
	}

	@Override
	public Optional<AccessDTO> getById(long id) {
		return accessRepository.findById(id);
	}

	@Override
	public void update(AccessDTO accessDTO) {
		Optional<AccessDTO> existDto = getById(accessDTO.getId());
		if (existDto.isPresent()) {
			accessRepository.save(accessDTO);
		}
	}

}
