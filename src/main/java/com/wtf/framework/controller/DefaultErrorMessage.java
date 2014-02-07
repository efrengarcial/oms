package com.wtf.framework.controller;

import java.util.ArrayList;
import java.util.List;

public class DefaultErrorMessage {
	private String code;
	private String status;
	@SuppressWarnings("rawtypes")
	private List errors = new ArrayList<>(); 

	@SuppressWarnings("unchecked")
	public DefaultErrorMessage(String code, String status, String error) {
		this.setCode(code);
		this.setStatus(status);
		this.errors.add(error);
	}

	public DefaultErrorMessage(String code, String status, List errors) {
		this.setCode(code);
		this.setStatus(status);
		this.errors = errors;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}