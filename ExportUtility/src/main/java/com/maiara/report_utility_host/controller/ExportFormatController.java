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

import com.maiara.report_utility.host.service.params.IExportFormatOptions;

@RestController
@RequestMapping("/exportFormat")
public class ExportFormatController {
	
	@Autowired
	ExportUtility exportUtility = new ExportUtility();
	
  
	@GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(required = false) Long id) {
        if (id != null) {
        	IExportFormatOptions exportFormat = null;
        	try {
				exportFormat = exportUtility.exportFormat.get(id);
				return ResponseEntity.ok(exportFormat);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}

        } else {
            List<IExportFormatOptions> exportFormat = exportUtility.exportFormat.get();
            return ResponseEntity.ok(exportFormat);
        }
    }


}
