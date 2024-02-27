package com.maiara.report_utility_host.model;

import java.util.List;

public class QueryParameters {
	private String name ;
	private int queryParamSequenceNumber ;
	private String dataType ;
	private String defaultValue ;
	private boolean isNullable ;
	private long minValue ;
	private long maxValue ;
	private long maxLength ;
	private String parameterRegex ;
	private long dabaseQueryId ;
	private String databaseQueryName;
	public long getDabaseQueryId() {
		return dabaseQueryId;
	}
	public void setDabaseQueryId(long dabaseQueryId) {
		this.dabaseQueryId = dabaseQueryId;
	}
	public String getDatabaseQuery() {
		return databaseQuery;
	}
	public void setDatabaseQuery(String databaseQuery) {
		this.databaseQuery = databaseQuery;
	}
	private String databaseQuery;
	private String updatedBy ;
	private String createdBy ;
	private List<Long> parameterValueIds ;
	
	
	public List<Long> getParameterValueIds() {
		return parameterValueIds;
	}
	public void setParameterValueIds(List<Long> parameterValueIds) {
		this.parameterValueIds = parameterValueIds;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getQueryParamSequenceNumber() {
		return queryParamSequenceNumber;
	}
	public void setQueryParamSequenceNumber(int queryParamSequenceNumber) {
		this.queryParamSequenceNumber = queryParamSequenceNumber;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public boolean isNullable() {
		return isNullable;
	}
	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}
	public long getMinValue() {
		return minValue;
	}
	public void setMinValue(long minValue) {
		this.minValue = minValue;
	}
	public long getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(long maxValue) {
		this.maxValue = maxValue;
	}
	public long getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(long maxLength) {
		this.maxLength = maxLength;
	}
	public String getParameterRegex() {
		return parameterRegex;
	}
	public void setParameterRegex(String parameterRegex) {
		this.parameterRegex = parameterRegex;
	}
	public String getDatabaseQueryName() {
		return databaseQueryName;
	}
	public void setDatabaseQueryName(String databaseQueryName) {
		this.databaseQueryName = databaseQueryName;
	}
	
	

}
