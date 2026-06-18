package com.example.articulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.articulos.model.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}