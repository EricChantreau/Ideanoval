package fr.humanbooster.users;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.ideas.Answer;
import fr.humanbooster.ideas.Vote;

public abstract class User {

	private String email;
	private String password;
	private String username;
	private List<Vote> votes;
	private List<Answer> answers;

	public User(String email, String password, String username) {
		this.email = email;
		this.password = password;
		this.username = username;
		this.votes = new ArrayList<>();
		this.answers = new ArrayList<>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public boolean containsAnswer(Answer answer) {
		for (Answer myAnswer : answers) {
			if (myAnswer.getUser().equals(answer.getUser()) && myAnswer.getSurvey().equals(answer.getSurvey()))
				return true;
		}
		return false;
	}

	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}

	public boolean containsVote(Vote vote) {
		for (Vote myVote : votes) {
			if (myVote.getUser().equals(vote.getUser()) && myVote.getIdea().equals(vote.getIdea())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String pwd ="";
		for (int i = 0; i < password.length(); i++) {
			pwd.concat("*");
		}
		return "Utilisateur : " + username + "\n email : " + email + "\n Mot de passe : " + pwd + "]";
	}
}