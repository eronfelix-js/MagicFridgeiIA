package dev.Felix.MagicFridayIA.Repository;

import dev.Felix.MagicFridayIA.Entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRpository extends JpaRepository<FoodItem, Long> {
}
