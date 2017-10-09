package fr.humanbooster.services;

import fr.humanbooster.users.User;

public interface LoginServices {
	public boolean register(User user);

	public User connect(String login, String password);
}
