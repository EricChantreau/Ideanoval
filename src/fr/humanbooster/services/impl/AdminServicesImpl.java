package fr.humanbooster.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.humanbooster.ideas.Alert;
import fr.humanbooster.ideas.Category;
import fr.humanbooster.ideas.Comment;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.services.AdminServices;
import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public class AdminServicesImpl implements AdminServices {

	@Override
	public void disablePost(Post post) {
		post.setActive(false);
		
	}

	@Override
	public void disableComment(Comment comment) {
		comment.setActive(false);
		
	}

@Override
	public void customizeCategory(Category category) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le nouveau nom de la catégorie.");
		String name = sc.nextLine();
		category.setName(name);
		sc.close();
	}

	@Override
	public void signUpValidation(Member member) {
		member.setActive(true);
	}

	@Override
	public List<Alert> getAlerts(List<Alert> alerts) {
		List<Alert> alertsNotTreated = new ArrayList<>();
		for (Alert alert : alerts) {
			if (alert.isActive) {
			alertsNotTreated.add(alert);
			}
		}
		return alertsNotTreated;
	}

	@Override
	public void disableMember(Member member) {
		member.setActive(false);
		
	}

	@Override
	public void deleteUser(User user, List<User> userBase) {
		userBase.remove(user);
	}

	@Override
	public void addCategory(Category category, List<Category> categoryBase) {
		categoryBase.add(category);
	}

	@Override
	public void deleteCategory(Category category, List<Category> categoryBase) {
		categoryBase.remove(category);
	}

}
