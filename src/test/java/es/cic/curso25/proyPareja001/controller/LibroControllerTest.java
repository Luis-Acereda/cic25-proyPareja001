package es.cic.curso25.proyPareja001.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso25.proyPareja001.model.Libro;

@SpringBootTest
@AutoConfigureMockMvc
public class LibroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreate() throws Exception {

        Libro libro = new Libro();
        libro.setTitulo("La Vida");
        libro.setAutor("Miguel de Cervantes");
        libro.setFechaPublicacion(null);

        String libroJson = objectMapper.writeValueAsString(libro);

        mockMvc.perform(post("/libro")
                .contentType("application/json")
                .content(libroJson))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    long value = Long.parseLong(result.getResponse().getContentAsString());
                    assertTrue(value > 0, "El valor debe ser mayor a 0");
                });

    }

    @Test
    void testDeleteLibroById() throws Exception {

        // Libro libro = new Libro();
        // libro.setTitulo("La Vida");
        // libro.setAutor("Miguel de Cervantes");
        // libro.setFechaPublicacion(null);

        // String libroJson = objectMapper.writeValueAsString(libro);

        // mockMvc.perform(post("/habito")
        //         .contentType("application/json")
        //         .content(libroJson))
        //         .andExpect(status().isOk());

        // mockMvc.perform(get("/habito/1"))
        //         .andExpect(status().isOk());
    }

    @Test
    void testGetAll() {

    }

    @Test
    void testGetLibroById() {

    }

    @Test
    void testUpdate() {

    }
}
