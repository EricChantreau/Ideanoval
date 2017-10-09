package fr.humanbooster.services;

import fr.humanbooster.ideas.Idea;
import fr.humanbooster.users.User;

public interface UserServices {
	public boolean register(User user);

	public User connect(String login, String password);

	public void voteForIdea(User user, Idea idea, String vote);
}