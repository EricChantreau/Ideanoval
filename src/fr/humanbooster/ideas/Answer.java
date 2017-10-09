package fr.humanbooster.ideas;

import fr.humanbooster.users.User;

public class Answer {

	private User user;
	private Survey survey;
	private int optionIndex;

	public Answer(User user, Survey survey, int optionIndex) {
		this.user = user;
		this.survey = survey;
		this.optionIndex = optionIndex;
	}

	public User getUser() {
		return user;
	}

	public Survey getSurvey() {
		return survey;
	}

	public int getOptionIndex() {
		return optionIndex;
	}

	@Override
	public String toString() {
		return "Answer [user=" + user + ", survey=" + survey + ", optionIndex=" + optionIndex + "]";
	}
}
