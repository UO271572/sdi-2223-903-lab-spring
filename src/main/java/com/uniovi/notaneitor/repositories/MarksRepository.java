package com.uniovi.notaneitor.repositories;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MarksRepository extends CrudRepository<Mark, Long> {
    @Modifying
    @Transactional
    @Query("SELECT r FROM Mark r WHERE r.user = ?1 ORDER BY r.id ASC")
    void updateResend(Boolean resend, Long id);

    List<Mark> findAllByUser(User user);

    @Query("SELECT r FROM Mark r WHERE (LOWER(r.description) like LOWER(?1) or lower(r.user.name) like lower(?1))")
    List<Mark> searchByDescriptionAndName (String searchtext);

    @Query("SELECT r FROM Mark r WHERE (LOWER(r.description) like LOWER(?1) or lower(r.user.name) like lower(?1)) and r.user = ?2")
    List<Mark> searchByDescriptionNameAndUser (String searchtext, User user);
}
