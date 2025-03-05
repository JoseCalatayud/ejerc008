package es.santander.ascender.ejerc008.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc008.model.Provincia;
import es.santander.ascender.ejerc008.service.ProvinciaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {
    @Autowired
    private ProvinciaService provinciaService;

    @PostMapping
    public ResponseEntity<Provincia> create(@RequestBody Provincia provincia) {
        Provincia createdProvincia = provinciaService.createProvincia(provincia);
        return ResponseEntity.ok(createdProvincia);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Provincia> read(Long id) {
        Provincia provincia = provinciaService.readProvincia(id);
        return ResponseEntity.ok(provincia);
    }
    @GetMapping
    public ResponseEntity<List<Provincia>> readAll() {
        List<Provincia> provincias = provinciaService.readAllProvincias();
        return ResponseEntity.ok(provincias);
    }
    @PutMapping
    public ResponseEntity<Provincia> update(@RequestBody Provincia provincia) {
        Provincia updatedProvincia = provinciaService.updateProvincia(provincia);
        return ResponseEntity.ok(updatedProvincia);
    }


    
    


}
