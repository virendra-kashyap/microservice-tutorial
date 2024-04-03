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
import com.attendance.management.dto.DepartmentDTO;
import com.attendance.management.service.DepartmentServiceInt;

@RestController
@RequestMapping("/api/v1/department/")
public class DepartmentCtl {

	private final DepartmentServiceInt departmentServiceInt;

	public DepartmentCtl(DepartmentServiceInt departmentServiceInt) {
		this.departmentServiceInt = departmentServiceInt;
	}

	@PostMapping("save")
	public ORSResponse save(@RequestBody DepartmentDTO departmentDTO) {
		ORSResponse response = new ORSResponse();

		if (departmentDTO.getId() > 0) {
			departmentServiceInt.update(departmentDTO);
			response.setSuccess(true);
			response.addMessage("Record Successfully updated.");
		} else {
			long id = departmentServiceInt.add(departmentDTO);
			response.addData(id);
			response.setSuccess(true);
			response.addMessage("Record Successfully added.");
		}
		return response;
	}

	@GetMapping("search")
	public ORSResponse search() {
		ORSResponse response = new ORSResponse();
		List<DepartmentDTO> list = departmentServiceInt.list();
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
		Optional<DepartmentDTO> data = departmentServiceInt.getById(id);
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
		departmentServiceInt.delete(id);
		response.setSuccess(true);
		response.addMessage("Record successfully delete");
		return response;
	}

}