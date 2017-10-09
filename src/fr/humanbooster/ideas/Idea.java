package fr.humanbooster.ideas;

import java.util.Calendar;
import java.util.Date;

import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public class Idea extends Post {

	private int top;
	private int flop;

	public Idea() {
		super();
		System.out.println("Création d'une nouvelle idée.");
		top = 0;
		flop = 0;
	}

	public Idea(Member author, String title, String description) {
		super(author, title, description);
		top = 0;
		flop = 0;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getFlop() {
		return flop;
	}

	public void setFlop(int flop) {
		this.flop = flop;
	}

	public Date getExpiracyDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(super.getDate());
		c.add(Calendar.DATE, 7);
		return c.getTime();
	}

	// méthode pour voter pour une idée.
	public void voteForIdea(User user, String vote) {
		Vote v = new Vote();
		Calendar c = Calendar.getInstance();
		if (this.getExpiracyDate().after(c.getTime())) {
			if (!v.getVotes().contains(this)) {
				if (vote.equals("top")) {
					top++;
					v.voteFor(this);;
				} else if (vote.equals("flop")) {
					flop++;
					v.voteFor(this);;
				} else
					System.out.println("Vote incorrect, veuillez saisir top ou flop");
			} else
				System.out.println("Vous avez déjà voté pour cette idée.");
		} else
			System.out.println("Vous avez dépassé la date limite pour voter pour cette idée");
	}

	@Override
	public String toString() {
		return "\n< IDÉE > \n" + super.toString() + "\nCommentaires :\n" + super.getComment() + "\n\nTop : " + top
				+ ", Flop : " + flop + "\n";
	}

}
