package ch.coop.spring_project;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class MyController {

    private final List<Message> messages = new ArrayList<>();

    @GetMapping("/status")
    public String returnStatus() {
        return "Status: OK";
    }

    // dynamisch
    @GetMapping("/greet/{name}")
    public String greetNameDynamic(@PathVariable String name) {
        return "Grüss dich," + name + "!";
    }

    // Nicht dynamisch
    @GetMapping("/greet")
    public String greetNameNonDynamic(@RequestParam String name) {
        return "Grüss dich, " + name + "!";
    }

    @PostMapping("/message")
    public List<Message> addMessage(@RequestBody Message message) {
        messages.add(message);

        return messages;
    }

    record Message(
            String content) {

    }

}
