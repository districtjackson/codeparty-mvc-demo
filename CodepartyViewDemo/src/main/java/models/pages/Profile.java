package models.pages;

import java.util.Objects;

public abstract class Profile extends Page {

	
	public Profile(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public Profile() {
		super();
		bio = "Hey, hi, I'm the problem its me";
	}

	private String bio;


	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bio);
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
		Profile other = (Profile) obj;
		return Objects.equals(bio, other.bio);
	}
	


}
