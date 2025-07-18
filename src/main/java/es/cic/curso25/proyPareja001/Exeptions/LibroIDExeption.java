package es.cic.curso25.proyPareja001.Exeptions;

public class LibroIDExeption extends RuntimeException {

    public LibroIDExeption(String message, Throwable exeption) {
        super(message, exeption);
    }

    public LibroIDExeption(String message) {
        super(message);
    }

    public LibroIDExeption(Throwable exeption) {
        super(exeption);
    }
}
