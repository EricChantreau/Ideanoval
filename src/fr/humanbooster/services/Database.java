package fr.humanbooster.services;

import java.util.List;

import fr.humanbooster.ideas.Alert;
import fr.humanbooster.ideas.Category;
import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Survey;
import fr.humanbooster.users.User;

public interface Database {

	public List<User> getUsers();

	public User getUser(String username);

	public void addUser(User user);

	public List<Idea> getIdeas();
	
	public List<Survey> getSurveys();

	public List<Category> getCategories();

	public void addCategory(Category category);

	public List<User> getMostIdeaUsers();
	
	public void addAlert(Alert alert);
	
	public List<Alert> getAlerts();

}
