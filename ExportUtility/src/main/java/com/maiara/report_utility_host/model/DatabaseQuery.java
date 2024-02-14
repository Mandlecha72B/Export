package com.maiara.report_utility_host.model;

public class DatabaseQuery {
	
	private String name;
	private String query_text;
	private int no_of_parameters;
	private Long connectionId;
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
