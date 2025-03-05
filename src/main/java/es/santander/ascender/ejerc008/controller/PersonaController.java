package es.santander.ascender.ejerc008.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<Persona> create(@RequestBody Persona persona) {
        Persona createdPersona = personaService.createPersona(persona);
        return new ResponseEntity<>(createdPersona, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> read(@PathVariable Long id) {
        Persona persona = personaService.readPersona(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Persona>> readAll() {
        List<Persona> personas = personaService.readAllPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PutMapping 
    public ResponseEntity<Persona> update(@RequestBody Persona persona) {
        Persona updatedPersona = personaService.updatePersona(persona);
        return new ResponseEntity<>(updatedPersona, HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personaService.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
