package fr.humanbooster.services.impl;

import fr.humanbooster.ideas.Category;
import fr.humanbooster.ideas.Comment;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.services.AdminServices;
import fr.humanbooster.users.User;

public class AdminServicesImpl implements AdminServices {

	@Override
	public void signUpValidation(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disablePost(Post post) {
		post.setActive(false);
		
	}

	@Override
	public void disableComment(Comment comment) {
		comment.setActive(false);
		
	}

	@Override
	public void disableUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category addCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void customizeCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

}
