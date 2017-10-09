package fr.humanbooster.services;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.ideas.Idea;
import fr.humanbooster.ideas.Option;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.ideas.Survey;
import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public class DatabaseImpl implements Database {

	private List<User> users;
	private List<Post> posts;

	public DatabaseImpl() {
		users = new ArrayList<>();
		posts = new ArrayList<>();

		Member mb1 = new Member("marsu@pila.mi", "houba!houba!hop!", "Marsupilami");
		Member mb2 = new Member("bbr@lfan.fr", "azer*5kjhgf", "Babar");
		Member mb3 = new Member("echantreau", "password0", "eric c");
		Member mb4 = new Member("jduvivier@humanbooster.com", "pwd1234", "jduvivier");

		users.add(mb1);
		users.add(mb2);
		users.add(mb3);
		users.add(mb4);

		Idea id1 = new Idea(mb1, "Voici ma premi�re id�e",
				"Plus de frites � la cantine ! Plus de cours de Java avec Safia ! Moins d'examens � Human Booster !");
		posts.add(id1);
		Idea id2 = new Idea(mb2, "Cacahu�tes !", "Donnez-moi des cacachu�tes ! :'(");
		posts.add(id2);
		Survey sv1 = new Survey(mb4, "Mon premier sondage", "Pour ou contre ?", 7);
		List<Option> optionsSv1 = new ArrayList<Option>();
		optionsSv1.add(new Option("Option 1"));
		optionsSv1.add(new Option("Option 2"));
		optionsSv1.add(new Option("Option 3"));
		sv1.setOptions(optionsSv1);
		posts.add(sv1);
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
	public List<Post> getPosts() {
		return posts;
	}
}
