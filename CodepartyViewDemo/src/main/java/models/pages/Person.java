package models.pages;
import java.util.ArrayList;
import java.util.Objects;

public class Person extends Profile {

	private static final Class<?>[] ALLOWED_LINKS = {Person.class, Skill.class, Project.class};
	private Experience currentCompany;
	private ArrayList<Experience> experiences = new ArrayList<Experience>();
	private PersonType type;
	
	
	public Person(String id) {
		super(id);
		links.put(Person.class, new ArrayList<String>());
		links.put(Skill.class, new ArrayList<String>());
		links.put(Project.class, new ArrayList<String>());
		// TODO Auto-generated constructor stub
	}
	
	public Person() {
		super();
		currentCompany = new Experience();
		type = PersonType.BASE;
		links.put(Person.class, new ArrayList<String>());
		links.put(Skill.class, new ArrayList<String>());
		links.put(Project.class, new ArrayList<String>());
	}

	public Experience getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(Experience currentCompany) {
		this.currentCompany = currentCompany;
	}
	
	public static Class<?>[] getAllowedLinks() {
		return ALLOWED_LINKS;
	}
	
	/**
	 * @return the experiences
	 */
	public ArrayList<Experience> getExperiences() {
		return experiences;
	}

	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}

	public void addExperience(Experience experience) {
		experiences.add(experience);
	}
	
	public void removeExperience(Experience experience) {
		experiences.remove(experience);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(currentCompany, experiences, type);
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
		Person other = (Person) obj;
		return Objects.equals(currentCompany, other.currentCompany) && Objects.equals(experiences, other.experiences)
				&& type == other.type;
	}

}
