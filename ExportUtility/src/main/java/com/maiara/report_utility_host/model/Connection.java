package com.maiara.report_utility_host.model;

public class Connection {
	private String server;
	private String username;
	private String password;
	private String database_name;
	private String name;
	private long source_id;
	private int port;
	private Long id;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public long getSource_id() {
		return source_id;
	}

	public void setSource_id(long source_id) {
		this.source_id = source_id;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	

	public String getDatabase_name() {
		return database_name;
	}

	public void setDatabase_name(String database_name) {
		this.database_name = database_name;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
