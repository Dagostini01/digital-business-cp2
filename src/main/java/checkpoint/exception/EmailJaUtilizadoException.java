package checkpoint.exception;

public class EmailJaUtilizadoException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmailJaUtilizadoException(String message) {
        super(message);
    }
    
    public EmailJaUtilizadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
