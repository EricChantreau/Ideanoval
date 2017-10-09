package fr.humanbooster.services;

import java.util.List;

import fr.humanbooster.users.User;

public class LoginServicesImpl implements LoginServices {

	private List<User> users;

	public LoginServicesImpl() {
		Database db = new DatabaseImpl();
		users = db.getUsers();
	}

	@Override
	public boolean register(User user) {
		if (users.contains(user))
			return false;

		users.add(user);
		return true;
	}

	@Override
	public User connect(String login, String password) {
		for (User user : users) {
			if (user.getEmail().equals(login) && user.getPassword().equals(password))
				return user;
		}

		return null;
	}

}
