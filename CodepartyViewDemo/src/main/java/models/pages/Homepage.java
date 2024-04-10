package models.pages;
import java.util.ArrayList;

public class Homepage extends Page {

	private static final Class<?>[] ALLOWED_LINKS = {News.class, JobPosting.class};
	private ArrayList<Request> requests = new ArrayList<Request>();

	/**
	 * @param requests the requests to set
	 */
	public void setRequests(ArrayList<Request> requests) {
		this.requests = requests;
	}

	public Homepage(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public static Class<?>[] getAllowedLinks() {
		return ALLOWED_LINKS;
	}

	public ArrayList<Request> getRequests() {
		return requests;
	}
	
	public void addRequest(Request request) {
		requests.add(request);
	}
	
	public void removeRequest(Request request) {
		requests.remove(request);
	}
	
}
