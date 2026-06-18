package com.example.articulos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.articulos.model.Articulo;
import com.example.articulos.repository.ArticuloRepository;

@Service
public class ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    //Consultar todos los artículos
    public List<Articulo> obtenerTodos() {
        return articuloRepository.findAll();
    }

    //Consultar artículo específico por ID
    public Optional<Articulo> obtenerPorId(Long id) {
        return articuloRepository.findById(id);
    }

    //Crear articulo
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    //Borrar articulo
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }
}