package com.example.animalcrud.controller;

import com.example.animalcrud.entity.Animal;
import com.example.animalcrud.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

// Annotation to mark this class as a Spring MVC Controller
@Controller
// Base request mapping for all methods in this controller
@RequestMapping("/animals")
public class AnimalController {

	// Injecting the AnimalService dependency
	@Autowired
	private AnimalService animalService;

	// Handler for GET requests to "/animals", returns a list of animals
	@GetMapping
	public String listAnimals(Model model) {
		// Adds the list of all animals to the model
		model.addAttribute("animals", animalService.findAll());
		// Returns the view name "animal-list"
		return "animal-list";
	}

	// Handler for GET requests to "/animals/new", returns the form to create a new animal
	@GetMapping("/new")
	public String newAnimalForm(Model model) {
		// Adds an empty Animal object to the model
		model.addAttribute("animal", new Animal());
		// Returns the view name "animal-form"
		return "animal-form";
	}

	// Handler for POST requests to "/animals", saves a new animal
	@PostMapping
	public String saveAnimal(@ModelAttribute Animal animal, @RequestParam("imageFile") MultipartFile imageFile,
			Model model) throws IOException, SQLException {
		// Check if the uploaded image file is not empty
		if (!imageFile.isEmpty()) {
			// Convert the uploaded file into a Blob
			Blob image = new SerialBlob(imageFile.getBytes());
			// Set the image on the animal entity
			animal.setImage(image);
		}
		// Save the animal entity using the service
		animalService.save(animal);
		// Add a success message to the model
		model.addAttribute("successMessage", "Animal saved successfully!");
		// Redirect to the list of animals
		return "redirect:/animals";
	}

	// Handler for GET requests to "/animals/edit/{id}", returns the form to edit an animal
	@GetMapping("/edit/{id}")
	public String editAnimalForm(@PathVariable Long id, Model model) {
		// Find the animal by its id and add it to the model
		model.addAttribute("animal", animalService.findById(id));
		// Returns the view name "animal-form"
		return "animal-form";
	}

	// Handler for POST requests to "/animals/{id}", updates an existing animal
	@PostMapping("/{id}")
	public String updateAnimal(@PathVariable Long id, @ModelAttribute Animal animal,
			@RequestParam("imageFile") MultipartFile imageFile, Model model) throws IOException, SQLException {
		// Find the existing animal by its id
		Animal existingAnimal = animalService.findById(id);
		// Check if a new image file is uploaded
		if (!imageFile.isEmpty()) {
			// Convert the uploaded file into a Blob
			Blob image = new SerialBlob(imageFile.getBytes());
			// Set the new image on the existing animal entity
			existingAnimal.setImage(image);
		}
		// Update the fields of the existing animal with the values from the form
		existingAnimal.setName(animal.getName());
		existingAnimal.setCategory(animal.getCategory());
		existingAnimal.setDescription(animal.getDescription());
		existingAnimal.setLifeExpectancy(animal.getLifeExpectancy());
		// Save the updated animal entity using the service
		animalService.save(existingAnimal);
		// Add a success message to the model
		model.addAttribute("successMessage", "Animal updated successfully!");
		// Redirect to the list of animals
		return "redirect:/animals";
	}

	// Handler for GET requests to "/animals/delete/{id}", deletes an animal
	@GetMapping("/delete/{id}")
	public String deleteAnimal(@PathVariable Long id, Model model) {
		// Delete the animal by its id using the service
		animalService.deleteById(id);
		// Add a success message to the model
		model.addAttribute("successMessage", "Animal deleted successfully!");
		// Redirect to the list of animals
		return "redirect:/animals";
	}
}
