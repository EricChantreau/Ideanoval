package fr.humanbooster.services;

import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.users.Member;

public interface Ranking {
	public Idea[] topRanking();
	public Post[] buzzRanking();
	public Member[] brainsRanking();
}
