package br.com.tasima.ida.daprazuar.eventman.exceptions.business;

public class NameTooLongException extends Exception {

	private static final long serialVersionUID = 7994090060547239999L;

	public NameTooLongException(String message) {
		super(message);
	}
}
