package fr.humanbooster.ideas;

import fr.humanbooster.users.User;

public class Vote {
	private User user;
	private Idea idea;
	private Eval eval;

	public Vote(User user, Idea idea, Eval eval) {
		super();
		this.user = user;
		this.idea = idea;
		this.eval = eval;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public Eval getEval() {
		return eval;
	}

	public void setEval(Eval eval) {
		this.eval = eval;
	}

	@Override
	public String toString() {
		return "Vote [user=" + user + ", post=" + idea + ", eval=" + eval + "]";
	}
}