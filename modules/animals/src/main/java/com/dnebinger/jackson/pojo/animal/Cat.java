package com.dnebinger.jackson.pojo.animal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@JsonTypeName("cat")
public class Cat extends Pet {
	private String favoriteTreat;

	@Override
	public String toString() {
		return new ToStringBuilder(this, CustomToStringStyle.CUSTOM_TO_STRING_STYLE)
				.append("favoriteTreat", favoriteTreat)
				.append("breed", getBreed())
				.append("name", getName())
				.append("age", getAge())
				.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Cat)) return false;

		Cat cat = (Cat) o;

		return new EqualsBuilder()
				.appendSuper(super.equals(o))
				.append(favoriteTreat, cat.favoriteTreat)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.appendSuper(super.hashCode())
				.append(favoriteTreat)
				.toHashCode();
	}

	@JsonProperty("treat")
	public String getFavoriteTreat() {
		return favoriteTreat;
	}

	@JsonProperty("treat")
	public void setFavoriteTreat(String favoriteTreat) {
		this.favoriteTreat = favoriteTreat;
	}
}
