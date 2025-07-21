package es.cic.curso25.proyPareja001.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.cic.curso25.proyPareja001.exception.LibroIdException;

@RestControllerAdvice
public class LibroControllerAdvice {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(exception = {LibroIdException.class})
    public void controloModificacion(){
        
    }
}
