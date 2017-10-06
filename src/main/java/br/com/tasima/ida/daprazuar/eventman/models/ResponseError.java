package br.com.tasima.ida.daprazuar.eventman.models;

public class ResponseError {

	private int errorCode;
	private String errorMessage;

	public ResponseError(int code, String message) {
		errorCode = code;
		errorMessage = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int code) {
		errorCode = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		errorMessage = message;
	}
}
