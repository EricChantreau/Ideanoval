package fr.humanbooster.services;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.ideas.Idea;
import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public class UserServicesImpl implements UserServices {

	private List<User> users;

	public UserServicesImpl() {
		users = new ArrayList<>();
		users.add(new Member("echantreau", "password0", "eric c", true));
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

	@Override
	public void voteForIdea(User user, Idea idea, String vote) {
		// TODO Auto-generated method stub

	}

}