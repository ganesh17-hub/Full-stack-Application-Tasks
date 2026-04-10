package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {

private final FruitRepository repo;

public FruitController(FruitRepository repo){
 this.repo = repo;
}

@GetMapping
public List<Fruit> getAllFruits(){
 return repo.findAll();
}
@PostMapping
public List<Fruit> addFruits(@RequestBody List<Fruit> fruits){
    return repo.saveAll(fruits);
}

}