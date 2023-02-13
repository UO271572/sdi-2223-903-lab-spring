package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Proffesor;
import com.uniovi.notaneitor.services.ProffesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProffesorController {

    @Autowired
    private ProffesorService proffesorService;

    @RequestMapping("/proffesor/list")
    public String getList(Model model){
        model.addAttribute("profList",proffesorService.getProffesors());
        return "/proffesor/list";
    }

    @RequestMapping(value = "/proffesor/add")
    public String getProffesor() {
        return "proffesor/add";
    }

    @RequestMapping(value = "/proffesor/add", method = RequestMethod.POST)
    public String addProffesor(@ModelAttribute Proffesor prof){
        proffesorService.addProffesor(prof);
        return "redirect:/proffesor/list";
    }

    @RequestMapping("/proffesor/edit/{id}")
    public String getEdit(Model model,@PathVariable Long id){
        model.addAttribute("prof",proffesorService.getProffesor(id));
        return "proffesor/edit";
    }

    @RequestMapping(value="/proffesor/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Proffesor prof, @PathVariable Long id)
    {
        prof.setId(id);
        proffesorService.addProffesor(prof);
        return "redirect:/proffesor/details/"+id;
    }

    @RequestMapping("/proffesor/details/{id}")
    public String detailsProffesor(Model model,@PathVariable Long id){
        model.addAttribute("prof",proffesorService.getProffesor(id));
        return "/proffesor/details";
    }

    @RequestMapping("/proffesor/delete/{id}")
    public String deleteProffesor(@PathVariable Long id){
        proffesorService.deleteProffesor(id);
        return "redirect:/proffesor/list";
    }


}
