package com.maiara.report_utility_host.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiara.report_utility.errors.DataNotFoundException;
import com.maiara.report_utility.host.service.impl.ExportUtility;
import com.maiara.report_utility.host.service.params.DatabaseConnectionOptions;
import com.maiara.report_utility.host.service.params.IDatabaseConnectionOptions;
import com.maiara.report_utility_host.model.Connection;
import com.maiara.report_utility_host.model.EntitySequenceTable;

@RestController
@RequestMapping("/sequenceTable")

public class EntitySequenceTableController {
	
	@Autowired
	ExportUtility export = new ExportUtility();
	
  
	@PostMapping("/add")
	public void add(@RequestBody EntitySequenceTable obj) {
		
		
		
	}

   
	
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IDatabaseConnectionOptions obj = null;
        	try {
				obj = export.connection.get(id);
				return ResponseEntity.ok(obj);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
            List<IDatabaseConnectionOptions> connections = export.connection.get();
            return ResponseEntity.ok(connections);
        }
    }


}