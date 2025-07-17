package es.cic.curso25.proyPareja001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso25.proyPareja001.repository.OrmRepository;

@Service
public class OrmService {

    @Autowired
    OrmRepository ormRepository;

}
