package ch.coop.spring_backend_project;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Map<String, String>> getAllNotes() {
        List<Map<String, String>> notesList = new ArrayList<>();
        noteRepository.findAll().forEach((id, content) -> {
            notesList.add(Map.of("id", id, "content", content));
        });
        return notesList;
    }

    public String getNoteById(String id) {
        Optional<String> note = noteRepository.findById(id);
        return note.orElse("Notiz nicht gefunden");
    }

    public Map<String, String> create(String content) {
        return noteRepository.save(content);
    }

    public boolean delete(String id) {
        return noteRepository.delete(id);
    }

    public Optional<Map<String, String>> update(String id, String newContent) {
        boolean updated = noteRepository.update(id, newContent);
        if (updated) {
            return Optional.of(Map.of("id", id, "content", newContent));
        }
        return Optional.empty();
    }

}
