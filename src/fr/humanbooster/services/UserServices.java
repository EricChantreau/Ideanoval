package fr.humanbooster.services;

import fr.humanbooster.users.*;

public interface UserServices {
	public boolean register(User user);

	public User connect(String login, String password);
}