package com.epam.notrello.service;

import com.epam.notrello.dto.NoteDto;
import com.epam.notrello.entity.BasicUser;
import com.epam.notrello.entity.Note;
import com.epam.notrello.exception.ForbiddenException;
import com.epam.notrello.exception.NotFoundException;
import com.epam.notrello.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    private final UserService userService;

    public NoteDto find(Long id) {
        final Note note = getCheckedNote(id);

        return NoteDto.builder()
                .id(note.getId())
                .title(note.getTitle())
                .text(note.getText())
                .created(note.getCreated())
                .lastUpdated(note.getLastUpdated())
                .build();
    }

    public List<NoteDto> findAll() {
        final BasicUser user = userService.findByName(getAuthentication().getName());

        return user.getNotes().stream()
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
        final BasicUser user = userService.findByName(getAuthentication().getName());
        final Note note = Note.builder()
                .text(dto.getText())
                .title(dto.getTitle())
                .created(now)
                .lastUpdated(now)
                .user(user)
                .build();

        noteRepository.save(note);
    }

    public void update(Long id, NoteDto dto) {
        final Note note = getCheckedNote(id);

        note.setText(dto.getText());
        note.setTitle(dto.getTitle());
        note.setLastUpdated(LocalDateTime.now());

        noteRepository.save(note);
    }

    public void delete(Long id) {
        final Note note = getCheckedNote(id);

        noteRepository.delete(note);
    }

    private Note getCheckedNote(Long id) {
        final Note note = noteRepository
                .findById(id)
                .orElseThrow(NotFoundException::new);

        final BasicUser user = userService.findByName(getAuthentication().getName());

        if (!note.getUser().getId().equals(user.getId())) {
            throw new ForbiddenException();
        }

        return note;
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
