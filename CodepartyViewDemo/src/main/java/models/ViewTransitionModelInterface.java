package models;

import java.util.ArrayList;
import java.util.Map;

import javafx.scene.layout.BorderPane;
import models.pages.Page;
import models.pages.Person;

public interface ViewTransitionModelInterface {
	public void setFakeData(Map<String, Page> fakeData);
	public void setMainView(BorderPane mainView);
	public void setCurrentUserID(String id);
	public void showLogin();
	public void showCurrentUserFromLogin();
	public void showCurrentUser();
	public void showUser(String id);
	public void showHome();
	public void showCompany(String id);
	public void showSkill(String id);
	public void showJobPosting(String id);
	public void showList(ListModel model);
	public Page getObject(String id);
	public Person getCurrentUser();
	public ArrayList<Page> getAllObjectsOfType(Class<?> type);
}
