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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proyPareja001.exception.LibroIdException;
import es.cic.curso25.proyPareja001.model.Libro;
import es.cic.curso25.proyPareja001.service.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    LibroService libroService;

    @PostMapping
    public Long create(@RequestBody Libro libro) {
        if (libro.getId() != null) {
            throw new LibroIdException("Al crear no me puedes pasar id");
        }

        return libroService.create(libro);
    }

    @GetMapping()
    public List<Libro> getAll() {
        return libroService.getAll();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable long id) {
        return libroService.getById(Long.valueOf(id));
    }

    @PutMapping()
    public void update(@RequestBody Libro libro) {
        libroService.update(libro);
    }

    @DeleteMapping("/{id}")
    public void deleteLibroById(@PathVariable long id) {
        libroService.delete(Long.valueOf(id));
    }
}
