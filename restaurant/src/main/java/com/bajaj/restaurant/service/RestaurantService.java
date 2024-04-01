package com.bajaj.restaurant.service;

import com.bajaj.restaurant.models.Dish;
import com.bajaj.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Dish> getAllDishes(){
        return restaurantRepository.findAll();
    }

    public Optional<Dish> getDishById(Long id){

        return restaurantRepository.findDishById(id);
    }

    public Dish createDish(Dish dish){

        Dish dishNew = restaurantRepository.save(dish);
        return dishNew;
    }

    public Dish updateDish(Dish dish){

        Optional<Dish> dishExisting = restaurantRepository.findDishById(dish.getId());
        if(dishExisting.isEmpty()){
           return new Dish();

        }
        Dish dishToUpdate = dishExisting.get();
        dishToUpdate.setName(dish.getName());
        dishToUpdate.setIngredients(dish.getIngredients());
        dishToUpdate.setPrice(dish.getIngredients());
        dishToUpdate.setIngredients(dish.getPrice());
        dishToUpdate.setTag(dish.getTag());
        dishToUpdate.setImageUrl(dish.getImageUrl());
        dishToUpdate.setPrepMins(dish.getPrepMins());
        restaurantRepository.save(dishToUpdate);
        return dishToUpdate;
    }

    public Boolean delete(Long id){

        Optional<Dish> dishExisting = restaurantRepository.findDishById(id);
        if(dishExisting.isEmpty()){
            return false;

        }
        restaurantRepository.delete(dishExisting.get());
        return true;
    }
}
