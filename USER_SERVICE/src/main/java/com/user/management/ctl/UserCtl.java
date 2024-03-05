package com.user.management.ctl;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.common.ORSResponse;
import com.user.management.dto.UserDTO;
import com.user.management.service.UserServiceInt;

@RestController
@RequestMapping("/api/v1/user/")
public class UserCtl {

	private final UserServiceInt userServiceInt;

	public UserCtl(UserServiceInt userServiceInt) {
		this.userServiceInt = userServiceInt;
	}

	@GetMapping("/welcome")
	public String get() {
		return "I am virendra";
	}

	@PostMapping("save")
	public ORSResponse save(@RequestBody UserDTO userDTO) {
		ORSResponse response = new ORSResponse();

		if (userDTO.getId() > 0) {
			userServiceInt.update(userDTO);
			response.setSuccess(true);
			response.addMessage("Record Successfully updated.");
		} else {
			long id = userServiceInt.add(userDTO);
			response.addData(id);
			response.setSuccess(true);
			response.addMessage("Record Successfully added.");
		}
		return response;
	}

	@GetMapping("search")
	public ORSResponse search() {
		ORSResponse response = new ORSResponse();
		List<UserDTO> list = userServiceInt.list();
		if (!list.isEmpty()) {
			response.setSuccess(true);
			response.addData(list);
		} else {
			response.setSuccess(false);
			response.addMessage("Record not found.!!");
		}
		return response;
	}

	@GetMapping("getById/{id}")
	public ORSResponse getById(@PathVariable("id") long id) {
		ORSResponse response = new ORSResponse();
		Optional<UserDTO> data = userServiceInt.getById(id);
		if (data.isPresent()) {
			response.setSuccess(true);
			response.addData(data);
		} else {
			response.setSuccess(false);
			response.addMessage("Record not found.!!");
		}
		return response;
	}

	@GetMapping("deleteById/{id}")
	public ORSResponse deleteById(@PathVariable("id") long id) {
		ORSResponse response = new ORSResponse();
		userServiceInt.delete(id);
		response.setSuccess(true);
		response.addMessage("Record successfully delete");
		return response;
	}

}
