package es.cic.curso25.proyPareja001.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.cic.curso25.proyPareja001.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
