package com.uniovi.notaneitor.validators;

import com.uniovi.notaneitor.entities.Proffesor;
import com.uniovi.notaneitor.entities.User;
import com.uniovi.notaneitor.services.ProffesorService;
import com.uniovi.notaneitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProffesorValidator implements Validator{
        @Autowired
        private ProffesorService proffesorService;
        @Override
        public boolean supports(Class<?> aClass) {
            return Proffesor.class.equals(aClass);
        }
        @Override
        public void validate(Object target, Errors errors) {
            Proffesor prof = (Proffesor) target;
            //if (!(prof.getDni().length() == 10 && Character.isAlphabetic(prof.getDni().charAt(10)))) {
            //   errors.rejectValue("dni", "Error.edit.dni.length");}
            //Proffesor teacherRepeatedDni = proffesorService.getProffesorByDni(prof.getDni());
            //if(teacherRepeatedDni != null && !teacherRepeatedDni.equals(prof)){
              //  errors.rejectValue("dni", "Error.edit.dni.duplicate");}
            if (proffesorService.getProffesor(prof.getId()) != null) {
                errors.rejectValue("id", "Error.edit.id.duplicate");}
        }
    }
