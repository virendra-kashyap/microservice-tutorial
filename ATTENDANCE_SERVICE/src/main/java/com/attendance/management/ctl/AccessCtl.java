package com.attendance.management.ctl;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.management.common.ORSResponse;
import com.attendance.management.dto.AccessDTO;
import com.attendance.management.service.AccessServiceInt;

@RestController
@RequestMapping("/api/v1/access/")
public class AccessCtl {

	private final AccessServiceInt accessServiceInt;

	public AccessCtl(AccessServiceInt accessServiceInt) {
		this.accessServiceInt = accessServiceInt;
	}

	@PostMapping("save")
	public ORSResponse save(@RequestBody AccessDTO accessDTO) {
		ORSResponse response = new ORSResponse();

		if (accessDTO.getId() > 0) {
			accessServiceInt.update(accessDTO);
			response.setSuccess(true);
			response.addMessage("Record Successfully updated.");
		} else {
			long id = accessServiceInt.add(accessDTO);
			response.addData(id);
			response.setSuccess(true);
			response.addMessage("Record Successfully added.");
		}
		return response;
	}

	@GetMapping("search")
	public ORSResponse search() {
		ORSResponse response = new ORSResponse();
		List<AccessDTO> list = accessServiceInt.list();
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
		Optional<AccessDTO> data = accessServiceInt.getById(id);
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
		accessServiceInt.delete(id);
		response.setSuccess(true);
		response.addMessage("Record successfully delete");
		return response;
	}

}
