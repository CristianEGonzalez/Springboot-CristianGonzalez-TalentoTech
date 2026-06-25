package com.example.articulos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.articulos.model.Articulo;
import com.example.articulos.repository.ArticuloRepository;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    //Consultar todos los artículos
    @Override
    public List<Articulo> obtenerTodos() {
        return articuloRepository.findAll();
    }

    //Consultar artículo específico por ID
    @Override
    public Optional<Articulo> obtenerPorId(Long id) {
        return articuloRepository.findById(id);
    }

    //Crear articulo
    @Override
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    //Actualizar articulo
    @Override
    public Articulo actualizarArticulo(Long id, Articulo articulo){
        articulo.setId(id);
        return articuloRepository.save(articulo);
    }

    //Borrar articulo
    @Override
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }
}