package com.maiara.report_utility_host.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiara.report_utility.errors.DataNotFoundException;
import com.maiara.report_utility.host.service.impl.ExportUtility;

import com.maiara.report_utility.host.service.params.IDatabaseSourceOptions;

@RestController
@RequestMapping("/datasource")
@CrossOrigin(origins = "http://localhost:4200")
public class DatabaseSourceController {
	String name;
	String driverClass;
	String sourceName;
	
	@Autowired
	ExportUtility exportUtility = new ExportUtility();
	
	
	@GetMapping("/get")
	public ResponseEntity<?> get(@RequestParam (required = false) Long id){
		if(id!=null) {
			IDatabaseSourceOptions databaseSource = null;
			try {
				databaseSource = exportUtility.databaseSource.get(id);
				return ResponseEntity.ok(databaseSource);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}
			
		}
		else{
			List<IDatabaseSourceOptions> datasources = exportUtility.databaseSource.get();
			return ResponseEntity.ok(datasources);
			

		}
	}
}
		