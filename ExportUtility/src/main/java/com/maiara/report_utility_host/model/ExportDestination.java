package com.maiara.report_utility_host.model;

import com.maiara.report_utility.enums.DestinationType;

public class ExportDestination {
	
	private long destinationTypeId ;
	private String name ;
	private String eMails ;
	private String emailSubject ;
	private String emailMessageBody ;
	private String localFolderFilePath ;
	private String ftpServerIp ;
	private String ftpUsername ;
	private String ftpPassword ;
	private int ftpPort ;
	private String description  ;
	private String createdBy ;
	private String updatedBy ;
	private String destination;
	private DestinationType destinationType;
	private String ccAddress;
	private String toAddress;
	public String getCcAddress() {
		return ccAddress;
	}
	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public DestinationType getDestination() {
		return destinationType;
	}
	public void setDestination(String destination) {
		this.destination = destination;
		this.destinationType = DestinationType.valueOf(destination);
	}
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
