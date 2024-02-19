package com.maiara.report_utility_host.model;

public class ExportDestination {
	
	private long destinationTypeId = 0;
	private String name = null;
	private String eMails = null;
	private String emailSubject = null;
	private String emailMessageBody = null;
	private String localFolderFilePath = null;
	private String ftpServerIp = null;
	private String ftpUsername = null;
	private String ftpPassword = null;
	private int ftpPort = 0;
	private String description  = null;
	private String createdBy = null;
	private String updatedBy = null;
	public long getDestinationTypeId() {
		return destinationTypeId;
	}
	public void setDestinationTypeId(long destinationTypeId) {
		this.destinationTypeId = destinationTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteMails() {
		return eMails;
	}
	public void seteMails(String eMails) {
		this.eMails = eMails;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailMessageBody() {
		return emailMessageBody;
	}
	public void setEmailMessageBody(String emailMessageBody) {
		this.emailMessageBody = emailMessageBody;
	}
	public String getLocalFolderFilePath() {
		return localFolderFilePath;
	}
	public void setLocalFolderFilePath(String localFolderFilePath) {
		this.localFolderFilePath = localFolderFilePath;
	}
	public String getFtpServerIp() {
		return ftpServerIp;
	}
	public void setFtpServerIp(String ftpServerIp) {
		this.ftpServerIp = ftpServerIp;
	}
	public String getFtpUsername() {
		return ftpUsername;
	}
	public void setFtpUsername(String ftpUsername) {
		this.ftpUsername = ftpUsername;
	}
	public String getFtpPassword() {
		return ftpPassword;
	}
	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}
	public int getFtpPort() {
		return ftpPort;
	}
	public void setFtpPort(int ftpPort) {
		this.ftpPort = ftpPort;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
