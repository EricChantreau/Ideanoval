package fr.humanbooster.ideas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.humanbooster.users.Member;

public class Survey extends Post {
	private List<Option> options = new ArrayList<Option>();
	private int duration;
	private List<Answer> answers;

	public Survey() {
		super();
	}

	public Survey(Member author, String title, String description, List<Option> options, int duration) {
		super(author, title, description);
		this.options = options;
		this.duration = duration;
	}

	public Survey(Member author, String title, String description, int duration) {
		super(author, title, description);
		this.duration = duration;
		this.answers = new ArrayList<>();
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void addAnswer(Answer answer) {
		this.answers.add(answer);
		this.options.get(answer.getOptionIndex()).applyUserVote();
	}

	public Date getExpiracyDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(super.getDate());
		c.add(Calendar.DATE, duration);
		return c.getTime();
	}

	public void addUserOption(String option) {
		options.add(new Option(option));
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy");
		return "\n< SONDAGE > \n" + super.toString() + "\n" + "Consultation ouverte jusqu'au "
				+ sdf.format(getExpiracyDate()) + "\n" + optionsToString() + "\nCommentaires :\n" + super.getComment()
				+ "\n";
	}

	private String optionsToString() {
		int i = 1;
		String option = "";
		for (Option opt : options) {
			option = option.concat(String.valueOf(i)).concat(". ").concat(opt.toString());
			i++;
		}
		return option;
	}

}
