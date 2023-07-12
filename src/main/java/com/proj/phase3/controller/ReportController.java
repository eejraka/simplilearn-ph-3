package com.proj.phase3.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.phase3.model.Report;
import com.proj.phase3.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {
	
	@Autowired
	private ReportService repoService;
	
	@GetMapping
	public ResponseEntity<List<Report>> getAll(){
		return new ResponseEntity<List<Report>>(repoService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/date/{date}")
	public ResponseEntity<List<Report>> getByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
		return new ResponseEntity<List<Report>>(repoService.getByDate(date), HttpStatus.OK);
	}
	
	@GetMapping("/cat/{cat}")
	public ResponseEntity<List<Report>> getByCat(@PathVariable String cat){
		return new ResponseEntity<List<Report>>(repoService.getByCat(cat), HttpStatus.OK);
	}
}
