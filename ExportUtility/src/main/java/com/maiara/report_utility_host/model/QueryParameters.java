package com.maiara.report_utility_host.model;

import java.util.List;

public class QueryParameters {
	private String name = null;
	private int queryParamSequenceNumber = 0;
	private String dataType = null;
	private String defaultValue = null;
	private boolean isNullable = false;
	private long minValue = 0;
	private long maxValue = 0;
	private long maxLength = 0;
	private String parameterRegex = null;
	private long datasource_id = 0;
	private String updatedBy = null;
	private String createdBy = null;
	private List<Long> parameterValueIds  = null;
	
	
	public List<Long> getParameterValueIds() {
		return parameterValueIds;
	}
	public void setParameterValueIds(List<Long> parameterValueIds) {
		this.parameterValueIds = parameterValueIds;
	}
	public Long getDatasource_id() {
		return datasource_id;
	}
	public void setDatasource_id(long datasource_id ) {
		this.datasource_id = datasource_id;
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
	
	

}
