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

import com.maiara.report_utility.host.service.params.IQueryParameterOptions;

import com.maiara.report_utility.host.service.params.QueryParameterOptions;

import com.maiara.report_utility_host.model.QueryParameters;

@RestController
@RequestMapping("/query_parameter")
public class QueryParameterController {
	@Autowired
	ExportUtility exportUtility = new ExportUtility();
	
  
	@PostMapping("/add")
	public void add(@RequestBody QueryParameters queryParameter) {
		
		try {
			exportUtility.queryParameter.add(new QueryParameterOptions(null, queryParameter.getDatasource_id(), queryParameter.getName(), queryParameter.getQueryParamSequenceNumber(), queryParameter.getDataType(), queryParameter.getDefaultValue(), queryParameter.isNullable(), queryParameter.getMinValue(), queryParameter.getMaxValue(), queryParameter.getMaxLength(), queryParameter.getParameterRegex(), true, queryParameter.getUpdatedBy(), queryParameter.getCreatedBy()));
		
			
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
   
	
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IQueryParameterOptions queryParameter = null;
        	try {
				queryParameter = exportUtility.queryParameter.get(id);
				return ResponseEntity.ok(queryParameter);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
            List<IQueryParameterOptions> queryParameters = exportUtility.queryParameter.get();
            return ResponseEntity.ok(queryParameters);
        }
    }

	

	
}
