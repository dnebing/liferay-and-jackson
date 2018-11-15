package com.dnebinger.jackson.pojo.animal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@JsonTypeName("dog")
public class Dog extends Pet {
	private boolean likesPigsEars;
	private LocalDate lastWalked;

	@Override
	public String toString() {
		ToStringBuilder tsb =  new ToStringBuilder(this, CustomToStringStyle.CUSTOM_TO_STRING_STYLE)
				.append("likesPigsEars", likesPigsEars)
				.append("breed", getBreed())
				.append("name", getName())
				.append("age", getAge());

		if (lastWalked != null) {
			tsb.append("lastWalked", lastWalked.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
		}

		return tsb
				.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Dog)) return false;

		Dog dog = (Dog) o;

		return new EqualsBuilder()
				.appendSuper(super.equals(o))
				.append(likesPigsEars, dog.likesPigsEars)
				.append(lastWalked, dog.lastWalked)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.appendSuper(super.hashCode())
				.append(likesPigsEars)
				.append(lastWalked)
				.toHashCode();
	}

	@JsonProperty("ears")
	public boolean isLikesPigsEars() {
		return likesPigsEars;
	}

	@JsonProperty("ears")
	public void setLikesPigsEars(boolean likesPigsEars) {
		this.likesPigsEars = likesPigsEars;
	}

	@JsonProperty("walked")
	public LocalDate getLastWalked() {
		return lastWalked;
	}

	@JsonProperty("walked")
	public void setLastWalked(LocalDate lastWalked) {
		this.lastWalked = lastWalked;
	}
}
