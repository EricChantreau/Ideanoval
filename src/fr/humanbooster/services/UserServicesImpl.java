package fr.humanbooster.services;

import fr.humanbooster.ideas.Answer;
import fr.humanbooster.ideas.Eval;
import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Survey;
import fr.humanbooster.ideas.Vote;
import fr.humanbooster.users.User;

public class UserServicesImpl implements UserServices {

	@Override
	public void voteForIdea(User user, Idea idea, Eval eval) {
		Vote vote = new Vote(user, idea, eval);
		if (!user.containsVote(vote)) {
			user.addVote(vote);
			idea.voteForIdea(vote);
		} else {
			System.out.println(user.getUsername() + " a d�j� vot� pour " + idea.getTitle() + ".");
		}
	}

	@Override
	public void answerToSurvey(User user, Survey survey, int optionIndex) {
		Answer answer = new Answer(user, survey, optionIndex);
		if (user.containsAnswer(answer)) {
			System.out.println(user.getUsername() + " a d�j� vot� pour " + survey.getTitle() + ".");
		} else {
			user.addAnswer(answer);
			survey.addAnswer(answer);
		}
	}

}