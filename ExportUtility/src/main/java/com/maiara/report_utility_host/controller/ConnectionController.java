package com.maiara.report_utility_host.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiara.report_utility.errors.DataNotFoundException;
import com.maiara.report_utility.host.service.ExportUtility;
import com.maiara.report_utility.host.service.params.DatabaseConnectionParameters;
import com.maiara.report_utility.host.service.params.IDatabaseConnection;
import com.maiara.report_utility_host.model.Connection;

@RestController
@RequestMapping("/connect")
public class ConnectionController {

	@Autowired
	ExportUtility export;

	@PostMapping("/add")
	public void add(@RequestBody Connection obj) {

		IDatabaseConnection connectionParameters = new DatabaseConnectionParameters();

		String server = obj.getServer();
		String name = obj.getName();
		String username = obj.getUsername();
		String password = obj.getPassword();
		String database_name = obj.getDatabase_name();
		long source_id = obj.getSource_id();

		int port = obj.getPort();

		connectionParameters.setServerIp(server);
		connectionParameters.setDatabaseName(database_name);
		connectionParameters.setUsername(username);
		connectionParameters.setPassword(password);
		connectionParameters.setDatasourceId(source_id);
		connectionParameters.setConnectionName(name);

		try {
			export.connection.add(connectionParameters);
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}

	}

//	@GetMapping("/get")
//	public ResponseEntity<List<IDatabaseConnection>> get() {
////		List<DatabaseConnectionParameters> list = export.connection.get();
//		List<IDatabaseConnection> list = export.connection.get();
//		for (IDatabaseConnection i : list) {
//			System.out.println(i);
//
//		}
//		return ResponseEntity.ok(list);
//	}
//
//	@GetMapping("/get/{id}")
//	public ResponseEntity<IDatabaseConnection> get(@PathVariable long id) {
//
//		IDatabaseConnection obj = null;
//
//		try {
//			obj = export.connection.get(id);
//		} catch (DataNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return ResponseEntity.ok(obj);
//
//	}

	@PutMapping("update/{id}")
	public ResponseEntity<IDatabaseConnection> update(@PathVariable long id, @RequestBody Connection obj) {
		IDatabaseConnection connectionParameters = new DatabaseConnectionParameters(); // Instantiate
																						// IDatabaseConnection
		String server = obj.getServer();
		String name = obj.getName();
		String username = obj.getUsername();
		String password = obj.getPassword();
		String database_name = obj.getDatabase_name();
		long source_id = obj.getSource_id();
		int port = obj.getPort();

		// Set properties of connectionParameters using obj fields...

		try {
			IDatabaseConnection updatedConnection = export.connection.update(connectionParameters); // Assuming you have
			return ResponseEntity.ok(updatedConnection);

		} catch (DataNotFoundException e) {
			e.printStackTrace();
            return ResponseEntity.notFound().build();
		}

	}
	
	@GetMapping("/get")
    public ResponseEntity<?> getConnection(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IDatabaseConnection obj = null;
        	try {
				obj = export.connection.get(id);
				return ResponseEntity.ok(obj);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}
//            if (obj != null) {
//                return ResponseEntity.ok(obj);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
        } else {
            List<IDatabaseConnection> connections = export.connection.get();
            return ResponseEntity.ok(connections);
        }
    }

}
