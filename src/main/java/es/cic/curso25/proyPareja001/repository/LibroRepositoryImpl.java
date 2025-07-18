package es.cic.curso25.proyPareja001.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import es.cic.curso25.proyPareja001.model.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LibroRepositoryImpl {

    @PersistenceContext
    private EntityManager em;

    private Map<Long, Libro> libros = new HashMap<>();

    public long create(Libro libro) {
        em.persist(libro);
        return libro.getId();
    }
}
