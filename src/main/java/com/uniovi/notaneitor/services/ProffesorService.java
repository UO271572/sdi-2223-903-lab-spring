package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Proffesor;
import com.uniovi.notaneitor.repositories.ProffesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProffesorService {

    @Autowired
    private ProffesorRepository proffesorRepository;

    @PostConstruct
    public void init(){
        proffesorRepository.save(new Proffesor("123A","Aurelio","Sinfu","SDI"));
        proffesorRepository.save(new Proffesor("222B","Juan","Juu","ASW"));
    }

    public List<Proffesor> getProffesors(){
        List<Proffesor> proffesors = new ArrayList<>();
        proffesorRepository.findAll().forEach(proffesors::add);
        return proffesors;
    }

    public Proffesor getProffesor(Long id){
        return proffesorRepository.findById(id).get();
    }

    public void addProffesor(Proffesor prof){
        proffesorRepository.save(prof);
    }

    public void deleteProffesor(Long id){
        proffesorRepository.deleteById(id);
    }

    public Proffesor getProffesorByDni(String dni){
        return  proffesorRepository.getProffesorByDni(dni);
    }
}
