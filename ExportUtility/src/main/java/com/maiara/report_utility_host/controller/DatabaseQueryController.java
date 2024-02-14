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
import com.maiara.report_utility.host.service.params.IQueryParameterOptions;

import com.maiara.report_utility_host.model.DatabaseQuery;


@RestController
@RequestMapping("/dataQuery")
public class DatabaseQueryController {
	
	@Autowired
	ExportUtility export = new ExportUtility();
	
  
	@PostMapping("/add")
	public void add(@RequestBody DatabaseQuery obj) {
		
		try {
			export.query.add(new DatabaseQueryOptions(obj.getId(), obj.getName(), obj.getQuery_text(), obj.getNo_of_parameters(), obj.getConnectionId()));
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}

	}

   
	
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IDatabaseQueryOptions obj = null;
        	try {
				obj = export.query.get(id);
				return ResponseEntity.ok(obj);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
            List<IDatabaseQueryOptions> query = export.query.get();
            return ResponseEntity.ok(query);
        }
    }


}
