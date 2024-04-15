package models.pages;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.UUID;

public class JobPosting extends Page {

	/**
	 * @param company the company to set
	 */
	public void setCompany(String companyID) {
		this.companyID = companyID;
	}

	private static final Class<?>[] ALLOWED_LINKS = {Skill.class};
	private String companyID;
	private String contactID;
	private String jobName;
	private String body;
	private GregorianCalendar datePosted;
	private GregorianCalendar expiryDate;
	
	public JobPosting(String id, String companyID) {
		super(id);
		this.companyID = companyID;
		// TODO Auto-generated constructor stub
		links.put(Skill.class, new ArrayList<String>());
	}
	
	public JobPosting() {
		super(UUID.randomUUID().toString());
		this.companyID = UUID.randomUUID().toString();
		this.contactID = UUID.randomUUID().toString();
		this.jobName = "Developer";
		this.jobName = "You will do stuff";
		this.datePosted = new GregorianCalendar();
		this.expiryDate = new GregorianCalendar();
		// TODO Auto-generated constructor stub
		links.put(Skill.class, new ArrayList<String>());
	}
	
	public static Class<?>[] getAllowedLinks() {
		return ALLOWED_LINKS;
	}

	public String getCompany() {
		return companyID;
	}

	public String getContact() {
		return contactID;
	}

	public void setContact(String contactID) {
		this.contactID = contactID;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public GregorianCalendar getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(GregorianCalendar datePosted) {
		this.datePosted = datePosted;
	}

	public GregorianCalendar getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(GregorianCalendar expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(body, companyID, contactID, datePosted, expiryDate, jobName);
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
		JobPosting other = (JobPosting) obj;
		return Objects.equals(body, other.body) && Objects.equals(companyID, other.companyID)
				&& Objects.equals(contactID, other.contactID) && Objects.equals(datePosted, other.datePosted)
				&& Objects.equals(expiryDate, other.expiryDate) && Objects.equals(jobName, other.jobName);
	}


}
