package com.example.articulos.service;

import java.util.List;
import java.util.Optional;

import com.example.articulos.model.Articulo;

public interface ArticuloService {
  List<Articulo> obtenerTodos();
  Optional<Articulo> obtenerPorId(Long id);
  Articulo guardarArticulo(Articulo articulo);
  Articulo actualizarArticulo(Long id, Articulo articulo);
  void eliminarArticulo(Long id);
  
}
