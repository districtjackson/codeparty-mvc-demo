package models;

import javafx.scene.layout.BorderPane;

public interface ViewTransitionModelInterface {
	public void setMainView(BorderPane mainView);
	public void showLogin();
	public void showUser(String id);
	public void showHome(String id);
}
