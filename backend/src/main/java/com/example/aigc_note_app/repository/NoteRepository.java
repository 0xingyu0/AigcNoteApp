package main.java.com.example.aigc_note_app.repository;

import main.java.com.example.aigc_note_app.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
