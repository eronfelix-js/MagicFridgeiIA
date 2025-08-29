package dev.Felix.MagicFridayIA.Service;

import dev.Felix.MagicFridayIA.Entity.FoodItem;
import dev.Felix.MagicFridayIA.Repository.FoodItemRpository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodItemService {
    private final FoodItemRpository repository;

    public FoodItem createItem(FoodItem requestItem){
        return repository.save(requestItem);
    }

    public List<FoodItem> getAllITem(){
        return repository.findAll();
    }

    public FoodItem getByIdItem(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("o id não foi encontrado"));
    }

    public FoodItem updateItem(Long id, FoodItem foodItem){
        FoodItem Item = getByIdItem(id);
        Item.setName(foodItem.getName());
        Item.setQuantify(foodItem.getQuantify());
        Item.setValidity(foodItem.getValidity());
        Item.setCategories(foodItem.getCategories());
        return repository.save(Item);
    }

    public void deleteItem(Long id){
        repository.deleteById(id);
    }

}
