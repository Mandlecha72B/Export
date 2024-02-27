package com.maiara.report_utility_host.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maiara.report_utility.enums.FormatType;
import com.maiara.report_utility.host.service.impl.ExportUtility;
import com.maiara.report_utility.host.service.params.ExecutionRequestOptions;
import com.maiara.report_utility.host.service.params.IDatabaseQueryOptions;

import com.maiara.report_utility.host.service.params.IExecutionRequestOptions;
import com.maiara.report_utility.host.service.params.IExportDestinationOptions;
import com.maiara.report_utility.host.service.params.IExportFormatOptions;
import com.maiara.report_utility_host.model.ExecutionRequest;

@RestController
@RequestMapping("/export-utility")
public class ExportController {
	long destinationId;
	long formatId;
	long queryId;
	
	String destination;
	String queryName;
	FormatType formatType ;

	@Autowired
	ExportUtility exportUtility;
	@PostMapping("/export")
	public void export(@RequestBody ExecutionRequest executionRequest) {
		
		this.destination = executionRequest.getDestination();
		System.out.println(this.destination);
		
		//Fetching destinationId
		
		List<IExportDestinationOptions> exportDestinations = exportUtility.exportDestination.get();
		for(IExportDestinationOptions exportDestination: exportDestinations) {
			System.out.println(exportDestination.getName());
			System.out.println(exportDestination.getId());
			if(exportDestination.getName().equals(this.destination)) {
				destinationId = exportDestination.getId();
				System.out.println( destinationId+ "destination ");
			}
			
		}
		
		//Fetching QueryId
		this.queryName = executionRequest.getQueryName();
		System.out.println(this.queryName);
		
		List<IDatabaseQueryOptions> dabaseQueries = exportUtility.query.get();
		for(IDatabaseQueryOptions dabaseQuery: dabaseQueries) {
			System.out.println(dabaseQuery.getQueryName());
			System.out.println(dabaseQuery.getId());
			if(dabaseQuery.getQueryName().equals(this.queryName)) {
				queryId = dabaseQuery.getId();
				System.out.println(queryId + "QueryName ");
			}
			
		}
		
		//Fetching FormatId
		this.formatType = executionRequest.getFormatType();
		System.out.println(this.formatType);
		List<IExportFormatOptions> exportFormats = exportUtility.exportFormat.get();
		for(IExportFormatOptions exportFormat: exportFormats) {
			System.out.println(exportFormat.getFormatType());
			System.out.println(exportFormat.getId());
			
	
			if(exportFormat.getFormatType().equals(this.formatType)) {
				formatId = exportFormat.getId();
				System.out.println(formatId + "Format ");
			}
			
		}
		
		
		
		//Executing export format

        IExecutionRequestOptions executionRequestOptions = new ExecutionRequestOptions(queryId, null, null, formatId, destinationId, executionRequest.getFilename(), true, executionRequest.getCreatedBy(), executionRequest.getUpdatedBy());
        exportUtility.export(executionRequestOptions);
		
	}
	
	
}
