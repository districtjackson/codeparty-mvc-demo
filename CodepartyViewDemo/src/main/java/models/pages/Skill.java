package models.pages;

import java.util.Objects;

public class Skill extends Profile {

	private static final Class<?>[] ALLOWED_LINKS = {Person.class, Project.class, Skill.class, News.class};
	private String tagline;
	
	public Skill(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public Skill() {
		super();
		tagline = "here I am. Rock me like a hurricane";
	}
	
	public static Class<?>[] getAllowedLinks() {
		return ALLOWED_LINKS;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(tagline);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return Objects.equals(tagline, other.tagline);
	}
}
