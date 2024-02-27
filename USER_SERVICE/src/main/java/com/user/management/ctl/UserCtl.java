package com.user.management.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/")
public class UserCtl {

	@GetMapping("/welcome")
	public String get() {
		return "I am virendra";
	}

}
