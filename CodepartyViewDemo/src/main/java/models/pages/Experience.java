package models.pages;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.UUID;

public class Experience {

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	private String id;
	private String companyID;
	private String jobTitle;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	private String description;
	
	public Experience(String id, String companyID, String jobTitle, GregorianCalendar startDate, 
			GregorianCalendar endDate, String description) {
		
		this.id = id;
		this.companyID = companyID;
		this.jobTitle = jobTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		
	}
	
	public Experience() {
		this.id = UUID.randomUUID().toString();
		this.companyID = "";
		this.jobTitle = "Software Engineer";
		this.startDate = new GregorianCalendar();
		this.endDate = new GregorianCalendar();
		this.description = "Man";
	}
	
	public String getId() {
		return id;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyID, description, endDate, id, jobTitle, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Experience other = (Experience) obj;
		return Objects.equals(companyID, other.companyID) && Objects.equals(description, other.description)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(id, other.id)
				&& Objects.equals(jobTitle, other.jobTitle) && Objects.equals(startDate, other.startDate);
	}
}
