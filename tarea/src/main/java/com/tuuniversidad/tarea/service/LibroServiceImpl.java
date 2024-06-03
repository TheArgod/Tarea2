package com.tuuniversidad.tarea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuuniversidad.tarea.models.Libro;
import com.tuuniversidad.tarea.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    private LibroRepository libroRepository;
    
    @Override
    public Optional<Libro> getLibro(int id) {
        return libroRepository.getLibro(id);
    }

    @Override
    public List<Libro> getLibro() {
        return libroRepository.getLibro();
    }

    @Override
    public Libro nuevoLibro(Libro libro) {
        return libroRepository.nuevoLibro(libro);
    }

}
