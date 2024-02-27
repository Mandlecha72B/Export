package com.maiara.report_utility_host.model;

import java.util.List;

public class DatabaseQuery {
	
	private long id;
	private String queryName;
	private String query_text;
	private int no_of_parameters;
	private long connectionId;
	private String createdBy;
	private String updatedBy;
	private String connectionName;

	

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

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

}
