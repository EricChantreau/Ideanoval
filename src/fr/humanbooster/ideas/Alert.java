package fr.humanbooster.ideas;

import java.util.Date;

import fr.humanbooster.users.Member;

public class Alert {
	
	//Parametres : membre, date déclenchement, post
	
	public Member member;
	public Date date;
	public Post post;
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
		return "Alert [member=" + member + ", date=" + date + ", post=" + post + "]";
	}
	

}
