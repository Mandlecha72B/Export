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
import com.maiara.report_utility.host.service.params.IExecutionLogOptions;

@RestController
@RequestMapping("/executeLog")
public class ExecutionLogController {
	
	@Autowired
	ExportUtility exportUtility = new ExportUtility();
	
	
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IExecutionLogOptions executeLog = null;
        	try {
				executeLog = exportUtility.executionLog.get(id);
				
				return ResponseEntity.ok(executeLog);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
            List<IExecutionLogOptions> executionLog = exportUtility.executionLog.get();
            return ResponseEntity.ok(executionLog);
        }
    }


}
