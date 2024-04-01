package com.bajaj.restaurant.controllers;

import com.bajaj.restaurant.models.Dish;
import com.bajaj.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("")
    ResponseEntity<Object> getAllDishes(){
       List<Dish> dishes = restaurantService.getAllDishes();
        return new ResponseController().generateResponse("Dishes", HttpStatus.OK,dishes);

    }

    @GetMapping("/{id}")
    ResponseEntity<Object> getDishById(@PathVariable Long id){
        Optional<Dish> optionalDish = restaurantService.getDishById(id);
        if(optionalDish.isEmpty()){
            new ResponseController().generateResponse("Dish With Provided Id not Found", HttpStatus.OK,null);
        }
        return new ResponseController().generateResponse("Dish", HttpStatus.OK,optionalDish.get());

    }


    @PostMapping("/create-dish")
    ResponseEntity<Object> createDish(@RequestBody Dish dish){
        Dish dishNew = restaurantService.createDish(dish);
        return new ResponseController().generateResponse("Dish Created", HttpStatus.OK,dishNew);

    }

    @PutMapping("/update-dish")
    ResponseEntity<Object> updateDis(@RequestBody Dish dish){
        Dish dishNew = restaurantService.updateDish(dish);
        return new ResponseController().generateResponse("Dish Updated", HttpStatus.OK,dishNew);

    }

    @DeleteMapping("/delete-dish")
    ResponseEntity<Object> delete(@RequestBody Dish dish){
        Boolean isDeleted = restaurantService.delete(dish.getId());

        return new ResponseController().generateResponse(isDeleted ? "Dish Deleted" : "Failed to delete", HttpStatus.OK,null);

    }

}
