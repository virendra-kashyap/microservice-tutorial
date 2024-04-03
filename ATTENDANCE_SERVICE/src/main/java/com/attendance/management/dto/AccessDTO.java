package com.attendance.management.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCESS")
public class AccessDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private long id;

	@Column(name = "EMPLOYEE_ID")
	private long employeeId;

	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	@Column(name = "ATTENDANCE_DATE")
	private String attendanceDate;

	@Column(name = "IN_DATE_TIME")
	private String inDateTime;

	@Column(name = "OUT_DATE_TIME")
	private String outDateTime;

	@Column(name = "STATUS")
	private String status;

}
