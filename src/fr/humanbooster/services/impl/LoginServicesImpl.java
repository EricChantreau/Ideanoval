package fr.humanbooster.services.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.humanbooster.services.Database;
import fr.humanbooster.services.LoginServices;
import fr.humanbooster.users.User;

public class LoginServicesImpl implements LoginServices {

	private List<User> users;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public LoginServicesImpl() {
		Database db = new DatabaseImpl();
		users = db.getUsers();
	}

	@Override
	public boolean register(User user) {
		if (checkEmail(user)) {
			if (containsUser(user)) {
				return false;
			}
			users.add(user);
			return true;
		}
		System.out.println("Email non valide.");
		return false;
	}

	private boolean checkEmail(User user) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
		return matcher.find();
	}

	private boolean containsUser(User user) {
		for (User registeredUser : users) {
			if (registeredUser.getEmail().equals(user.getEmail())) {
				System.out.println("Login déjà utilisé.");
				return true;
			}
			if (registeredUser.getUsername().equals(user.getUsername())) {
				System.out.println("Username déjà utilisé.");
				return true;
			}
		}
		return false;
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
