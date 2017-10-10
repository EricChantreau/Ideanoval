package fr.humanbooster.ideas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import fr.humanbooster.users.Member;

public class Idea extends Post implements Comparator<Idea> {

	private int top;
	private int flop;
	private List<Vote> votes = new ArrayList<Vote>();

	public Idea() {
		super();
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

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public Date getExpiracyDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(super.getDate());
		c.add(Calendar.DATE, 7);
		return c.getTime();
	}

	// méthode pour voter pour une idée.
	public void voteForIdea(Vote vote) {
		Calendar c = Calendar.getInstance();
		boolean canBeVoted = this.getExpiracyDate().after(c.getTime());
		if (canBeVoted) {
			switch (vote.getEval()) {
			case TOP:
				top++;
				break;
			case FLOP:
				flop++;
				break;
			default:
				break;
			};
			this.votes.add(vote);
		} else
			System.out.println("Vous avez dépassé la date limite pour voter pour cette idée");
	}

	@Override
	public String toString() {
		if (this.isActive()) {
			return "\n< IDÉE > \n" + super.toString() + "\nCommentaires :\n" + super.getComment() + "\n\nTop : " + top
				+ ", Flop : " + flop + "\n";
		}
	return "Ce message a été désactivé.\n";
	}

	@Override
	public int compare(Idea id1, Idea id2) {
		int topId1 = id1.getTop();
		int topId2 = id2.getTop();
		if (topId1 == topId2) {
			return 0;
		} else if (topId1 < topId2) {
			return 1;
		}else if (topId1 > topId2) {
			return -1;
		}
		return 2;
	}

}
