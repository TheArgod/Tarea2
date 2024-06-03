package com.tuuniversidad.tarea.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tuuniversidad.tarea.models.Libro;
import com.tuuniversidad.tarea.service.LibroService;

@RestController
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping("/hola")
    public String Hola(){
        return "Hola Spring Boot";
    }

    @PostMapping("/libro")
    public ResponseEntity<Libro> nuevoLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.nuevoLibro(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

/* 
    @GetMapping("/libros/{id_libro}")
    public Libro getLibro(@PathVariable int id){
        Libro libro = libroService.getLibro(id);
        return libro;
    }
*/

    @GetMapping("/libros/{id_libro}")
    public ResponseEntity<Libro> getLibroById(@PathVariable("id_libro") int idLibro) {
        Optional<Libro> libro = libroService.getLibro(idLibro);
        if (libro.isPresent()) {
            return new ResponseEntity<>(libro.get(), HttpStatus.OK);
        } else {
            throw new LibroException("Libro con ID " + idLibro + " no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.nuevoLibro(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @GetMapping("/libros")
    public List<Libro> getLibros(){
        return libroService.getLibro();
    }

    @ExceptionHandler(LibroException.class)
    public ResponseEntity<String> handleLibroException(LibroException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
