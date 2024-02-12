package com.maiara.report_utility_host.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maiara.report_utility.database.entities.DatabaseSource;
import com.maiara.report_utility.host.service.ExportUtility;
import com.maiara.report_utility.host.service.params.IDatabaseSource;

@RestController
@RequestMapping("/database")
public class DatabaseSourceController {
	String name;
	String driverClass;
	String sourceName;
	
	@Autowired
	ExportUtility export = new ExportUtility();
	IDatabaseSource dbsource;
	
	@PostMapping("/add")
	public void addSource(@RequestBody DatabaseSource obj) {
		name = obj.getName();
		driverClass = obj.getDriverClass();
		sourceName = obj.getSourceName();
	    obj.setName(name);
		obj.setDriverClass(driverClass);
		obj.setSourceName(sourceName);
		export.databaseSource.add(dbsource);
	
		
		
		
	}

}
