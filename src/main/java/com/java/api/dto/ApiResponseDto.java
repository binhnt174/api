package com.java.api.dto;

/**
 * The Class ApiResponseDto.
 */
public class ApiResponseDto {
	
	/** The status. */
	private String status;
	
	/** The message. */
	private String message;

	/**
	 * Instantiates a new api response dto.
	 */
	public ApiResponseDto() {}

	/**
	 * Instantiates a new api response dto.
	 *
	 * @param status  the status
	 * @param message the message
	 */
	public ApiResponseDto(String status, String message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "APIResponse [status=" + status + ", message=" + message + "]";
	}

}
