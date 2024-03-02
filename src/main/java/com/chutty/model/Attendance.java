package com.chutty.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="attendance")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer attendanceId;
//	Date attendeDate;
	String employeName;
	Integer age;
	String email;
	String phoneNo;
	
//	Date attendeInTime;
//	Date attendeOutTime;
	
	
	
	

}
