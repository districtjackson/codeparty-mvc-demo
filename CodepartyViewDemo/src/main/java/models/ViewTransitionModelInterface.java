package models;

import javafx.scene.layout.BorderPane;

public interface ViewTransitionModelInterface {
	public void setMainView(BorderPane mainView);
	public void setCurrentUserID(String id);
	public void showLogin();
	public void showCurrentUserFromLogin();
	public void showCurrentUser();
	public void showUser(String id);
	public void showHome();
}
