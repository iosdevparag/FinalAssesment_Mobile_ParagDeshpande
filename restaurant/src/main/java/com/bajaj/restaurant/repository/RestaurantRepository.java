package com.bajaj.restaurant.repository;

import com.bajaj.restaurant.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Dish, Long> {

    Optional<Dish> findDishById(Long id);
}
