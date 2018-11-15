package com.dnebinger.jackson.pojo.person;

import com.dnebinger.jackson.pojo.animal.CustomToStringStyle;
import com.dnebinger.jackson.pojo.animal.Pet;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
	private String name;
	private List<Pet> pets;

	@Override
	public String toString() {
		return new ToStringBuilder(this, CustomToStringStyle.CUSTOM_TO_STRING_STYLE)
				.append("name", name)
				.append("pets", pets)
				.toString();
	}

	public void addPet(final Pet pet) {
		if (pets == null) {
			pets = new ArrayList<>();
		}

		pets.add(pet);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}
