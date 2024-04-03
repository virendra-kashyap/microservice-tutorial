package com.attendance.management.ctl;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.attendance.management.common.ORSResponse;
import com.attendance.management.dto.EmployeeDTO;
import com.attendance.management.dto.UserDTO;
import com.attendance.management.service.EmployeeServiceInt;

@RestController
@RequestMapping("/api/v1/employee/")
public class EmployeeCtl {

	@Autowired
	private RestTemplate restTemplate;

	private final EmployeeServiceInt employeeServiceInt;

	public EmployeeCtl(EmployeeServiceInt employeeServiceInt) {
		this.employeeServiceInt = employeeServiceInt;
	}

	@PostMapping("save")
	public ORSResponse save(@RequestBody EmployeeDTO employeeDTO) {
		ORSResponse response = new ORSResponse();

		UserDTO userDTO = new UserDTO(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getLoginId(),
				employeeDTO.getPassword());

		if (employeeDTO.getId() > 0) {
			employeeServiceInt.update(employeeDTO);
			response.setSuccess(true);
			response.addMessage("Record Successfully updated.");
		} else {
			String url = "http://localhost:7000/api/v1/user/save";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<UserDTO> requestEntity = new HttpEntity<>(userDTO, headers);

			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
					String.class);

			String responseBody = responseEntity.getBody();
			JSONObject jsonResponse = new JSONObject(responseBody);
			int data = jsonResponse.getJSONObject("result").getInt("data");
			System.out.println("data## " + data);

			employeeDTO.setUserId(data);
			long id = employeeServiceInt.add(employeeDTO);
			response.addData(id);
			response.setSuccess(true);
			response.addMessage("Record Successfully added.");
		}
		return response;
	}

	@GetMapping("search")
	public ORSResponse search() {
		ORSResponse response = new ORSResponse();
		List<EmployeeDTO> list = employeeServiceInt.list();
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
		Optional<EmployeeDTO> data = employeeServiceInt.getById(id);
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
		employeeServiceInt.delete(id);
		response.setSuccess(true);
		response.addMessage("Record successfully delete");
		return response;
	}

}