package com.example.animalcrud.entity;

import javax.persistence.*;
import java.sql.Blob;

// Annotation to mark this class as a JPA entity
@Entity
// Annotation to specify the table name in the database
@Table(name = "animals")
public class Animal {
	// Annotation to mark the primary key
	@Id
	// Annotation to specify the primary key generation strategy
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String category;
	private String description;
	private String lifeExpectancy;

	// Annotation to mark the field as a large object
	@Lob
	// Annotation to specify the column definition in the database
	@Column(columnDefinition = "BLOB")
	private Blob image;

	// Getter for the id field
	public Long getId() {
		return id;
	}

	// Setter for the id field
	public void setId(Long id) {
		this.id = id;
	}

	// Getter for the name field
	public String getName() {
		return name;
	}

	// Setter for the name field
	public void setName(String name) {
		this.name = name;
	}

	// Getter for the category field
	public String getCategory() {
		return category;
	}

	// Setter for the category field
	public void setCategory(String category) {
		this.category = category;
	}

	// Getter for the description field
	public String getDescription() {
		return description;
	}

	// Setter for the description field
	public void setDescription(String description) {
		this.description = description;
	}

	// Getter for the lifeExpectancy field
	public String getLifeExpectancy() {
		return lifeExpectancy;
	}

	// Setter for the lifeExpectancy field
	public void setLifeExpectancy(String lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	// Getter for the image field
	public Blob getImage() {
		return image;
	}

	// Setter for the image field
	public void setImage(Blob image) {
		this.image = image;
	}

	// Overridden toString method to return a string representation of the Animal object
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", lifeExpectancy=" + lifeExpectancy + ", image=" + image + "]";
	}
}