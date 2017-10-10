package fr.humanbooster.services;

import java.util.List;

import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.users.Member;

public interface Ranking {
	public Idea[] topRanking(List<Idea> ideas);
	public Post[] buzzRanking(List<Post> posts);
	public Member[] brainsRanking(List<Member> members);
}
