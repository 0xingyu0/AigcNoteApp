package main.java.com.example.aigc_note_app.controller;

import main.java.com.example.aigc_note_app.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    @Autowired
    private AIService aiService;

    @PostMapping("/generate")
    public Map<String, String> generateText(@RequestBody Map<String, Object> request) {
        String prompt = (String) request.get("prompt");
        int maxLength = (int) request.get("max_length");
        String generatedText = aiService.generateText(prompt, maxLength);
        return Map.of("generated_text", generatedText);
    }
}
