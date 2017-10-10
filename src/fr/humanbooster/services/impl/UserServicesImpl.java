package fr.humanbooster.services.impl;

import java.util.Calendar;
import java.util.Date;

import fr.humanbooster.ideas.Alert;
import fr.humanbooster.ideas.Answer;
import fr.humanbooster.ideas.Eval;
import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.ideas.Survey;
import fr.humanbooster.ideas.Vote;
import fr.humanbooster.services.UserServices;
import fr.humanbooster.users.User;

public class UserServicesImpl implements UserServices {

	@Override
	public void voteForIdea(User user, Idea idea, Eval eval) {
		Vote vote = new Vote(user, idea, eval);
		if (!user.containsVote(vote)) {
			user.addVote(vote);
			idea.voteForIdea(vote);
		} else {
			System.out.println(user.getUsername() + " a déjà voté pour " + idea.getTitle() + ".");
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

	@Override
	public Alert reportPost(User user, Post post, String alertMessage) {
		Alert alert = new Alert();
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		alert.setDate(date);
		alert.setActive(true);
		alert.setMember(user);
		alert.setPost(post);
		
		return alert;
		// TODO Auto-generated method stub
		
	}

}