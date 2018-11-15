package com.dnebinger.jackson.mapping.api;

import com.dnebinger.jackson.pojo.animal.Pet;
import com.dnebinger.jackson.pojo.person.Person;

/**
 * @author dnebinger
 */
public interface Mapping {

	/**
	 * petToJson: Given a pet, convert it to JSON.
	 * @param pet
	 * @return String The json for the pet.
	 */
	String petToJson(final Pet pet);

	/**
	 * petJsonToString: Given JSON, parse to a pet and then output the string version of the entity.
	 * @param json
	 * @return String The string version of the parsed pet json.
	 */
	String petJsonToString(final String json);

	/**
	 * parsePet: Given JSON, parse to a pet.
	 * @param json
	 * @return Pet The parsed pet.
	 */
	Pet parsePet(final String json);

	/**
	 * personToJson: Convert the given person into a JSON string.
	 * @param person
	 * @return String The json for the person.
	 */
	String personToJson(final Person person);

	/**
	 * personJsonToString: Given JSON, parse to a person and then output the string version of the entity.
	 * @param json
	 * @return String The string version of the parsed person json.
	 */
	String personJsonToString(final String json);

	/**
	 * parsePerson: Parses a person from the given json.
	 * @param json
	 * @return Person The parsed person.
	 */
	Person parsePerson(final String json);
}

