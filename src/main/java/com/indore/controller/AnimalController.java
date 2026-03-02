package com.indore.controller;

import com.indore.Dao.AnimalCrud;
import com.indore.Dto.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    public AnimalCrud crud;

    @PostMapping("/add")
    public Animal saveAnimal(@RequestBody Animal animal){
        return crud.saveAnimal(animal);
    }

    @GetMapping("/animal")
    public Animal fetchAnimalById(@RequestParam int id){
        return crud.fetchAnimalById(id);
    }

     //delete mapping
     @DeleteMapping("/delete")
    public Animal deleteAnimalById(@RequestParam int id){
        return crud.deleteAnimalById(id);
    }

    //update
    @PutMapping("/update")
    public Animal updateAnimal(@RequestBody Animal animal){
        return crud.updateAnimal(animal);
    }

    @GetMapping("/FetchALl")
    public List<Animal> fetchAllAnimal(){
        return crud.fetchAllAnimal();
    }

    @GetMapping("/fetchByName")
    public List<Animal> fetchByName(@RequestParam String name){
        return crud.fetchByName(name);
    }
}
