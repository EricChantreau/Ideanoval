package fr.humanbooster.test;

import java.util.Scanner;

import fr.humanbooster.services.UserServices;
import fr.humanbooster.services.UserServicesImpl;
import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public class UserTest {

	public static void main(String[] args) {
		UserServices us = new UserServicesImpl();

		Scanner sc = new Scanner(System.in);

		boolean retry = true;

		while (retry) {
			retry = false;
			// connexion
			System.out.println("Login (email) : ");
			String login = sc.nextLine();
			System.out.println("Password : ");
			String password = sc.nextLine();

			User user = us.connect(login, password);
			if (user != null) {
				// connexion réussie
				System.out.println("Bonjour " + user.getUsername());
			} else {
				// échec de connexion
				System.out.println("Login ou mot de passe incorrect.");

				System.out.println("Retry? (Y/N)");
				if (!sc.nextLine().matches("y|Y")) {
					// ne pas recommencer
					System.out.println("Voulez-vous vous enregistrer ? (Y/N)");
					if (sc.nextLine().matches("y|Y")) {
						// s'enregistrer
						System.out.println("Email : ");
						login = sc.nextLine();
						System.out.println("Password : ");
						password = sc.nextLine();
						System.out.println("Username : ");
						String username = sc.nextLine();
						User newUser = new Member(login, password, username);
						us.register(newUser);

						System.out.println("Retry? (Y/N)");
						if (sc.nextLine().matches("y|Y")) {
							retry = true;
						}
					} else {
						System.out.println("Au revoir.");
					}
				} else {
					// recommencer
					retry = true;
				}
			}

		}

		sc.close();
	}

}