package fr.humanbooster.test;

import java.util.List;

import fr.humanbooster.ideas.Category;
import fr.humanbooster.ideas.Comment;
import fr.humanbooster.ideas.Eval;
import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Survey;
import fr.humanbooster.services.AdminServices;
import fr.humanbooster.services.Database;
import fr.humanbooster.services.MemberServices;
import fr.humanbooster.services.impl.AdminServicesImpl;
import fr.humanbooster.services.impl.DatabaseImpl;
import fr.humanbooster.services.impl.MemberServicesImpl;
import fr.humanbooster.services.impl.RankingImpl;
import fr.humanbooster.users.Administrator;
import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public class IdeaNovalTest {

	public static void main(String[] args) {
		Database data = DatabaseImpl.getInstance();
		AdminServices as = new AdminServicesImpl();
		MemberServices us = new MemberServicesImpl();

		List<User> users = data.getUsers();
		Member mb1 = (Member) users.get(0);

		List<Idea> ideas = data.getIdeas();
		Idea id1 = (Idea) ideas.get(0);

		List<Category> categories = data.getCategories();
		Category cat1 = categories.get(0);
		Category cat2 = categories.get(1);

		id1.setCategory(cat1);

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
		
		List<Survey> surveys = data.getSurveys();
		Survey sv1 = (Survey) surveys.get(0);

		us.answerToSurvey(mb1, sv1, 2);
		us.answerToSurvey(mb1, sv1, 1);

		us.answerToSurvey(mb3, sv1, 0);

		us.voteForIdea(mb2, id1, Eval.FLOP);
		us.voteForIdea(mb3, id1, Eval.TOP);
		us.voteForIdea(mb2, id1, Eval.FLOP);

		Administrator ad1 = new Administrator("rou@dou.dou", "lalala", "Roudoudou");
		data.addUser(ad1);

		RankingImpl rank = new RankingImpl();
		
		as.addCategory(new Category("Littérature"), categories);
//		as.disableComment(ct2);
//		as.disableMember(mb1);
		as.deleteCategory(cat2, categories);
//		as.disablePost(sv1);
//		as.disableComment(ct1);
//		as.customizeCategory(cat2);

		List<User> mostIdeaUsers = data.getMostIdeaUsers();
		/* AFFICHAGE */
//		System.out.println(posts);
//		System.out.println(categories);

		System.out.println("\nTop ideas :");
		int count = 1;
		Idea[] topIdeas = rank.topRanking(ideas);
		for (Idea idea : topIdeas) {
			System.out.println(count + ". " + idea.getTitle() + " (" + idea.getTop() + ")");
			count++;
		}
		
		System.out.println("\nTop posters :");
		count = 1;
		for (User user : mostIdeaUsers) {
			System.out.println(count + ". " + user.getUsername());
			count++;
		}

	}
}
