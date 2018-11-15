package com.dnebinger.jackson.mapping.impl;

import com.dnebinger.jackson.mapping.api.Mapping;
import com.dnebinger.jackson.pojo.animal.Cat;
import com.dnebinger.jackson.pojo.animal.Dog;
import com.dnebinger.jackson.pojo.person.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class MappingImplTest {

	private Mapping mapping;

	@Before
	public void setUp() throws Exception {
		mapping = new MappingImpl();
	}

	private static final String CAT_JSON = "{\"type\":\"cat\",\"name\":\"Claire\",\"age\":8,\"breed\":\"Common House Cat\",\"treat\":\"Fish Flakes\"}";
	private static final String PERSON_JSON = "{\"name\":\"Dave\",\"pets\":[{\"type\":\"cat\",\"name\":\"Claire\",\"age\":8,\"breed\":\"Common House Cat\",\"treat\":\"Fish Flakes\"},{\"type\":\"dog\",\"name\":\"Charlie\",\"age\":10,\"breed\":\"Sheepdog\",\"ears\":true,\"walked\":[2018,11,10]}]}";

	@Test
	public void whenMarshalPetToJson_thenVerifyJson() {
		Cat cat = new Cat();

		cat.setFavoriteTreat("Fish Flakes");
		cat.setAge(8);
		cat.setBreed("Common House Cat");
		cat.setName("Claire");

		String catStr = cat.toString();

		String json = mapping.petToJson(cat);

		assertThat(json).isNotNull();
		assertThat(json).isEqualTo(CAT_JSON);

		// now convert the json back to a pet string
		String parsedCat = mapping.petJsonToString(json);

		assertThat(parsedCat).isEqualTo(catStr);

		Person person = new Person();

		person.setName("Dave");
		person.addPet(cat);

		Dog dog = new Dog();
		dog.setBreed("Sheepdog");
		dog.setLastWalked(LocalDate.now().minusDays(5));
		dog.setName("Charlie");
		dog.setAge(10);
		dog.setLikesPigsEars(true);

		person.addPet(dog);

		json = mapping.personToJson(person);
		String personStr = person.toString();
		String parsedPerson = mapping.personJsonToString(json);

		assertThat(json).isNotBlank();
		assertThat(json).overridingErrorMessage("Expected %s to equal %s", json, PERSON_JSON).isEqualTo(PERSON_JSON);
		assertThat(parsedPerson).isEqualTo(personStr);
	}
}
