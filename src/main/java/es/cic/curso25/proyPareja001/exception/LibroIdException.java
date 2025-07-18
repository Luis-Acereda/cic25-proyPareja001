package es.cic.curso25.proyPareja001.exception;

public class LibroIdException extends RuntimeException {

    public LibroIdException(String message, Throwable exeption) {
        super(message, exeption);
    }

    public LibroIdException(String message) {
        super(message);
    }

    public LibroIdException(Throwable exeption) {
        super(exeption);
    }
}
