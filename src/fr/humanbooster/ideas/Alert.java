package fr.humanbooster.ideas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.humanbooster.users.Member;

public class Alert {

	// Parametres : membre, date déclenchement, post

	public Member member;
	public Date date;
	public Post post;
	public boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		DateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy");
		DateFormat time = new SimpleDateFormat("HH:mm:ss");
		return "Alerte (" + (isActive ? "activée" : "désactivée") + ") créée par " + member.getUsername() + " le "
				+ sdf.format(date) + " à " + time.format(date) + " concernant le post \"" + post.getTitle() + "\"";
	}

}
