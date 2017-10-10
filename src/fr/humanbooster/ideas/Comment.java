package fr.humanbooster.ideas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import fr.humanbooster.users.Member;

public class Comment {
	private String message;
	private String author;
	private Date date;

	public Comment(Member member, String message) {
		super();
		this.message = message;
		this.author = member.getUsername();
		this.date = Calendar.getInstance().getTime();
	}

	public String getMessage() {
		return message;
	}

	public String getAuthor() {
		return author;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		return "Le " + sdf.format(date) + " à " + time.format(date) + " " + author + " a écrit :\n « " + message + " »\n";
	}

}
