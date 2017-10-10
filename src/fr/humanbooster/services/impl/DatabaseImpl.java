package fr.humanbooster.services.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fr.humanbooster.ideas.Alert;
import fr.humanbooster.ideas.Category;
import fr.humanbooster.ideas.Comment;
import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Option;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.ideas.Survey;
import fr.humanbooster.services.Database;
import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public class DatabaseImpl implements Database {

	private static Database instance;

	public static Database getInstance() {
		if (instance == null) {
			instance = new DatabaseImpl();
		}
		return instance;
	}

	private List<User> users;
	private List<Idea> ideas;
	private List<Survey> surveys;
	private List<Category> categories;
	private List<Alert> alerts;

	private DatabaseImpl() {
		initUsers();
		initIdeas();
		initSurveys();
		initCategories();
		initAlerts();
	}

	private void initUsers() {
		users = new ArrayList<>();
		Member mb1 = new Member("marsu@pila.mi", "houba!houba!hop!", "Marsupilami");
		Member mb2 = new Member("bbr@lfan.fr", "azer*5kjhgf", "Babar");
		Member mb3 = new Member("echantreau", "password0", "eric c");
		Member mb4 = new Member("jduvivier@humanbooster.com", "pwd1234", "jduvivier");
		users.add(mb1);
		users.add(mb2);
		users.add(mb3);
		users.add(mb4);
	}

	private void initIdeas() {
		ideas = new ArrayList<>();
		Idea id1 = new Idea((Member) users.get(0), "Voici ma première idée",
				"Plus de frites à la cantine ! Plus de cours de Java avec Safia ! Moins d'examens à Human Booster !");
		id1.setTop(2);
		id1.setFlop(9);
		ideas.add(id1);
		Idea id2 = new Idea((Member) users.get(1), "Cacahuètes !", "Donnez-moi des cacachuètes ! :'(");
		id2.setTop(7);
		id2.setFlop(1);
		id2.addComment(new Comment((Member) users.get(1), "Et des bonnes, hein !"));
		id2.addComment(new Comment((Member) users.get(0), "Si je veux !!!"));
		id2.addComment(new Comment((Member) users.get(3), "Dans tes rêves, mon grand…"));
		ideas.add(id2);
		Idea id3 = new Idea((Member) users.get(2), "Best idea ever", "Chocolat pour tout le monde.");
		id3.setTop(5);
		id3.addComment(new Comment((Member) users.get(0), "First!"));
		ideas.add(id3);
		Idea id4 = new Idea((Member) users.get(1), "Bend the knee!", "C'est moi le roi !");
		id4.setTop(3);
		id4.setFlop(1);
		id4.addComment(new Comment((Member) users.get(0), "C'est ça."));
		id4.addComment(new Comment((Member) users.get(2), "Tu te calmes."));
		ideas.add(id4);
	}

	private void initSurveys() {
		surveys = new ArrayList<>();
		Survey sv1 = new Survey((Member) users.get(3), "Mon premier sondage", "Pour ou contre ?", 7);
		List<Option> optionsSv1 = new ArrayList<Option>();
		optionsSv1.add(new Option("Option 1"));
		optionsSv1.add(new Option("Option 2"));
		optionsSv1.add(new Option("Option 3"));
		sv1.setOptions(optionsSv1);
		surveys.add(sv1);
		Survey sv2 = new Survey((Member) users.get(1), "This is really awesome", "Who's the most awesome?", 2);
		List<Option> optionsSv2 = new ArrayList<Option>();
		optionsSv2.add(new Option("Charles"));
		optionsSv2.add(new Option("Éric"));
		optionsSv2.add(new Option("Julien"));
		sv2.setOptions(optionsSv2);
		sv2.addComment(new Comment((Member) users.get(0), "Y a pas photo…"));
		surveys.add(sv2);
		Survey sv3 = new Survey((Member) users.get(2), "Votre dernier mot…", "Qu'est-ce qu'un wqt ?", 2);
		List<Option> optionsSv3 = new ArrayList<Option>();
		optionsSv3.add(new Option("Un animal aquatique nocturne"));
		optionsSv3.add(new Option("Le résultat d'une nuit écourtée"));
		optionsSv3.add(new Option("Obiwan Kenobi"));
		optionsSv3.add(new Option("La réponse D"));
		sv3.setOptions(optionsSv3);
		sv3.addComment(new Comment((Member) users.get(1), "<3"));
		sv3.addComment(new Comment((Member) users.get(3), "Pas facile, celle-là…"));
		sv3.addComment(new Comment((Member) users.get(0), "Euh…"));
		surveys.add(sv3);
		Survey sv4 = new Survey((Member) users.get(2), "Good morning", "Je vous sers quelque chose ?", 2);
		List<Option> optionsSv4 = new ArrayList<Option>();
		optionsSv4.add(new Option("Thé"));
		optionsSv4.add(new Option("Café"));
		optionsSv4.add(new Option("Chocolat"));
		sv4.setOptions(optionsSv4);
		surveys.add(sv4);
	}
	
	private void initCategories() {
		categories = new ArrayList<>();
		categories.add(new Category("Sport"));
		categories.add(new Category("Musique"));
		categories.add(new Category("Informatique"));
	}

	private void initAlerts() {
		alerts = new ArrayList<>();
	}

	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public User getUser(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username))
				return user;
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public List<Category> getCategories() {
		return categories;
	}

	@Override
	public List<Idea> getIdeas() {
		return ideas;
	}

	@Override
	public List<Survey> getSurveys() {
		return surveys;
	}

	@Override
	public void addCategory(Category category) {
		categories.add(category);
	}

	@Override
	public List<Alert> getAlerts() {
		return alerts;
	}

	@Override
	public void addAlert(Alert alert) {
		alerts.add(alert);
	}

	@Override
	public List<User> getMostIdeaUsers() { // getMostPostUsers ?
		List<User> mostIdeaUsers = new ArrayList<>(users);
		mostIdeaUsers.sort(new Comparator<User>() {

	@Override
	public int compare(User user1, User user2) {
		return getNumberOfPosts(user2) - getNumberOfPosts(user1);
			}
		});
		if (mostIdeaUsers.size() > 3) {
			return mostIdeaUsers.subList(0, 3);
		}
		return mostIdeaUsers;
	}

	private int getNumberOfPosts(User author) {
		int numberOfPosts = 0;
		for (Post post : ideas) {
			if (post.getAuthor() == author) {
				numberOfPosts++;
			}
		}
		return numberOfPosts;
	}
}
