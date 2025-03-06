package es.santander.ascender.ejerc008.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import es.santander.ascender.ejerc008.model.Provincia;
import es.santander.ascender.ejerc008.service.ProvinciaService;


@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {
    @Autowired
    private ProvinciaService provinciaService;

    @PostMapping
    public ResponseEntity<Provincia> create(@RequestBody Provincia provincia) {
        Provincia createdProvincia = provinciaService.createProvincia(provincia);
        return new ResponseEntity<>(createdProvincia, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Provincia> read(@PathVariable Long id) {
        Provincia provincia = provinciaService.readProvincia(id);
        return new ResponseEntity<>(provincia, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Provincia>> readAll() {
        List<Provincia> provincias = provinciaService.readAllProvincias();
        return new ResponseEntity<>(provincias, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Provincia> update(@RequestBody Provincia provincia) {
        Provincia updatedProvincia = provinciaService.updateProvincia(provincia);
        return new ResponseEntity<>(updatedProvincia, HttpStatus.OK);
    }


    
    


}
