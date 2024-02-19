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

import com.maiara.report_utility.host.service.params.DatabaseQueryOptions;
import com.maiara.report_utility.host.service.params.IDatabaseQueryOptions;


import com.maiara.report_utility_host.model.DatabaseQuery;


@RestController
@RequestMapping("/dataQuery")
public class DatabaseQueryController {
	
	@Autowired
	ExportUtility exportUtility = new ExportUtility();
	
  
	@PostMapping("/add")
	public void add(@RequestBody DatabaseQuery databaseQuery) {
		
		try {
			exportUtility.query.add(new DatabaseQueryOptions(databaseQuery.getQueryName(), databaseQuery.getQuery_text(), databaseQuery.getNo_of_parameters(), databaseQuery.getConnectionId(), databaseQuery.getParameterValueId(), true, databaseQuery.getCreatedBy(), databaseQuery.getUpdatedBy()));
			
			
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}

	}

   
	
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IDatabaseQueryOptions databaseQuery = null;
        	try {
				databaseQuery = exportUtility.query.get(id);
				return ResponseEntity.ok(databaseQuery);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
            List<IDatabaseQueryOptions> query = exportUtility.query.get();
            return ResponseEntity.ok(query);
        }
    }


}
