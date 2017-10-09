package fr.humanbooster.ideas;

import java.util.HashSet;
import java.util.Set;

public class Vote {
	private Set<Post> votes = new HashSet<>();

	public Vote() {
		super();
	}

	public Vote(Set<Post> votes) {
		super();
		this.votes = votes;
	}

	public Set<Post> getVotes() {
		return votes;
	}

	public void setVotes(Set<Post> votes) {
		this.votes = votes;
	}

	public void voteFor (Post post) {
			this.votes.add(post);
	}
	
}