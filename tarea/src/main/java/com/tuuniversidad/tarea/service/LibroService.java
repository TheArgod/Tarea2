package com.tuuniversidad.tarea.service;

import java.util.List;
import java.util.Optional;

import com.tuuniversidad.tarea.models.Libro;


public interface LibroService {
    Optional<Libro> getLibro(int id);
    List<Libro> getLibro();
    Libro nuevoLibro(Libro libro);
}
