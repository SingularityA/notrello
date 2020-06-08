package com.epam.notrello.repository;

import com.epam.notrello.entity.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findAllByOrderByLastUpdatedDesc();
}
