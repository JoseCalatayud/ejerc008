package es.santander.ascender.ejerc008.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.model.Provincia;
import es.santander.ascender.ejerc008.repository.ProvinciaRepository;

@Service
@Transactional
public class ProvinciaService {
    @Autowired
    private ProvinciaRepository provinciaRepository;

    public Provincia createProvincia (Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    public Provincia readProvincia (Long id) {
        return provinciaRepository.findById(id).get();
    }

    public List<Provincia> readAllProvincias () {
        return provinciaRepository.findAll();
    }

    public Provincia updateProvincia (Provincia provincia){
        return provinciaRepository.save(provincia);
    }
    
}
