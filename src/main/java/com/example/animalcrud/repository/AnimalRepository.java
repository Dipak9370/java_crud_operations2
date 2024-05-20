package com.example.animalcrud.repository;

import com.example.animalcrud.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for Animal entities
// JpaRepository provides basic CRUD operations and more for the Animal entity
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
