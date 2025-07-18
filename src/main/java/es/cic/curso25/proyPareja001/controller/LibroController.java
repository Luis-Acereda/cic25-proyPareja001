package es.cic.curso25.proyPareja001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proyPareja001.service.LibroService;

@RestController
@RequestMapping("")
public class LibroController {

    @Autowired
    LibroService libroService;

}
