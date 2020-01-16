package com.beingjavaguys.model;

/**
 * 
 *
 */
public class Status {

	private int code;
	private String message;

	/**
	 * 
	 */
	public Status() {
	}

	/**
	 * @param code
	 * @param message
	 */
	public Status(final int code, final String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(final int code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Status [code=" + code + ", message=" + message + "]";
	}

}
