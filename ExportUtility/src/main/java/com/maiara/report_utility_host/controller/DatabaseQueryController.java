package com.maiara.report_utility_host.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiara.report_utility.errors.DataNotFoundException;
import com.maiara.report_utility.host.service.impl.ExportUtility;

import com.maiara.report_utility.host.service.params.DatabaseQueryOptions;
import com.maiara.report_utility.host.service.params.IDatabaseConnectionOptions;
import com.maiara.report_utility.host.service.params.IDatabaseQueryOptions;
import com.maiara.report_utility.host.service.params.IDatabaseSourceOptions;
import com.maiara.report_utility_host.model.DatabaseQuery;


@RestController
@RequestMapping("/dataQuery")
public class DatabaseQueryController {
	
	@Autowired
	ExportUtility exportUtility = new ExportUtility();
	String connectionName;
	long connectonId;
	long queryId;
	List<IDatabaseQueryOptions> query;
  
	@PostMapping("/add")
	public IDatabaseQueryOptions  add(@RequestBody DatabaseQuery databaseQuery) {
		
	    connectionName = databaseQuery.getConnectionName();
		System.out.println(connectionName);
		
		//Mapping connection-name with connection-id in connection table
		
		List<IDatabaseConnectionOptions> connections = exportUtility.connection.get();
		for( IDatabaseConnectionOptions connection: connections ) {
			System.out.println(connection.getConnectionName());
			System.out.println(connection.getId());
			if(connection.getConnectionName().equals(connectionName)) {
				connectonId = connection.getId();
				System.out.println(connectonId + "Connection ");
			}
			
		}
		try {
			
			//adding DatabaseQuery
			return exportUtility.query.add(new DatabaseQueryOptions(1, databaseQuery.getQueryName(), databaseQuery.getQuery_text(),databaseQuery.getNo_of_parameters(), connectonId));
	        
			
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

  
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IDatabaseQueryOptions databaseQuery = null;
        	try {
        		
        		//Fetching specific dabaseQuery data based on id
				databaseQuery = exportUtility.query.get(id);
				return ResponseEntity.ok(databaseQuery);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
        	
        	//fetching entire databaseQuery data
             query = exportUtility.query.get();
            return ResponseEntity.ok(query);
        }
    }
	
	@DeleteMapping("/delete")
	
	public void delete(@RequestParam String queryName ) {
		 query = exportUtility.query.get();
		 for(IDatabaseQueryOptions dataquery :query) {
			 if(dataquery.getQueryName().equals(queryName)) {
				 this.queryId = dataquery.getId();
				 try {
					exportUtility.connection.delete(queryId);
				} catch (DataNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
		
	}



}
