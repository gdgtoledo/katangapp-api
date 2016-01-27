package es.craftsmanship.toledo.katangapp.business;

/**
 * @author mdelapenya
 */
public class UnreferenceablePointException extends Exception {

	public UnreferenceablePointException() {
	}

	public UnreferenceablePointException(String message) {
		super(message);
	}

	public UnreferenceablePointException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnreferenceablePointException(Throwable cause) {
		super(cause);
	}

}
