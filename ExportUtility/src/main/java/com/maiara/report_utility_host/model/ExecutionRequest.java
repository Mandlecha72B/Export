package com.maiara.report_utility_host.model;

import java.util.ArrayList;
import java.util.List;

import com.maiara.report_utility.enums.FormatType;

public class ExecutionRequest {
	
	long queryId;
	long formatId;
	long destinationId;
	private String filename;
	private String destination;
    private String queryName;
 
    private String formatType;
    private FormatType format;
    private String createdBy;
    private String updatedBy;
    public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public FormatType getFormatType() {
		return this.format;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
		this.format = FormatType.valueOf(formatType);
	}

	

	

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	

	

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public long getQueryId() {
		return queryId;
	}

	public void setQueryId(long queryId) {
		this.queryId = queryId;
	}

	public long getFormatId() {
		return formatId;
	}

	public void setFormatId(long formatId) {
		this.formatId = formatId;
	}

	public long getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(long destinationId) {
		this.destinationId = destinationId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	

}
