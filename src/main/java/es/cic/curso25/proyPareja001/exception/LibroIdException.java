package es.cic.curso25.proyPareja001.exception;

public class LibroIdException extends RuntimeException {

    public LibroIdException(){
        super("Al crear no me puedes pasar id");
    }

    public LibroIdException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public LibroIdException(String message) {
        super(message);
    }

    public LibroIdException(Throwable throwable) {
        super(throwable);
    }
}
