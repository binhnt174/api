package com.java.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class BusinessException.
 */
@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
public class BusinessException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** The resource name. */
	private String resourceName;

	/** The field name. */
	private String fieldName;

	/**
	 * Instantiates a new business exception.
	 *
	 * @param resourceName the resource name
	 * @param fieldName    the field name
	 * @param fieldValue   the field value
	 */
	public BusinessException(String resourceName, String fieldName) {
		super(String.format("Work %s input %s incorrect.", resourceName, fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
	}

	/**
	 * Gets the the resource name.
	 *
	 * @return the the resource name
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * Sets the the resource name.
	 *
	 * @param resourceName the new the resource name
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * Gets the the field name.
	 *
	 * @return the the field name
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Sets the the field name.
	 *
	 * @param fieldName the new the field name
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
