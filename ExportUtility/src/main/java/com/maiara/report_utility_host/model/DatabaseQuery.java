package com.maiara.report_utility_host.model;

import java.util.List;

public class DatabaseQuery {
	
	private String queryName = null;
	private String query_text = null;
	private int no_of_parameters = 0;
	private long connectionId = 0;
	private long id = 0;
	private String createdBy = null;
	private String updatedBy = null;
	List<Long> parameterValueId;
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
	public List<Long> getParameterValueId() {
		return parameterValueId;
	}
	public void setParameterValueId(List<Long> parameterValueId) {
		this.parameterValueId = parameterValueId;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(long connectionId) {
		this.connectionId = connectionId;
	}
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public String getQuery_text() {
		return query_text;
	}
	public void setQuery_text(String query_text) {
		this.query_text = query_text;
	}
	public int getNo_of_parameters() {
		return no_of_parameters;
	}
	public void setNo_of_parameters(int no_of_parameters) {
		this.no_of_parameters = no_of_parameters;
	}
	

}
