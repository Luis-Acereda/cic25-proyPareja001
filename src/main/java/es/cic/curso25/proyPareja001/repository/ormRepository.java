package es.cic.curso25.proyPareja001.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ormRepository extends JpaRepository<Object, Long> {

}
