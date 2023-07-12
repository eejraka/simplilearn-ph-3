package com.proj.phase3.service;

import java.util.Date;
import java.util.List;

import com.proj.phase3.model.Report;

public interface ReportService {
	List<Report> getAll();
	List<Report> getByDate(Date date);
	List<Report> getByCat(String cat);
}
