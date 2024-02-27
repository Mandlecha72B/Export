package com.maiara.report_utility_host.model;

public class QueryParameterValue {
	
	private String value ;
	private long queryParameterId;
	private String createdBy ;
	private String updatedBy;
	private String queryParameterName;
	public String getQueryParameterName() {
		return queryParameterName;
	}
	public void setQueryParameterName(String queryParamereName) {
		this.queryParameterName = queryParamereName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public long getQueryParameterId() {
		return queryParameterId;
	}
	public void setQueryParameterId(long queryParameterId) {
		this.queryParameterId = queryParameterId;
	}
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
	
	
	

}
