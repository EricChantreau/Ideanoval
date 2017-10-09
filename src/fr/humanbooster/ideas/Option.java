package fr.humanbooster.ideas;

public class Option {
	private String description;
	private int vote = 0;
	
	public Option(String description) {
		super();
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public void applyUserVote () {
		vote++;
	}
	
	public String toString() {
		String option = description + " (" + vote + " votes)\n";
		return option;
	}
}
