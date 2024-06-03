package com.tuuniversidad.tarea.repository;

import java.util.List;
import java.util.Optional;

import com.tuuniversidad.tarea.models.Libro;

public interface LibroRepository {
    Optional<Libro> getLibro(int id);
    List<Libro> getLibro();
    Libro nuevoLibro(Libro libro);
}
