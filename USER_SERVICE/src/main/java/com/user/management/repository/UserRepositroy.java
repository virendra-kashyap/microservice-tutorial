package com.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.dto.UserDTO;

public interface UserRepositroy extends JpaRepository<UserDTO, Long> {

	public UserDTO findByLoginId(String loginId);

}
