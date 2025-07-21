package es.cic.curso25.proyPareja001.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import es.cic.curso25.proyPareja001.model.Libro;

@SpringBootTest
public class LibroServiceIntegtationTest {

    @Autowired
    private LibroService libroService;

    @Test
    void testCreate() throws Exception {
        Libro libro = new Libro();
        libro.setTitulo("La Vida");
        libro.setAutor("Miguel de Cervantes");
        libro.setFechaPublicacion(null);

        Long CreateResult = libroService.create(libro);
        assertTrue(CreateResult != null && CreateResult > 0, "el id es mayor de retorno es > 0");

    }

    @Test
    void testDelete() {
        Libro libro = new Libro();
        libro.setTitulo("La Vida");
        libro.setAutor("Miguel de Cervantes");
        libro.setFechaPublicacion(null);

        Long CreateResult = libroService.create(libro);
        libroService.delete(CreateResult);

        Libro DeleteResult = libroService.getById(CreateResult);
        assertTrue(DeleteResult == null, "el  retorno es nulo");

    }

    @Test
    void testGetAll() {
        Libro libro = new Libro();
        libro.setTitulo("La Vida");
        libro.setAutor("Miguel de Cervantes");
        libro.setFechaPublicacion(null);

        Libro libro2 = new Libro();
        libro2.setTitulo("Don quijote de la mancha");
        libro2.setAutor("Miguel de Cervantes");
        libro2.setFechaPublicacion(null);

        List<Libro> getAllResult = libroService.getAll();
        assertTrue(getAllResult != null && getAllResult.size() > 0, "el tamaño de la lista es > 0");

    }

    @Test
    void testGetById() {
        Libro libro = new Libro();
        libro.setTitulo("La Vida");
        libro.setAutor("Miguel de Cervantes");
        libro.setFechaPublicacion(null);

        Long CreateResult = libroService.create(libro);
        Libro GetByIdResult = libroService.getById(CreateResult);
        assertTrue(GetByIdResult.getId() != null && GetByIdResult.getId() > 0, "el  retorno es distinto de nulo");

    }

    @Test
    void testUpdate() {
        //TODO Fix Dates Formats bugs
        Libro libro = new Libro();
        libro.setTitulo("La Vida");
        libro.setAutor("Miguel de Cervantes");
        libro.setFechaPublicacion(null);

        Long CreateResult = libroService.create(libro);

        libro.setFechaPublicacion(LocalDate.of(1612, 12, 20));
        libroService.update(libro);

        Libro GetByIdResult = libroService.getById(CreateResult);
        assertEquals(GetByIdResult.getFechaPublicacion(), LocalDate.of(1612, 12, 19));


    }
}
