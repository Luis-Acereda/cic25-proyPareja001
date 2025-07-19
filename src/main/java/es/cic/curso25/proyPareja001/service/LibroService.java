package es.cic.curso25.proyPareja001.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso25.proyPareja001.model.Libro;
import es.cic.curso25.proyPareja001.repository.LibroRepository;

@Service
public class LibroService {

    private final static Logger LOGGER = LoggerFactory.getLogger(LibroService.class);

    @Autowired
    LibroRepository libroRepository;

    public Long create(Libro libro) {
        libroRepository.save(libro);
        return libro.getId();
    }

    public Libro getById(Long id) {
        LOGGER.info("Get Libro with id " + id);
        Optional<Libro> resultado = libroRepository.findById(id);
        return resultado.orElse(null);
    }

    public List<Libro> getAll() {
        return libroRepository.findAll();
    }

    public void update(Libro Libro) {
        libroRepository.save(Libro);
      
    }

    public void delete(Long id) {
        libroRepository.deleteById(id);
    }

}
