package es.cic.curso25.proyPareja001.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proyPareja001.model.Libro;
import es.cic.curso25.proyPareja001.service.LibroService;

@RestController
@RequestMapping("libro")
public class LibroController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LibroController.class);

    @Autowired
    LibroService libroService;

    @PostMapping
    public long create(Libro libro){
        if (libro.getId() != null) {
            throw new RuntimeException("Al crear no me puedes pasar id");
        }
        this.libroService = null;

        return libroService.create(libro);
    }
}
