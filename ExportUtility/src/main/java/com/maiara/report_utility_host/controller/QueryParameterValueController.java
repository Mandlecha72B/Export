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
import com.maiara.report_utility.host.service.params.IDatabaseSourceOptions;
import com.maiara.report_utility.host.service.params.IQueryParameterOptions;
import com.maiara.report_utility.host.service.params.IQueryParameterValueOptions;

import com.maiara.report_utility.host.service.params.QueryParameterValueOptions;
import com.maiara.report_utility_host.model.QueryParameterValue;

@RestController
@RequestMapping("/parameter_value")
public class QueryParameterValueController {
	@Autowired
	ExportUtility exportUtility = new ExportUtility();
	String queryParameterName;
	long queryParameterId;
  
	@PostMapping("/add")
	public void add(@RequestBody QueryParameterValue parameterValue) {
		
		try {
			
			queryParameterName = parameterValue.getQueryParameterName();
			System.out.println(queryParameterName);
			
			//Mapping datasource-name with datasource-id in dataSource table
			List<IQueryParameterOptions> queryParameters = exportUtility.queryParameter.get();
			for(IQueryParameterOptions queryParameter: queryParameters) {
				System.out.println(queryParameter.getName());
				System.out.println(queryParameter.getId());
				if(queryParameter.getName().equals(queryParameterName)) {
					queryParameterId = queryParameter.getId();
					System.out.println(queryParameterId + "Queryparameter ");
				}
				
			}
			
			
			exportUtility.queryParameterValue.add(new QueryParameterValueOptions(parameterValue.getValue(), queryParameterId, true, parameterValue.getCreatedBy(), parameterValue.getUpdatedBy()));
			
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
   
	
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IQueryParameterValueOptions parameterValue = null;
        	try {
				parameterValue = exportUtility.queryParameterValue.get(id);
				return ResponseEntity.ok(parameterValue);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
            List<IQueryParameterValueOptions> parameterValues = exportUtility.queryParameterValue.get();
            return ResponseEntity.ok(parameterValues);
        }
    }

	

}
