package fr.humanbooster.services.impl;

import java.util.List;

import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.services.Ranking;
import fr.humanbooster.users.Member;

public class RankingImpl implements Ranking {

	@Override
	public Idea[] topRanking(List<Idea> ideas) {
		Idea[] tops = new Idea[3];
		ideas.sort(new Idea());
		for (int i = 0; i < tops.length; i++) {
			tops[i] = ideas.get(i);
		}
		return tops;
	}

	@Override
	public Post[] buzzRanking(List<Post> posts) {
		Post[] buzz = new Post[3];
		for (int i = 0; i < buzz.length; i++) {
			for (int j = 0; j < posts.size(); j++) {
				if (buzz[i] == null) {
					buzz[i] = posts.get(j);
					posts.remove(posts.get(j));
				} else if (buzz[i].getComment().size() < posts.get(j).getComment().size()) {
					buzz[i] = posts.get(j);
					posts.remove(posts.get(j));
				} 
			}
		}
		
		return buzz;
	}

	@Override
	public Member[] brainsRanking(List<Member> members) {
		Member[] brains = new Member[3];
		
		return brains;
	}

}
