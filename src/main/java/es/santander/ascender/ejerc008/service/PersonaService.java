package es.santander.ascender.ejerc008.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService {
    @Autowired
    private PersonaRepository pr;

    public Persona createPersona (Persona persona) {
        return pr.save(persona);
    }
    @Transactional(readOnly = true)
    public Persona readPersona (Long id) {
        return pr.findById(id).get();
    }
    @Transactional(readOnly = true)
    public List<Persona> readAllPersonas () {
        return pr.findAll();
    }

    public Persona updatePersona (Persona persona) {
        return pr.save(persona);
    }

    public void deletePersona (Long id) {
        pr.deleteById(id);
    }


}
