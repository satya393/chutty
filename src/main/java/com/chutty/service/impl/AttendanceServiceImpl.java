package com.chutty.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chutty.model.Attendance;
import com.chutty.repository.AttendanceRepository;
import com.chutty.service.AttendanceService;
import com.springbootcommonlib.mail.MailServiceImpl;
import com.springbootcommonlib.mail.MailStructure;
import com.springbootcommonlib.response.Response;
import com.springbootcommonlib.utils.DateUtils;
import com.springbootcommonlib.utils.RegularExpressionUtils;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	AttendanceRepository attendanceRepository;

	@Autowired
	MailServiceImpl mailServiceImpl;

	@Autowired
	private DataSource dataSource;

	@Override
	public Response getData(String mail, MailStructure mailStructure) {
		Response response = new Response();
		System.out.println(mail);
		mailServiceImpl.sendMail(mail, mailStructure);
		System.out.println("pass");
		return response;
	}

	@Override
	public Response genrateRandamIds(Integer range) throws IOException, ParseException {

		System.out.println(range);
		Response response = new Response();

		FileWriter fileWriter = new FileWriter("C:\\Users\\shaik\\OneDrive\\Desktop\\example.csv");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		String phoneNo = "9912123333";
		Integer age = 26;
		bufferedWriter.write("attendanceId,employeName,email,phoneNo,age");
		bufferedWriter.newLine();
		for (long i = 0; i <= range; i++) {
			long attendanceId = i;
			bufferedWriter.write(attendanceId + "," + RegularExpressionUtils.generateRandomName() + ","+ RegularExpressionUtils.generateRandomEmail() + "," + phoneNo + "," + age);
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
		response.setDetails("check your path");
		return response;
	}

	@Override
	public Response insertInToTable() {
		Response response = new Response();
		List<Attendance> example = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(
				new FileReader("C:\\Users\\shaik\\OneDrive\\Desktop\\example.csv"))) {
			String line = null;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				Attendance attendance = new Attendance();
				int attendanceId = Integer.parseInt(fields[0]);
				attendance.setAttendanceId(attendanceId);
				attendance.setEmployeName(fields[1]);
				attendance.setEmail(fields[2]);
				attendance.setPhoneNo(fields[3]);
				int age = Integer.parseInt(fields[4]);
				attendance.setAge(age);
				example.add(attendance);
				response.setDetails(" complited uplodin file csv");
			}
			attendanceRepository.saveAll(example);
		} catch (Exception e) {
			System.out.println(e);
			response.setDetails(" fail to uplood csv file");
		}
		return response;
	}

	@Override
	public Response insertJavaListObjectToCsv() throws SQLException, FileNotFoundException, IOException {
		Response response = new Response();
		
		try (Connection connection = dataSource.getConnection()) {
			CopyManager copyManager = new CopyManager(connection.unwrap(BaseConnection.class));
			String copyCommand = "COPY attendance(attendance_id,employe_name,email,phone_no,age) FROM STDIN WITH CSV HEADER DELIMITER ','";

			try (FileReader fileReader = new FileReader("C:\\Users\\shaik\\OneDrive\\Desktop\\example.csv")) {
				copyManager.copyIn(copyCommand, fileReader);
				response.setDetails("uploding finish");
			}
		}
		return response;
	}

}
