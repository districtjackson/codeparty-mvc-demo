/**
 * 
 */
package models.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * 
 */
public abstract class Page {

	private String id;
	private String name;
	
	private ArrayList<String> usersCanEdit = new ArrayList<String>();
	private ArrayList<String> usersCanView = new ArrayList<String>();
	
	private Map<Class<?>, ArrayList<Page>> links = new HashMap<>();

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(Map<Class<?>, ArrayList<Page>> links) {
		this.links = links;
	}


	/**
	 * @param id
	 * @param owner
	 * @param current_user
	 */
	public Page(String id) {
		super();
		this.id = id;
	}
	
	public Page() {
		super();
		this.id = UUID.randomUUID().toString();
	}
	
	/**
	 * @return the usersCanEdit
	 */
	public ArrayList<String> getUsersCanEdit() {
		return usersCanEdit;
	}

	/**
	 * @param usersCanEdit the usersCanEdit to set
	 */
	public void setUsersCanEdit(ArrayList<String> usersCanEdit) {
		this.usersCanEdit = usersCanEdit;
	}

	/**
	 * @return the usersCanView
	 */
	public ArrayList<String> getUsersCanView() {
		return usersCanView;
	}

	/**
	 * @param usersCanView the usersCanView to set
	 */
	public void setUsersCanView(ArrayList<String> usersCanView) {
		this.usersCanView = usersCanView;
	}

	public String getID() {
		return id;
	}
	
	public Map<Class<?>, ArrayList<Page>> getLinks(){
		return links;
	}
	
	public void addLink(Class<?> type, Page page) {
		links.get(type).add(page);
	}
	
	public void removeLink(Class<?> type, Page page) {
		links.get(type).remove(page);
	}
	
	public boolean canEdit(String ID) {
		if(usersCanEdit.size() == 0) {
			return true;
		}
		
		for (String editID : usersCanEdit) {
			if(editID.equals(ID)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean canView(String ID) {
		if(usersCanView.size() == 0) {
			return true;
		}
		
		for (String viewID : usersCanView) {
			if(viewID.equals(ID)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void addEditor(String ID) {
		usersCanEdit.add(ID);
	}
	
	public void removeEditor(String ID) {
		usersCanEdit.remove(ID);
	}
	
	public void addViewer(String ID) {
		usersCanView.add(ID);
	}
	
	public void removeViewer(String ID) {
		usersCanView.remove(ID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, links, usersCanEdit, usersCanView);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		return Objects.equals(id, other.id) && Objects.equals(links, other.links)
				&& Objects.equals(usersCanEdit, other.usersCanEdit) && Objects.equals(usersCanView, other.usersCanView);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
