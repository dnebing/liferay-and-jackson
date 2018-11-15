package com.dnebinger.jackson.pojo.animal;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value = Dog.class, name = "dog"),
		@JsonSubTypes.Type(value = Cat.class, name = "cat")
})
public class Pet {
	private String name;
	private int age;
	private String breed;

	@Override
	public String toString() {
		return new ToStringBuilder(this, CustomToStringStyle.CUSTOM_TO_STRING_STYLE)
				.append("name", name)
				.append("age", age)
				.append("breed", breed)
				.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Pet)) return false;

		Pet pet = (Pet) o;

		return new EqualsBuilder()
				.append(age, pet.age)
				.append(name, pet.name)
				.append(breed, pet.breed)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.append(age)
				.append(breed)
				.toHashCode();
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
