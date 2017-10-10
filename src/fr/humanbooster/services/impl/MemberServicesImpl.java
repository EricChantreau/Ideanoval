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
import fr.humanbooster.services.MemberServices;
import fr.humanbooster.users.Member;

public class MemberServicesImpl implements MemberServices {

	@Override
	public void voteForIdea(Member member, Idea idea, Eval eval) {
		Vote vote = new Vote(member, idea, eval);
		if (!member.containsVote(vote)) {
			member.addVote(vote);
			idea.voteForIdea(vote);
		} else {
			System.out.println(member.getUsername() + " a déjà voté pour " + idea.getTitle() + ".");
		}
	}

	@Override
	public void answerToSurvey(Member member, Survey survey, int optionIndex) {
		Answer answer = new Answer(member, survey, optionIndex);
		if (member.containsAnswer(answer)) {
			System.out.println(member.getUsername() + " a déjà voté pour " + survey.getTitle() + ".");
		} else {
			member.addAnswer(answer);
			survey.addAnswer(answer);
		}
	}

	@Override
	public Alert reportPost(Member member, Post post, String alertMessage) {
		Alert alert = new Alert();
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		alert.setDate(date);
		alert.setActive(true);
		alert.setMember(member);
		alert.setPost(post);

		return alert;
	}

}