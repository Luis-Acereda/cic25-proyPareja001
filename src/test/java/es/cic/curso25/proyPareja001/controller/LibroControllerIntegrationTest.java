package es.cic.curso25.proyPareja001.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso25.proyPareja001.model.Libro;

@SpringBootTest
@AutoConfigureMockMvc
public class LibroControllerIntegrationTest {

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
                .andDo(print())
                .andExpect(result -> {
                    long value = Long.parseLong(result.getResponse().getContentAsString());
                    assertTrue(value > 0, "El valor debe ser mayor a 0");
                });

    }

    @Test
    void testDeleteLibroById() throws Exception {
        Libro libro = new Libro();
        libro.setTitulo("La Vida");
        libro.setAutor("Miguel de Cervantes");
        libro.setFechaPublicacion(null);

        String libroJson = objectMapper.writeValueAsString(libro);

        mockMvc.perform(post("/libro")
                .contentType("application/json")
                .content(libroJson))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(result -> {
                    long value = Long.parseLong(result.getResponse().getContentAsString());
                    assertTrue(value > 0, "El valor debe ser mayor a 0");
                });

        mockMvc.perform(delete("/libro/1")
                .contentType("application/json")
                .content(libroJson))
                .andExpect(status().isOk())
                .andDo(print());

        mockMvc.perform(get("/libro/1")
                .contentType("application/json")
                .content(libroJson))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(result -> {

                    String JsonLibro = result.getResponse().getContentAsString();
                    assertTrue(JsonLibro.isBlank());

                }).andDo(print());

    }

    @Test
    void testGetLibroById() throws Exception {

        Libro libro = new Libro();
        libro.setTitulo("La Vida");
        libro.setAutor("Miguel de Cervantes");
        libro.setFechaPublicacion(null);

        String libroJson = objectMapper.writeValueAsString(libro);

        MvcResult resultPost = mockMvc.perform(post("/libro")
                .contentType("application/json")
                .content(libroJson))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        long value = Long.parseLong(resultPost.getResponse().getContentAsString());
        mockMvc.perform(get("/libro/" + value))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(result -> {

                    String resulGetById = result.getResponse().getContentAsString();

                    Libro reLibros = objectMapper.readValue(resulGetById, Libro.class);
                    assertTrue(reLibros.getId() != null && reLibros.getId() != 0);

                }).andDo(print());
    }

    @Test
    void testGetAll() throws Exception {

        Libro libro = new Libro();
        libro.setTitulo("La Vida");
        libro.setAutor("Miguel de Cervantes");
        libro.setFechaPublicacion(null);

        String libroJson = objectMapper.writeValueAsString(libro);

        mockMvc.perform(post("/libro")
                .contentType("application/json")
                .content(libroJson))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(result -> {
                    long value = Long.parseLong(result.getResponse().getContentAsString());
                    assertTrue(value > 0, "El valor debe ser mayor a 0");
                });

        mockMvc.perform(get("/libro"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    String librosjson = result.getResponse().getContentAsString();
                    List<Libro> GetLibros = objectMapper.readValue(librosjson, new TypeReference<List<Libro>>() {
                    });
                    assertTrue(librosjson != null && !librosjson.isEmpty());
                    assertTrue(GetLibros.getFirst().getAutor() != null);
                });
    }

    @Test
    void testUpdate() throws Exception {
        // TODO Fix Dates Formats bugs
        Libro libro = new Libro();
        libro.setTitulo("La Vida");
        libro.setAutor("Miguel de Cervantes");
        libro.setFechaPublicacion(null);

        String libroJson = objectMapper.writeValueAsString(libro);

        MvcResult resultPost = mockMvc.perform(post("/libro")
                .contentType("application/json")
                .content(libroJson))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        long value = Long.parseLong(resultPost.getResponse().getContentAsString());

        MvcResult mvcResult = mockMvc.perform(get("/libro/" + value))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        libro = objectMapper.readValue(json, Libro.class);

        libro.setFechaPublicacion(LocalDate.of(1612, 12, 20));
        libroJson = objectMapper.writeValueAsString(libro);

        mockMvc.perform(put("/libro")
                .contentType("application/json")
                .content(libroJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/libro/"+value))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(result -> {
                    String JsonLibro = result.getResponse().getContentAsString();

                    Libro LibroUpadte = objectMapper.readValue(JsonLibro, Libro.class);
                    assertEquals(LocalDate.of(1612, 12, 19), LibroUpadte.getFechaPublicacion());

                }).andDo(print());
    }
}
