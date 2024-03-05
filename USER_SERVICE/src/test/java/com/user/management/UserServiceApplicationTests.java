package com.user.management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.management.dto.UserDTO;
import com.user.management.service.UserServiceInt;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private UserServiceInt userService;

	@Test
	void contextLoads() {
		assertEquals(5, userService.list().size());
	}

	@Test
	void getAllUsers_ReturnsCorrectSize() {
		List<UserDTO> users = userService.list();
		assertEquals(5, users.size());
	}

	@Test
	void getUserById_ReturnsCorrectUser() {
		// Add a test to check if getUserById() returns the correct user
		Optional<UserDTO> user = userService.getById(1);
		assertEquals("John", user.get().getFirstName());
	}

}
