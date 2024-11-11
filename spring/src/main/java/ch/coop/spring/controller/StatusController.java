package ch.coop.spring.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StatusController {

    private final List<Message> messages = new ArrayList<>();

    @GetMapping("/api/status")
    public String getStatus() {
        return "Status: OK";
    }

    @GetMapping("/api/status/{name}")
    public String greetVariable(@PathVariable String name) {
        return "Grüss dich," + name + "!";
    }

    @GetMapping("/api/greet")
    public String greetParam(@RequestParam String name) {
        return "Grüss dich, " + name + "!";
    }

    @PostMapping("/api/message")
    public List<Message> addMessage(@RequestBody Message message) {
        messages.add(message);

        return messages;
    }

}
