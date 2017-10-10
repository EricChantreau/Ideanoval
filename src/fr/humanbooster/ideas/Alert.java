package fr.humanbooster.ideas;

import java.util.Date;
import fr.humanbooster.users.User;

public class Alert {
	
	//Parametres : membre, date déclenchement, post
	
	public User member;
	public Date date;
	public Post post;
	public boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public User getMember() {
		return member;
	}
	public void setMember(User member) {
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
		return "Alert [member=" + member + ", date=" + date + ", post=" + post + ", isActive=" + isActive + "]";
	}
	

}
