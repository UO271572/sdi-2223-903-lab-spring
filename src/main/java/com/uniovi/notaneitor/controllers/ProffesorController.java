package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Proffesor;
import com.uniovi.notaneitor.services.ProffesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProffesorController {

    @Autowired
    private ProffesorService proffesorService;

    @RequestMapping("/proffesor/list")
    public String getList(){
        return proffesorService.getProffesors().toString();
    }

    @RequestMapping(value = "/proffesor/add", method = RequestMethod.POST)
    public String addProffesor(@ModelAttribute Proffesor prof){
        proffesorService.addProffesor(prof);
        return "Añadir";
    }

    @RequestMapping("/proffesor/edit/{id}")
    public String getEdit(@PathVariable Long id){
        return proffesorService.getProffesor(id).toString();
    }


    @RequestMapping(value="/proffesor/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Proffesor prof, @PathVariable Long id)
    {
        prof.setId(id);
        proffesorService.addProffesor(prof);
        return "redirect:/proffesor/details/"+id;
    }



    @RequestMapping("/proffesor/details/{id}")
    public String detailsProffesor(@PathVariable Long id){
        return proffesorService.getProffesor(id).toString();
    }

    @RequestMapping("/proffesor/delete/{id}")
    public String deleteProffesor(@PathVariable Long id){
        proffesorService.deleteProffesor(id);
        return "Eliminado";
    }


}
