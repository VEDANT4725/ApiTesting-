package com.indore.Dao;

import com.indore.Dto.Animal;
import com.indore.Repo.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public class AnimalCrud {

    @Autowired
    private AnimalRepo repo;

    public Animal saveAnimal(Animal animal){
        return repo.save(animal);
    }

   public Animal fetchAnimalById(int id){
       Optional<Animal> db = repo.findById(id);
//       if(db.isEmpty()){
//           return null;
//       }
//       else {
//           return repo.findById(id).get();
//       }
       if(db.isPresent()){
           return repo.findById(id).get();
       }else{
           return null;
       }
   }

   //FetchAllAnimal
   public List<Animal> fetchAllAnimal(){
        List<Animal> list = repo.findAll();
        return list;
   }
//delete
    public Animal deleteAnimalById(int id){
        Optional<Animal> db = repo.findById(id);
        if(db.isPresent()){
           repo.deleteById(id);
           return db.get();
        }else{
            return null;
        }

    }

    //update logic

    public Animal updateAnimal(Animal animal){
        Optional<Animal>  db  = repo.findById(animal.getId());
        if(db.isPresent()){
            com.indore.Dto.Animal dbAnimal = db.get();

//            dbAnimal.setName("cat");
//            dbAnimal.setColor("white");

            dbAnimal.setName(animal.getName());
            dbAnimal.setColor(animal.getColor());
            return repo.save(dbAnimal);
        }else {
            return null;
        }
    }

    //FetchByName
    public List<Animal> fetchByName(String name){
        return repo.fetchByName(name);
    }
}
