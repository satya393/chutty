package com.chutty.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.springbootcommonlib.mail.MailStructure;
import com.springbootcommonlib.response.Response;

import io.swagger.v3.oas.annotations.servers.Server;

public interface AttendanceService {

	Response getData(String mail, MailStructure mailStructure);

	Response genrateRandamIds(Integer range) throws IOException, ParseException;

	Response insertInToTable() throws ParseException;

	Response insertJavaListObjectToCsv() throws SQLException, FileNotFoundException, IOException;

}
