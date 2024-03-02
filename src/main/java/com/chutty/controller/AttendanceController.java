package com.chutty.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chutty.model.Attendance;
import com.chutty.service.AttendanceService;
import com.springbootcommonlib.mail.MailStructure;
import com.springbootcommonlib.response.Response;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	AttendanceService attendanceService;
	
	@GetMapping("/health")
	public String health() {
		return "Success";
	}
	
	@PostMapping("/getData/{mail}")
	public Response getData(@PathVariable String mail, @RequestBody MailStructure mailStructure) {
		return attendanceService.getData(mail,mailStructure);
	}
	
	@PostMapping("/genrateRandamData")
	public Response genrateRandamIds(@RequestParam Integer range) throws IOException ,ParseException {
		return attendanceService.genrateRandamIds(range);
	}
	
	@PostMapping("/insertInToTable")
	public Response insertInToTable() throws ParseException{
		return attendanceService.insertInToTable();
	}
	
	@PostMapping("/insertJavaListObjectToCsv")
	public Response insertJavaListObjectToCsv() throws ParseException, FileNotFoundException, SQLException, IOException{
		return attendanceService.insertJavaListObjectToCsv();
	}

}
