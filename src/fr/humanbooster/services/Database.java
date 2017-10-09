package fr.humanbooster.services;

import java.util.List;

import fr.humanbooster.ideas.Category;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.users.User;

public interface Database {

	public List<User> getUsers();

	public User getUser(String username);

	public void addUser(User user);

	public List<Post> getPosts();
	
	public List<Category> getCategories();
	
	public void addCategory(Category category);
}
