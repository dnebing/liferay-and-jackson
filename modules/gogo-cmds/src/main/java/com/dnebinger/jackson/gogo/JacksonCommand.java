package com.dnebinger.jackson.gogo;

import com.dnebinger.jackson.mapping.api.Mapping;
import com.dnebinger.jackson.pojo.animal.Cat;
import com.dnebinger.jackson.pojo.animal.Dog;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.apache.felix.service.command.Descriptor;

@Component(
		immediate = true,
	property = {
			"osgi.command.function=createDog",
			"osgi.command.function=createCat",
			"osgi.command.function=dogJson",
			"osgi.command.function=catJson",
			"osgi.command.function=dog",
			"osgi.command.function=cat",
			"osgi.command.scope=jackson"
	},
	service = Object.class
)
public class JacksonCommand {
	private Mapping mapping;

	@Descriptor("Create a dog, name, breed, age, ears")
	public void createDog(final String... parms) {
		Dog dog = new Dog();

		if ((parms != null) && (parms.length > 0)) {
			dog.setName(parms[0]);

			if (parms.length > 1) {
				dog.setBreed(parms[1]);
			}
			if (parms.length > 2) {
				dog.setAge(GetterUtil.getInteger(parms[2]));
			}
			if (parms.length > 3) {
				dog.setLikesPigsEars(GetterUtil.getBoolean(parms[3]));
			}
		}

		System.out.println(dog.toString());
	}

	@Descriptor("Create a cat, name, breed, age, treats")
	public void createCat(final String... parms) {
		Cat cat = new Cat();

		if ((parms != null) && (parms.length > 0)) {
			cat.setName(parms[0]);

			if (parms.length > 1) {
				cat.setBreed(parms[1]);
			}
			if (parms.length > 2) {
				cat.setAge(GetterUtil.getInteger(parms[2]));
			}
			if (parms.length > 3) {
				cat.setFavoriteTreat(parms[3]);
			}
		}

		System.out.println(cat.toString());
	}

	@Descriptor("Show dog JSON, name, breed, age, ears")
	public void dogJson(final String... parms) {
		Dog dog = new Dog();

		if ((parms != null) && (parms.length > 0)) {
			dog.setName(parms[0]);

			if (parms.length > 1) {
				dog.setBreed(parms[1]);
			}
			if (parms.length > 2) {
				dog.setAge(GetterUtil.getInteger(parms[2]));
			}
			if (parms.length > 3) {
				dog.setLikesPigsEars(GetterUtil.getBoolean(parms[3]));
			}
		}

		System.out.println(mapping.petToJson(dog));
	}

	@Descriptor("Show cat JSON, name, breed, age, treats")
	public void catJson(final String... parms) {
		Cat cat = new Cat();

		if ((parms != null) && (parms.length > 0)) {
			cat.setName(parms[0]);

			if (parms.length > 1) {
				cat.setBreed(parms[1]);
			}
			if (parms.length > 2) {
				cat.setAge(GetterUtil.getInteger(parms[2]));
			}
			if (parms.length > 3) {
				cat.setFavoriteTreat(parms[3]);
			}
		}

		System.out.println(mapping.petToJson(cat));
	}

	@Descriptor("Create dog from json.")
	public void dog(final String dogJson) {
		Dog dog = (Dog) mapping.parsePet(dogJson);

		if (dog != null) {
			System.out.println(dog.toString());

			return;
		}

		System.out.println("No dog.");
	}

	@Descriptor("Create cat from json.")
	public void cat(final String catJson) {
		Cat cat = (Cat) mapping.parsePet(catJson);

		if (cat != null) {
			System.out.println(cat.toString());

			return;
		}

		System.out.println("No cat.");
	}

	@Reference(unbind = "-")
	protected void setMapping(final Mapping mapping) {
		this.mapping = mapping;
	}

	private static final Log _log = LogFactoryUtil.getLog(JacksonCommand.class);
}
