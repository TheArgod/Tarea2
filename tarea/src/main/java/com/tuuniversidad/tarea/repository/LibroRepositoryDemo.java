package com.tuuniversidad.tarea.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tuuniversidad.tarea.models.Libro;


public class LibroRepositoryDemo implements LibroRepository{

    private List<Libro> libros = new ArrayList<>();
    private int nextId = 1;

    public LibroRepositoryDemo(){
        libros.add(new Libro(1000, "Don Quijote de la mancha", "Miguel de Cervantes","Urbano Manini", 1868));
        libros.add(new Libro(1001, "Cien años de soledad", "Gabriel García Márquez", "Editorial Sudamericana", 1967));
        libros.add(new Libro(1002, "El gran Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", 1925));
    }
    
    @Override
    public Optional<Libro> getLibro(int id) {
        return libros.stream().filter(libro -> libro.getId() == id).findFirst();
    }

    @Override
    public List<Libro> getLibro() {
        System.out.println("Conectado a base de datos ORACLE");
        return libros;
    }

    @Override
    public Libro nuevoLibro(Libro libro) {
        if (libro.getId() == 0) {
            libro.setId(nextId++);
        }
        libros.add(libro);
        return libro;
    }

}
