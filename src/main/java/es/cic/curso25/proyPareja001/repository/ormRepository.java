package es.cic.curso25.proyPareja001.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.cic.curso25.proyPareja001.ORM.Orm;

@Repository
public interface OrmRepository extends JpaRepository<Orm, Long> {

}
