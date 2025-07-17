package es.cic.curso25.proyPareja001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proyPareja001.service.OrmService;

@RestController
@RequestMapping("")
public class OrmController {

    @Autowired
    OrmService ormService;

}
