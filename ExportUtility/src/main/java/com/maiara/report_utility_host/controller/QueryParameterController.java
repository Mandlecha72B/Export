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

import com.maiara.report_utility.database.entities.QueryParameter;
import com.maiara.report_utility.errors.DataNotFoundException;
import com.maiara.report_utility.host.service.impl.ExportUtility;
import com.maiara.report_utility.host.service.params.DatabaseConnectionOptions;
import com.maiara.report_utility.host.service.params.IDatabaseConnectionOptions;
import com.maiara.report_utility.host.service.params.IQueryParameterOptions;
import com.maiara.report_utility.host.service.params.IQueryParameterValueOptions;
import com.maiara.report_utility.host.service.params.QueryParameterOptions;
import com.maiara.report_utility_host.model.Connection;
import com.maiara.report_utility_host.model.QueryParameters;

@RestController
@RequestMapping("/query_parameter")
public class QueryParameterController {
	@Autowired
	ExportUtility export = new ExportUtility();
	
  
	@PostMapping("/add")
	public void add(@RequestBody QueryParameters obj) {
		
		try {
			export.queryParameter.add(new QueryParameterOptions(0, null, 0));
		   
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}

	}

   
	
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IQueryParameterOptions obj = null;
        	try {
				obj = export.queryParameter.get(id);
				return ResponseEntity.ok(obj);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
            List<IQueryParameterOptions> queryParameters = export.queryParameter.get();
            return ResponseEntity.ok(queryParameters);
        }
    }

	

	
}
