package com.example.animalcrud.service;

import com.example.animalcrud.entity.Animal;
import com.example.animalcrud.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Annotation to mark this class as a Spring service
@Service
public class AnimalService {
	// Injecting the AnimalRepository dependency
	@Autowired
	private AnimalRepository animalRepository;

	// Method to get a list of all animals
	public List<Animal> findAll() {
		// Using the repository to fetch all animals
		return animalRepository.findAll();
	}

	// Method to save a new or updated animal
	public Animal save(Animal animal) {
		// Using the repository to save the animal
		return animalRepository.save(animal);
	}

	// Method to find an animal by its ID
	public Animal findById(Long id) {
		// Using the repository to find the animal by ID, returning null if not found
		return animalRepository.findById(id).orElse(null);
	}

	// Method to delete an animal by its ID
	public void deleteById(Long id) {
		// Using the repository to delete the animal by ID
		animalRepository.deleteById(id);
	}
}