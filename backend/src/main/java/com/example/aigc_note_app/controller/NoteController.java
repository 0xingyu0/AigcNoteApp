package main.java.com.example.aigc_note_app.controller;

import main.java.com.example.aigc_note_app.model.Note;
import main.java.com.example.aigc_note_app.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id)
                .map(note -> ResponseEntity.ok(note))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        return noteRepository.findById(id)
                .map(note -> {
                    note.setContent(noteDetails.getContent());
                    return ResponseEntity.ok(noteRepository.save(note));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
}
