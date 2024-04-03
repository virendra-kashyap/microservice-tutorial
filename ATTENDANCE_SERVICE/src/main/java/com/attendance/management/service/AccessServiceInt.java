package com.attendance.management.service;

import java.util.List;
import java.util.Optional;

import com.attendance.management.dto.AccessDTO;

public interface AccessServiceInt {

	public long add(AccessDTO accessDTO);

	public void delete(long id);

	public List<AccessDTO> list();

	public Optional<AccessDTO> getById(long id);

	public void update(AccessDTO accessDTO);

}
