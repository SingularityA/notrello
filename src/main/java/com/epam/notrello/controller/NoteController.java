package com.epam.notrello.controller;

import com.epam.notrello.dto.FileDto;
import com.epam.notrello.dto.NoteDto;
import com.epam.notrello.service.NoteService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/list")
    public String list(Model model) {
        final List<NoteDto> notes = noteService.findAll();
        model.addAttribute("notes", notes);
        return "notes/list";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable Long id) {
        final NoteDto note = noteService.find(id);
        model.addAttribute("note", note);
        return "notes/view";
    }

    @GetMapping("/json/{id}")
    @ResponseBody
    public ResponseEntity<NoteDto> jsonExport(@PathVariable Long id) {
        final NoteDto note = noteService.find(id);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/add")
    public String addGet(Model model) {
        final NoteDto note = new NoteDto();
        setAddBehaviour(model);
        model.addAttribute("note", note);
        return "notes/form";
    }

    @PostMapping("/add")
    public String addPost(Model model,
                          @Valid @ModelAttribute("note") NoteDto note,
                          BindingResult result) {
        if (result.hasErrors()) {
            setAddBehaviour(model);
            return "notes/form";
        }
        noteService.create(note);
        return "redirect:/note/list";
    }

    @GetMapping("/json/add")
    public String jsonImportGet(Model model) {
        model.addAttribute("dto", FileDto.builder().build());
        return "notes/file";
    }

    @SneakyThrows
    @PostMapping("/json/add")
    public String jsonImportPost(@ModelAttribute("fileDto") FileDto dto,
                                 BindingResult result) {

        if (dto.getFile().isEmpty()) {
            result.rejectValue("file", "", "File should be specified!");
        }

        if (result.hasErrors()) {
            return "notes/file";
        }

        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        final NoteDto note = mapper.readValue(dto.getFile().getBytes(), NoteDto.class);

        note.setId(null);
        note.setLastUpdated(LocalDateTime.now());

        // TODO save
        noteService.create(note);

        return "redirect:/note/list";
    }

    @GetMapping("/edit/{id}")
    public String editGet(Model model, @PathVariable Long id) {
        final NoteDto note = noteService.find(id);
        setEditBehaviour(model, id);
        model.addAttribute("note", note);
        return "notes/form";
    }

    @PostMapping("/edit/{id}")
    public String editPost(Model model,
                           @PathVariable Long id,
                           @Valid @ModelAttribute("note") NoteDto note,
                           BindingResult result) {
        if (result.hasErrors()) {
            setEditBehaviour(model, id);
            return "notes/form";
        }
        noteService.update(id, note);
        return "redirect:/note/view/{id}";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        noteService.delete(id);
        return "redirect:/note/list";
    }

    private void setAddBehaviour(Model model) {
        model.addAttribute("pageTitle", "Add Note");
        model.addAttribute("discardUrl", "/note/list");
        model.addAttribute("currentUrl", "note/add");
    }

    private void setEditBehaviour(Model model, Long id) {
        model.addAttribute("pageTitle", "Edit Note");
        model.addAttribute("discardUrl", "/note/view/" + id);
        model.addAttribute("currentUrl", "note/edit/" + id);
    }
}
