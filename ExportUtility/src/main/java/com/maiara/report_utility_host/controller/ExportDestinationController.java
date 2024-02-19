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
import com.maiara.report_utility.host.service.params.ExportDestinationOptions;
import com.maiara.report_utility.host.service.params.IExportDestinationOptions;

import com.maiara.report_utility_host.model.ExportDestination;


@RestController
@RequestMapping("/exportDestination")

public class ExportDestinationController {
	@Autowired
	ExportUtility exportUtility = new ExportUtility();
	
  
	@PostMapping("/add")
	public void add(@RequestBody ExportDestination exportDestination) {
		
		try {
			exportUtility.exportDestination.add(new ExportDestinationOptions(exportDestination.getDestinationTypeId(), exportDestination.getName(), exportDestination.geteMails(), exportDestination.getEmailSubject(), exportDestination.getEmailMessageBody(), exportDestination.getLocalFolderFilePath(), exportDestination.getFtpServerIp(), exportDestination.getFtpUsername(), exportDestination.getFtpPassword(), exportDestination.getFtpPort(), exportDestination.getDescription(), true, exportDestination.getCreatedBy(), exportDestination.getUpdatedBy()));
		
			
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
   
	
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IExportDestinationOptions exportDestination = null;
        	try {
				exportDestination = exportUtility.exportDestination.get(id);
				return ResponseEntity.ok(exportDestination);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
            List<IExportDestinationOptions> exportDestination = exportUtility.exportDestination.get();
            return ResponseEntity.ok(exportDestination);
        }
    }
	

}
