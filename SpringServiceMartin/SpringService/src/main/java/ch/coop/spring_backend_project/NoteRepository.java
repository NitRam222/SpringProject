package ch.coop.spring_backend_project;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class NoteRepository {
    private final Map<String, String> notes = new HashMap<>();

    public Map<String, String> findAll() {
        return new HashMap<>(notes);
    }

    public Optional<String> findById(String id) {
        return Optional.ofNullable(notes.get(id));
    }

    public boolean delete(String id) {
        return notes.remove(id) != null;
    }

    public Map<String, String> save(String content) {
        String id = UUID.randomUUID().toString();
        notes.put(id, content);
        return Map.of("id", id, "content", content);
    }

    public boolean update(String id, String newContent) {
        if (notes.containsKey(id)) {
            notes.put(id, newContent);
            return true;
        }
        return false;
    }

}
