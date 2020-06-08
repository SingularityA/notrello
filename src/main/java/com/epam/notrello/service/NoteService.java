package com.epam.notrello.service;

import com.epam.notrello.dto.NoteDto;
import com.epam.notrello.entity.Note;
import com.epam.notrello.exception.NotFoundException;
import com.epam.notrello.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteDto find(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        return NoteDto.builder()
                .id(note.getId())
                .title(note.getTitle())
                .text(note.getText())
                .created(note.getCreated())
                .lastUpdated(note.getLastUpdated())
                .build();
    }

    public List<NoteDto> findAll() {
        return noteRepository.findAllByOrderByLastUpdatedDesc().stream()
                .map(note -> NoteDto.builder()
                        .id(note.getId())
                        .text(note.getText())
                        .title(note.getTitle())
                        .created(note.getCreated())
                        .lastUpdated(note.getLastUpdated())
                        .build())
                .collect(Collectors.toList());
    }

    public void create(NoteDto dto) {
        final LocalDateTime now = LocalDateTime.now();
        final Note note = Note.builder()
                .text(dto.getText())
                .title(dto.getTitle())
                .created(now)
                .lastUpdated(now)
                .build();

        noteRepository.save(note);
    }

    public void update(Long id, NoteDto dto) {
        final Note note = noteRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        note.setText(dto.getText());
        note.setTitle(dto.getTitle());
        note.setLastUpdated(LocalDateTime.now());

        noteRepository.save(note);
    }

    public void delete(Long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        }
    }
}
