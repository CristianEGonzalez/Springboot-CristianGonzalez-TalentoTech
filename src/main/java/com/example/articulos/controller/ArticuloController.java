package com.example.articulos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.articulos.model.Articulo;
import com.example.articulos.service.ArticuloServiceImpl;

//@CrossOrigin(origins = "*") // Habilitar CORS para React (opcional, dependiendo de tu configuración de frontend)
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloServiceImpl articuloService;

    @Autowired
    public ArticuloController(ArticuloServiceImpl articuloService) {
        this.articuloService = articuloService;
    }

    // GET: Obtener todos
    @GetMapping
    public List<Articulo> listarTodos() {
        return articuloService.obtenerTodos();
    }

    // GET: Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id) {
        Optional<Articulo> articulo = articuloService.obtenerPorId(id);
        return articulo.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Crear artículo
    @PostMapping
    public Articulo crearArticulo(@RequestBody Articulo articulo) {
        return articuloService.guardarArticulo(articulo);
    }

    // PUT: Modificar artículo
    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizarArticulo(@PathVariable Long id, @RequestBody Articulo articulo) {
        if(articuloService.obtenerPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(articuloService.actualizarArticulo(id, articulo));
        }
    }

    // DELETE: Eliminar artículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArticulo(@PathVariable Long id) {
        if (articuloService.obtenerPorId(id).isPresent()) {
            articuloService.eliminarArticulo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}