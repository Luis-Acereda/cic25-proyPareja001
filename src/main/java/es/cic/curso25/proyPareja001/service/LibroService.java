package es.cic.curso25.proyPareja001.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso25.proyPareja001.model.Libro;
import es.cic.curso25.proyPareja001.repository.LibroRepository;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;

    public long create(Libro libro) {
        libroRepository.save(libro);
        return libro.getId();
    }

    public Libro getById(long id) {
        Optional<Libro> resultado = libroRepository.findById(id);
        return resultado.orElse(null);
    }

    public List<Libro> getAll() {
        return libroRepository.findAll();
    }

    public void update(Libro Libro) {
        Libro tmp = Libro;
        this.delete(Libro.getId());
        libroRepository.save(tmp);
    }

    public void delete(long id) {
        libroRepository.deleteById(id);
    }

}
