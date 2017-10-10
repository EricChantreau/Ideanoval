package fr.humanbooster.test;

import java.util.Scanner;

import fr.humanbooster.services.LoginServices;
import fr.humanbooster.services.impl.LoginServicesImpl;
import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public class UserTest {

	public static void main(String[] args) {
		LoginServices ls = new LoginServicesImpl();
		Scanner sc = new Scanner(System.in);
		boolean retry = true;
		while (retry) {
			retry = false;
			System.out.println("Que faire? (connexion/enregistrement)");
			String line = sc.nextLine();
			// connexion
			if (line.matches("connexion|c")) {
				User user = connect(sc, ls);
				if (user != null) {
					System.out.println("Bonjour " + user.getUsername());
				} else {
					System.out.println("Login ou mot de passe incorrect.");
				}
			}
			// enregistrement
			if (line.matches("enregistrement|e")) {
				if (register(sc, ls)) {
					System.out.println("Enregistrement réussi!");
				} else {
					System.out.println("Enregistrement échoué");
				}
			}
			// recommencer
			System.out.println("Recommencer? (y/n)");
			line = sc.nextLine();
			if (line.matches("y|Y")) {
				retry = true;
			}
		}
		sc.close();
	}

	public static User connect(Scanner sc, LoginServices ls) {
		System.out.println("Login (email) : ");
		String login = sc.nextLine();
		System.out.println("Password : ");
		String password = sc.nextLine();
		return ls.connect(login, password);
	}

	public static boolean register(Scanner sc, LoginServices ls) {
		System.out.println("Email : ");
		String login = sc.nextLine();
		System.out.println("Password : ");
		String password = sc.nextLine();
		System.out.println("Username : ");
		String username = sc.nextLine();
		User newUser = new Member(login, password, username);
		return ls.register(newUser);
	}

}