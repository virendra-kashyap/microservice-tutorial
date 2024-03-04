package com.user.management.service;

import java.util.List;
import java.util.Optional;

import com.user.management.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO userDTO);

	public void delete(long id);

	public List<UserDTO> list();

	public Optional<UserDTO> getById(long id);

	public void update(UserDTO userDTO);

}
