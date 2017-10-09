package fr.humanbooster.services;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.ideas.Answer;
import fr.humanbooster.ideas.Eval;
import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Survey;
import fr.humanbooster.ideas.Vote;
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
	public void voteForIdea(User user, Idea idea, Eval eval) {
		Vote vote = new Vote(user, idea, eval);
		if ((!user.getVotes().contains(vote)) && (!idea.getVotes().contains(vote))) {
			user.getVotes().add(vote);
			idea.getVotes().add(vote);
			idea.voteForIdea(vote);
		} else {
			System.out.println("Vous avez déjà voté pour cette idée.");
		}
	}

	@Override
	public void answerToSurvey(User user, Survey survey, int optionIndex) {
		Answer answer = new Answer(user, survey, optionIndex);
		if (user.containsAnswer(answer)) {
			System.out.println(user.getUsername() + " a déjà voté pour " + survey.getTitle() + ".");
		} else {
			user.addAnswer(answer);
			survey.addAnswer(answer);
		}
	}

}