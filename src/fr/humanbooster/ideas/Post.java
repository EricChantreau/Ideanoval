package fr.humanbooster.ideas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.humanbooster.users.Member;

public abstract class Post {
	private String author;
	private String title;
	private String description;
	private boolean isActive;
	private Date date;
	private List<Comment> comment;

	public Post() {
		super();
		this.author = null;
		this.title = null;
		this.description = null;
		this.isActive = true;
		this.date = Calendar.getInstance().getTime();
		this.comment = new ArrayList<Comment>();
	}

	public Post(Member member, String title, String description) {
		super();
		this.author = member.getUsername();
		this.title = title;
		this.description = description;
		this.isActive = true;
		this.date = Calendar.getInstance().getTime();
		this.comment = new ArrayList<Comment>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void addComment(Comment comment) {
		this.comment.add(comment);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		return "\nPar " + author + " le " + sdf.format(date) + " à " + time.format(date) + "\n\nIdée : " + title + "\n\n" + description + "\n\n(Affichage : "
				+ isActive + ")\n";
	}

}
