package com.card.menu.controller;

import com.card.menu.food.Food;
import com.card.menu.food.FoodRepository;
import com.card.menu.food.FoodRequestDTO;
import com.card.menu.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired 
    private FoodRepository repository;

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        var foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }


}
