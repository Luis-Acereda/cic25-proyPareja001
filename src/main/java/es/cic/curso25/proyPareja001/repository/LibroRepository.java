package es.cic.curso25.proyPareja001.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cic.curso25.proyPareja001.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
