package fr.humanbooster.ideas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public class Survey extends Post {
	private List<Option> options = new ArrayList<Option>();
	private int duration;

	public Survey() {
		super();
		System.out.println("Création d'un nouveau sondage.");
	}

	public Survey(Member author, String title, String description, List<Option> options, int duration) {
		super(author, title, description);
		this.options = options;
		this.duration = duration;
	}

	public Survey(Member author, String title, String description, int duration) {
		super(author, title, description);
		this.duration = duration;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getExpiracyDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(super.getDate());
		c.add(Calendar.DATE, duration);
		return c.getTime();
	}

	public void getUserVote (User user, int rangOption) {
		Vote v = user.getVotes();
		if ((rangOption >= 0) && (rangOption <= options.size()) && (!v.getVotes().contains(this))) {
			options.get(rangOption).applyUserVote();
			v.voteFor(this);
		} else if (v.getVotes().contains(this)){
			System.out.println("Vous avez déjà voté pour cette idée.");
		} else {
			System.out.println("Vote incorrect, vous devez saisir un nombre compris entre 0 et " + options.size() + ".");
		}
	}
	
	public void addUserOption (String option) {
		options.add(new Option(option));
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy");
		return "\n< SONDAGE > \n" + super.toString() + "\n" + "Consultation ouverte jusqu'au "
				+ sdf.format(getExpiracyDate()) + "\n" + optionsToString() + "\nCommentaires :\n" + super.getComment()
				+ "\n";
	}

	public String optionsToString() {
		int i = 1;
		String option = "";
		for (Option opt: options) {
			option = option.concat(String.valueOf(i)).concat(". ").concat(opt.toString());
			i++;
		}
		return option;
	}

}
