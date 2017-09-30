package br.com.tasima.ida.daprazuar.eventman.exceptions.business;

public class PastDateException extends Exception {
	
	private static final long serialVersionUID = 7994090060547239999L;

	public PastDateException(String message) {
		super(message);
	}
}
