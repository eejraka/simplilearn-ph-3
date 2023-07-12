package com.proj.phase3.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.phase3.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{
	List<Report> findAllByPdate(Date pdate);
	List<Report> findAllByPcat(String cat);
}
