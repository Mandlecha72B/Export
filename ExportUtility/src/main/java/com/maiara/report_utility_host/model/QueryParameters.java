package com.maiara.report_utility_host.model;

public class QueryParameters {
	private int name;
	private int queryParamSequenceNumber;
	private String dataType;
	private String defaultValue;
	private boolean isNullable;
	private long minValue;
	private long maxValue;
	private long maxLength;
	private String parameterRegex;
	private Long datasource_id;
	public Long getDatasource_id() {
		return datasource_id;
	}
	public void setDatasource_id(Long datasource_id) {
		this.datasource_id = datasource_id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
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
	
	

}
