package com.aprendendoweb.Course.resources.exception;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT" )
	private Instant timestamp;
	private Integer status;
	private String error;
	private String path;

	public StandardError(Instant timestamp, Integer status, String error, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.path = path;
	}

	// Getters e setters
	public Instant getTimestamp() {
		return timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getPath() {
		return path;
	}
}
