package ch.coop.spring_backend_project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getNoteById(@PathVariable String id) {
        String note = noteService.getNoteById(id);
        return note != null ? ResponseEntity.ok(note)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notiz nicht gefunden");
    }

    @GetMapping("/")
    public List<Map<String, String>> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping("/create")
    public Map<String, String> createNote(@RequestBody Map<String, String> request) {
        String content = request.get("content");
        return noteService.create(content);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateNote(@PathVariable String id,
            @RequestBody Map<String, String> request) {
        String newContent = request.get("content");
        Optional<Map<String, String>> updatedNote = noteService.update(id, newContent);
        return updatedNote.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Map<String, String>>> deleteNoteById(@PathVariable String id) {
        boolean deleted = noteService.delete(id);
        if (deleted) {
            List<Map<String, String>> remainingNotes = noteService.getAllNotes();
            return ResponseEntity.ok(remainingNotes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
