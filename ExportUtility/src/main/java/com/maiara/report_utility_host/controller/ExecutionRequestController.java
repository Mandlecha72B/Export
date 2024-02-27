package com.maiara.report_utility_host.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiara.report_utility.errors.DataNotFoundException;
import com.maiara.report_utility.host.service.impl.ExportUtility;

import com.maiara.report_utility.host.service.params.IExecutionRequestOptions;

@RestController
@RequestMapping("/executeRequest")
public class ExecutionRequestController {
	@Autowired
	ExportUtility exportUtility = new ExportUtility();
	
  
	
	

   
	
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IExecutionRequestOptions executeRequest = null;
        	try {
        		
        		//Fetching specific ExecutionRequest  data based on id
				executeRequest = exportUtility.executionRequest.get(id);
				
				return ResponseEntity.ok(executeRequest);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
        	
        	//Fetching  entire ExecutionRequest data 
            List<IExecutionRequestOptions> executionRequest = exportUtility.executionRequest.get();
            return ResponseEntity.ok(executionRequest);
        }
    }

}
