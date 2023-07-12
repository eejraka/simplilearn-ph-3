package com.proj.phase3.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.phase3.model.Report;
import com.proj.phase3.repository.ReportRepository;
import com.proj.phase3.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportRepository reportRepo;
	
	@Override
	public List<Report> getAll() {
		return reportRepo.findAll();
	}

	@Override
	public List<Report> getByDate(Date date) {
		return reportRepo.findAllByPdate(date);
	}

	@Override
	public List<Report> getByCat(String cat) {
		return reportRepo.findAllByPcat(cat);
	}
	

}
