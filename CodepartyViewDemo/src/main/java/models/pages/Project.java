package models.pages;

import java.util.UUID;

public class Project extends Profile {

	private static final Class<?>[] ALLOWED_LINKS = {Person.class, Skill.class};
	private String tagline;
	private String repositoryLink;
	
	public Project(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public Project() {
		super(UUID.randomUUID().toString());
		tagline = "asdasd";
		repositoryLink = "Asafasf";
		// TODO Auto-generated constructor stub
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

	public String getRepositoryLink() {
		return repositoryLink;
	}

	public void setRepositoryLink(String repositoryLink) {
		this.repositoryLink = repositoryLink;
	}

}
