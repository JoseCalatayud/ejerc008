package es.santander.ascender.ejerc008.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.model.Provincia;
import es.santander.ascender.ejerc008.repository.PersonaRepository;
import es.santander.ascender.ejerc008.repository.ProvinciaRepository;

@Service
@Transactional
public class PersonaService {
    @Autowired
    private PersonaRepository pr;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public Persona createPersona(Persona persona) {
        if (personaVieneConProvincia(persona)) {
            Provincia provinciaExistente = provinciaRepository.findById(persona.getProvincia().getId()).orElse(null);
            persona.setProvincia(provinciaExistente);
        }else {
            persona.setProvincia(null);
        }
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
        if (personaVieneConProvincia(persona)) {
            Provincia provinciaExistente = provinciaRepository.findById(persona.getProvincia().getId()).orElse(null);
            persona.setProvincia(provinciaExistente);
        }else {
            persona.setProvincia(null);
        }
        return pr.save(persona);
    }
    
    public void deletePersona (Long id) {
        pr.deleteById(id);
    }
    
    private boolean personaVieneConProvincia(Persona persona) {
        return persona.getProvincia() != null && persona.getProvincia().getId() != null;
    }

}
