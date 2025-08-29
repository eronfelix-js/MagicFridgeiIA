package dev.Felix.MagicFridayIA.Controller;

import dev.Felix.MagicFridayIA.Entity.FoodItem;
import dev.Felix.MagicFridayIA.Service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodItemController {

    private final FoodItemService service;

    @PostMapping
    public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem){
        return ResponseEntity.ok().body(service.createItem(foodItem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getByIdFoodItem(Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.getByIdItem(id));
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> getAllFoodItem(){
        return ResponseEntity.ok().body(service.getAllITem());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateItem(@PathVariable Long id,@RequestBody FoodItem item){
        return ResponseEntity.ok().body(service.updateItem(id,item));
    }

}
