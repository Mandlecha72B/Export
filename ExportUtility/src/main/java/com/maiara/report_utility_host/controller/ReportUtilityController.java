package com.maiara.report_utility_host.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maiara.report_utility.host.service.ExportUtility;
import com.maiara.report_utility.host.service.params.IDatabaseSource;

@RestController
@RequestMapping("/data")
public  class ReportUtilityController {
	
	@Autowired
	ExportUtility export;
	
	@GetMapping("/get")
	public  ResponseEntity<List<IDatabaseSource>> DatabaseSource() {
		List<IDatabaseSource> list = export.databaseSource.get();
		for(IDatabaseSource i : list) {
			System.out.println(i.getName());
		}
		return ResponseEntity.ok(list);
		
	}

}
