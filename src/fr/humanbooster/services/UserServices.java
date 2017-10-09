package fr.humanbooster.services;

import fr.humanbooster.ideas.Eval;
import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Survey;
import fr.humanbooster.users.User;

public interface UserServices {
	public void voteForIdea(User user, Idea idea, Eval eval);

	public void answerToSurvey(User user, Survey survey, int optionIndex);
}