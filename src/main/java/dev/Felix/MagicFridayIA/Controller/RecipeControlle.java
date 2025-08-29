package dev.Felix.MagicFridayIA.Controller;

import dev.Felix.MagicFridayIA.Entity.FoodItem;
import dev.Felix.MagicFridayIA.Service.FoodItemService;
import dev.Felix.MagicFridayIA.Service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeControlle {

    private final GeminiService geminiService;
    private final FoodItemService service;

    @GetMapping("/gemini/connection")
    public Mono<String> testGeminiConnection() {
        return geminiService.testConnection();
    }

    @GetMapping("/gemini/generate")
    public Mono<String> generateRecipe() {
        List<FoodItem> allITem = service.getAllITem();
        return geminiService.generateRecipe(allITem);
    }

}
