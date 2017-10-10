package fr.humanbooster.services;

import fr.humanbooster.ideas.Alert;
import fr.humanbooster.ideas.Eval;
import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.ideas.Survey;
import fr.humanbooster.users.Member;

public interface MemberServices {
	public void voteForIdea(Member member, Idea idea, Eval eval);

	public void answerToSurvey(Member member, Survey survey, int optionIndex);

	public Alert reportPost(Member member, Post post, String alert);
}