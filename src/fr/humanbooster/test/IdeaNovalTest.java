package fr.humanbooster.test;

import java.util.List;

import fr.humanbooster.ideas.Comment;
import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.ideas.Survey;
import fr.humanbooster.services.Database;
import fr.humanbooster.services.DatabaseImpl;
import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public class IdeaNovalTest {

	public static void main(String[] args) {
		Database data = new DatabaseImpl();

		List<User> users = data.getUsers();
		Member mb1 = (Member) users.get(0);

		List<Post> posts = data.getPosts();
		Idea id1 = (Idea) posts.get(0);

		Comment ct1 = new Comment(mb1, "First!");
		id1.addComment(ct1);

		Member mb2 = (Member) users.get(1);
		Comment ct2 = new Comment(mb2, "Vivent les éléphants !");
		id1.addComment(ct2);

		Member mb3 = (Member) users.get(3);
		Comment ct3 = new Comment(mb3, "Pour l'instant, ça marche.");
		id1.addComment(ct3);

		data.addUser(new Member("charles@groupe.hb", "titi&toto", "Charles"));
		Comment ct4 = new Comment((Member) users.get(4), "Damned! On a usurpé mon identité !");
		id1.addComment(ct4);
		
		Survey sv1 = (Survey) posts.get(2);
		sv1.getOptions().get(2).applyUserVote();
		
		/* AFFICHAGE */
		System.out.println(posts);

	}
}
