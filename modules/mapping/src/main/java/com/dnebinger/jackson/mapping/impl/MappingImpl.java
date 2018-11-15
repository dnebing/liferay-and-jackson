package com.dnebinger.jackson.mapping.impl;

import com.dnebinger.jackson.mapping.api.Mapping;
import com.dnebinger.jackson.pojo.animal.Pet;
import com.dnebinger.jackson.pojo.person.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

@Component(
		immediate = true,
		service = Mapping.class
)
public class MappingImpl implements Mapping {
	@Override
	public String petToJson(Pet pet) {
		ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule())
				.registerModule(new Jdk8Module())
				.registerModule(new JavaTimeModule());
		String jsonResult = null;
		try {
			//jsonResult = mapper.writerWithDefaultPrettyPrinter()
			//		.writeValueAsString(pet);
			jsonResult = mapper.writer()
					.writeValueAsString(pet);
		} catch (JsonProcessingException e) {
			_log.error("Error rendering pet json: " + e.getMessage(), e);
		}

		return jsonResult;
	}

	@Override
	public Pet parsePet(String json) {
		ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule())
				.registerModule(new Jdk8Module())
				.registerModule(new JavaTimeModule());

		Pet pet = null;
		try {
			pet = mapper.readValue(json, Pet.class);
		} catch (IOException e) {
			_log.error("Error parsing pet json: " + e.getMessage(), e);
		}

		if (pet == null) {
			return null;
		}

		return pet;
	}

	@Override
	public Person parsePerson(String json) {
		ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule())
				.registerModule(new Jdk8Module())
				.registerModule(new JavaTimeModule());

		Person person = null;
		try {
			person = mapper.readValue(json, Person.class);
		} catch (IOException e) {
			_log.error("Error parsing person json: " + e.getMessage(), e);
		}

		if (person == null) {
			return null;
		}

		return person;
	}

	@Override
	public String petJsonToString(String json) {
		ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule())
				.registerModule(new Jdk8Module())
				.registerModule(new JavaTimeModule());

		Pet pet = null;
		try {
			pet = mapper.readValue(json, Pet.class);
		} catch (IOException e) {
			_log.error("Error parsing pet json: " + e.getMessage(), e);
		}

		if (pet == null) {
			return null;
		}

		return pet.toString();
	}

	@Override
	public String personToJson(Person person) {
		ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule())
				.registerModule(new Jdk8Module())
				.registerModule(new JavaTimeModule());
		String jsonResult = null;
		try {
			//jsonResult = mapper.writerWithDefaultPrettyPrinter()
			//		.writeValueAsString(person);
			jsonResult = mapper.writer()
					.writeValueAsString(person);
		} catch (JsonProcessingException e) {
			_log.error("Error rendering person json: " + e.getMessage(), e);
		}

		return jsonResult;
	}

	@Override
	public String personJsonToString(String json) {
		ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule())
				.registerModule(new Jdk8Module())
				.registerModule(new JavaTimeModule());

		Person person = null;
		try {
			person = mapper.readValue(json, Person.class);
		} catch (IOException e) {
			_log.error("Error parsing person json: " + e.getMessage(), e);
		}

		if (person == null) {
			return null;
		}

		return person.toString();
	}

	private static final Log _log = LogFactoryUtil.getLog(MappingImpl.class);
}
