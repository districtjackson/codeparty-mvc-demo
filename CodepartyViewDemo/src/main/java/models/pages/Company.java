package models.pages;

import java.util.Objects;

public class Company extends Profile {

	private String tagline;
	private static final Class<?>[] ALLOWED_LINKS = {Person.class, Project.class, JobPosting.class, News.class};
	
	public Company(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public Company() {
		super();
		tagline = "We are good";
		// TODO Auto-generated constructor stub
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public static Class<?>[] getAllowedLinks() {
		return ALLOWED_LINKS;
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
		Company other = (Company) obj;
		return Objects.equals(tagline, other.tagline);
	}

}
