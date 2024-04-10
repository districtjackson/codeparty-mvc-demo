package models.pages;
import java.util.GregorianCalendar;
import java.util.UUID;

public class Request {

	private String ID;
	private String message;
	private String personID;
	private GregorianCalendar dateCreated;
	
	public Request(String ID, String personID, String message, GregorianCalendar dateCreated) {
		this.ID = ID;
		this.message = message;
		this.personID = personID;
		this.dateCreated = dateCreated;
	}
	
	public Request() {
		this.ID = UUID.randomUUID().toString();
		this.message = "Mic check 1212";
		this.personID = UUID.randomUUID().toString();
		this.dateCreated = new GregorianCalendar();
	}

	public String getID() {
		return ID;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the dateCreated
	 */
	public GregorianCalendar getDateCreated() {
		return dateCreated;
	}

	/**
	 * @return the personID
	 */
	public String getPersonID() {
		return personID;
	}

	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(String personID) {
		this.personID = personID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(GregorianCalendar dateCreated) {
		this.dateCreated = dateCreated;
	}
}
