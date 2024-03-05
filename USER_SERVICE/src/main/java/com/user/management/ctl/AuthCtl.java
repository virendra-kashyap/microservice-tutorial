package com.user.management.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.common.ORSResponse;
import com.user.management.dto.UserDTO;
import com.user.management.form.AuthForm;
import com.user.management.service.UserServiceInt;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthCtl {

	private final UserServiceInt userServiceInt;

	public AuthCtl(UserServiceInt userServiceInt) {
		this.userServiceInt = userServiceInt;
	}

	@GetMapping("welcome")
	public String welcome() {
		return "Login Response";
	}

	@PostMapping("login")
	public ORSResponse login(@RequestBody AuthForm form) {
		ORSResponse response = new ORSResponse(false);
		UserDTO userDTO = userServiceInt.authenticate(form.getLoginId(), form.getPassword());
		if (userDTO != null) {
			response.setSuccess(true);
			response.addData(userDTO);
		} else {
			response.setSuccess(false);
			response.addMessage("Login Failed!");

		}
		return response;
	}

}
