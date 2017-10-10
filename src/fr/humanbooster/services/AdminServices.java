package fr.humanbooster.services;

import java.util.List;

import fr.humanbooster.ideas.Alert;
import fr.humanbooster.ideas.Category;
import fr.humanbooster.ideas.Comment;
import fr.humanbooster.ideas.Post;
import fr.humanbooster.users.Member;
import fr.humanbooster.users.User;

public interface AdminServices {

//	Liste des actions r�alisables par l'admin:
//	
//	Valider inscription utilisateur
//	Consulter liste d'alertes
//	d�sactiver une id�e
//	d�sactiver un commentaire
//	d�sactiver un utilisateur
//	supprimer un utilisateur
//	Ajouter cat�gorie
//	Supprimer cat�gorie
//	Modifier cat�gorie
	
	// public void signUpValidation(User user);
	public void signUpValidation(Member member); // seuls les Members ont un attribut isActive
	public void disablePost(Post post);
	public List<Alert> getAlerts(List<Alert> alerts);
	public void disableComment(Comment comment);
	// public void disableUser(User user);
	public void disableMember(Member member); // seuls les Members ont un attribut isActive
	public void deleteUser(User user, List<User> userBase);
	public void addCategory(Category category, List<Category> categoryBase);
	public void deleteCategory(Category category, List<Category> categoryBase);
	public void customizeCategory(Category category);
}
