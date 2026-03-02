package com.indore.Repo;

import com.indore.Dto.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepo extends JpaRepository<Animal,Integer> {

    @Query("SELECT a FROM Animal a where a.name=?1")
    public List<Animal> fetchByName(String name);
}
