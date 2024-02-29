package com.maiara.report_utility_host.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.maiara.report_utility.host.service.params.IDatabaseSourceOptions;
import com.maiara.report_utility_host.model.Connection;

@RestController
@RequestMapping("/connect")
@CrossOrigin(origins = "http://localhost:4200")
public class ConnectionController {

	@Autowired
	ExportUtility exportUtility = new ExportUtility();
	long sourceId ;
	String sourceName;
	long connectionId;
	List<IDatabaseConnectionOptions> connections;
  
	@PostMapping("/add")
	public void add(@RequestBody Connection connection) {
		
		
		
		try {
			 sourceName = connection.getDataSourceName();
			System.out.println(sourceName);
			
			//Mapping datasource-name with datasource-id in dataSource table
			List<IDatabaseSourceOptions> datasources = exportUtility.databaseSource.get();
			for(IDatabaseSourceOptions dataSource: datasources) {
				System.out.println(dataSource.getName());
				System.out.println(dataSource.getId());
				if(dataSource.getName().equals(sourceName)) {
					sourceId = dataSource.getId();
					System.out.println(sourceId + "Source ");
				}
				
			}
			
			
			//Adding connection

			exportUtility.connection.add(new DatabaseConnectionOptions(connection.getConnectionName(), connection.getServer(), connection.getPort(), connection.getUsername(), connection.getPassword(), connection.getDatabase_name(), sourceId));
			
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}

	}

   
	
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IDatabaseConnectionOptions connection = null;
        	try {
        		
        		//fetching specific connection data based on id 
        		
				connection = exportUtility.connection.get(id);
				return ResponseEntity.ok(connection);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
        	
        	//fetching entire connection data
        	
            connections = exportUtility.connection.get();
            return ResponseEntity.ok(connections);
        }
    }
	
	@DeleteMapping("/delete")
		
	public void delete(@RequestParam String connectionName ) {
		 connections = exportUtility.connection.get();
		 for(IDatabaseConnectionOptions connection :connections) {
			 if(connection.getConnectionName().equals(connectionName)) {
				 this.connectionId = connection.getId();
				 try {
					exportUtility.connection.delete(connectionId);
				} catch (DataNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
		
	}

}
