package com.d3stroya.restdatajpa2.controller;

import com.d3stroya.restdatajpa2.entities.Laptop;
import com.d3stroya.restdatajpa2.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    // Añadir repositorio
    // ATRIBUTO
    private LaptopRepository laptopRepository;

    // CONSTRUCTOR
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // CRUD
    // Buscar todos
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    // Buscar un laptop por id
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if(laptopOpt.isPresent()) {
            return ResponseEntity.ok(laptopOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear laptop
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        if(laptop.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    // Actualizar
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(Laptop laptop) {
        if(!laptopRepository.existsById(laptop.getId())) {
            return ResponseEntity.notFound().build();
        }
        if(laptop.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    // Borrar por id
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> deleteById(@PathVariable Long id) {
        if(!laptopRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Eliminar todos
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll() {
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
