package com.uniovi.notaneitor.repositories;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Proffesor;
import org.springframework.data.repository.CrudRepository;

public interface ProffesorRepository extends CrudRepository<Proffesor, Long> {
    public Proffesor getProffesorByDni(String dni);
}
