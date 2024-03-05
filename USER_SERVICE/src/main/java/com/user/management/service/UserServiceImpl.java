package com.user.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.management.dto.UserDTO;
import com.user.management.repository.UserRepositroy;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInt {

	private final UserRepositroy userRepositroy;

	public UserServiceImpl(UserRepositroy userRepositroy) {
		this.userRepositroy = userRepositroy;
	}

	@Override
	public long add(UserDTO userDTO) {
		return userRepositroy.save(userDTO).getId();
	}

	@Override
	public void delete(long id) {
		Optional<UserDTO> existDto = getById(id);
		if (existDto.isPresent()) {
			userRepositroy.deleteById(id);
		}
	}

	@Override
	public List<UserDTO> list() {
		return userRepositroy.findAll();
	}

	@Override
	public Optional<UserDTO> getById(long id) {
		return userRepositroy.findById(id);
	}

	@Override
	public void update(UserDTO userDTO) {
		Optional<UserDTO> existDto = getById(userDTO.getId());
		if (existDto.isPresent()) {
			userRepositroy.save(userDTO);
		}
	}

}
