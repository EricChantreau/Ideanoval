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
	public Post[] buzzRanking(List<Idea> ideas) {
		Idea[] buzz = new Idea[3];
		
		return buzz;
	}

	@Override
	public Member[] brainsRanking(List<Member> members) {
		Member[] brains = new Member[3];
		
		return brains;
	}

}
