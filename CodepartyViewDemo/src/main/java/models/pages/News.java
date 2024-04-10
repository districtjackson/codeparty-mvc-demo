package models.pages;
import java.util.GregorianCalendar;
import java.util.UUID;

public class News extends Page {

	private static final Class<?>[] ALLOWED_LINKS = {Profile.class};
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String authorID) {
		this.authorID = authorID;
	}

	private String authorID;
	private String title;
	private String body;
	private GregorianCalendar date;
	
	public News(String id, String authorID) {
		super(id);
		this.authorID = authorID;
		// TODO Auto-generated constructor stub
	}
	
	public News() {
		super(UUID.randomUUID().toString());
		title = "Dasd";
		body = "asfasf";
		date = new GregorianCalendar();
	}

	public static Class<?>[] getAllowedLinks() {
		return ALLOWED_LINKS;
	}

	public String getAuthor() {
		return authorID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

}
