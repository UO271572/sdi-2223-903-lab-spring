package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Proffesor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProffesorService {

    private List<Proffesor> proffesors = new LinkedList<>();

    @PostConstruct
    public void init(){
        proffesors.add(new Proffesor(1L,"123A","Aurelio","Sinfu","SDI"));
        proffesors.add(new Proffesor(2L,"222B","Juan","Juu","ASW"));
    }

    public List<Proffesor> getProffesors(){
        return proffesors;
    }

    public Proffesor getProffesor(Long id){
        return proffesors.stream().filter(proffesor -> proffesor.getId() == id).findFirst().get();
    }

    public void addProffesor(Proffesor prof){
        proffesors.add(prof);
    }

    public void deleteProffesor(Long id){
        proffesors.removeIf(prof -> prof.getId() == id);
    }

}
