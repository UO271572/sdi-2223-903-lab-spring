package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Proffesor;
import com.uniovi.notaneitor.services.ProffesorService;
import com.uniovi.notaneitor.validators.ProffesorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProffesorController {

    @Autowired
    private ProffesorService proffesorService;
    @Autowired
    private ProffesorValidator proffesorValidator;

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

    @RequestMapping(value = "/proffesor/edit/{id}", method = RequestMethod.GET)
    public String getEdit(Model model,@PathVariable Long id){
        model.addAttribute("prof",proffesorService.getProffesor(id));
        return "proffesor/edit";
    }

    @RequestMapping(value="/proffesor/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@Validated Proffesor prof, @PathVariable Long id, BindingResult result)
    {
        System.out.println("salida 1");
        proffesorValidator.validate(prof,result);
        if(result.hasErrors()){
            System.out.println("salida 2");
            return "proffesor/edit";
        }
        System.out.println("salida 3");
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
