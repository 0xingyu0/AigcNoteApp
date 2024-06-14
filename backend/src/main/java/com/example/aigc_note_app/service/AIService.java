package main.java.com.example.aigc_note_app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

import java.util.HashMap;
import java.util.Map;

@Service
public class AIService {

    @Value("${ai.service.url}")
    private String aiServiceUrl;

    public String generateText(String prompt, int maxLength) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("prompt", prompt);
        requestBody.put("max_length", maxLength);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(
            aiServiceUrl + "/generate",
            HttpMethod.POST,
            requestEntity,
            new ParameterizedTypeReference<Map<String, Object>>() {}
        );

        Map<String, Object> responseBody = responseEntity.getBody();
        if (responseBody != null) {
            return (String) responseBody.get("generated_text");
        } else {
            throw new RuntimeException("Response body is null");
        }
    }
}
