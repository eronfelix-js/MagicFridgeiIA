package dev.Felix.MagicFridayIA.Service;

import dev.Felix.MagicFridayIA.Entity.FoodItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeminiService {



    private String apiKey = System.getenv("key");

    private final WebClient webClient = WebClient.create();

    public Mono<String> generateRecipe(List<FoodItem> foodItem) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + apiKey;

        String alimentos = foodItem.stream()
                .map(item -> String.format("%s (%s) - quantify: %d, validity: %s",
                        item.getName(),item.getCategories(), item.getQuantify(), item.getValidity()))
                .collect(Collectors.joining("/n"));

        String prompt = "baseado no meu banco de dados sugira uma receita com os seguintes itens:/n" + alimentos;

        Map<String, Object> request = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text",prompt )
                        ))
                )
        );

        return webClient.post()
                .uri(url)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    List<Map> candidates = (List<Map>) response.get("candidates");
                    Map content = (Map) candidates.get(0).get("content");
                    List<Map> parts = (List<Map>) content.get("parts");
                    return (String) parts.get(0).get("text");
                });
    }

    public Mono<String> testConnection() {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + apiKey;

        Map<String, Object> request = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", "Diga olá")
                        ))
                )
        );

        return webClient.post()
                .uri(url)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    List<Map> candidates = (List<Map>) response.get("candidates");
                    Map content = (Map) candidates.get(0).get("content");
                    List<Map> parts = (List<Map>) content.get("parts");
                    return "Conexão OK: " + parts.get(0).get("text");
                });
    }
}