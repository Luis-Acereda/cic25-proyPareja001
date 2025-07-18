package es.cic.curso25.proyPareja001.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proyPareja001.Exeptions.LibroIDExeption;
import es.cic.curso25.proyPareja001.model.Libro;
import es.cic.curso25.proyPareja001.service.LibroService;

@RestController
@RequestMapping(path = "/libro")
public class LibroController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LibroController.class);

    @Autowired
    LibroService libroService;

    @PostMapping
    public long create(@PathVariable Libro libro) {

        if (libro.getId() != null) {
            throw new LibroIDExeption("Al crear no me puedes pasar id");
        }
        this.libroService = null;

        return libroService.create(libro);
    }

    @PutMapping()
    public void update(@PathVariable Libro libro) {
        if (libro.getId() != null) {
            throw new LibroIDExeption("Al crear no me puedes pasar id");
        }
        libroService.update(libro);
    }

    @DeleteMapping("/{id}")
    public void deleteLibroById(@PathVariable long id) {
        libroService.delete(Long.valueOf(id));
    }

    @GetMapping()
    public List<Libro> getAll() {
        return libroService.getAll();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable long id) {
        return libroService.getById(Long.valueOf(id));
    }

}
