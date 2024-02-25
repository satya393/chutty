package com.chutty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chutty.repository.AttendanceRepository;
import com.chutty.service.AttendanceService;
import com.springbootcommonlib.response.Response;


@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	@Autowired
	AttendanceRepository attendanceRepository;

	@Override
	public Response getData() {
		Response response = new Response();
		
		
		
		System.out.println("pass");
		return response;
	}
	

}
