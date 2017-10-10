package fr.humanbooster.services;

import fr.humanbooster.ideas.Category;
import fr.humanbooster.ideas.Comment;
import fr.humanbooster.ideas.Idea;
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
	
	
	public void signUpValidation(User user);
//	public Alert getAlerts(List<Alert> alerts);
	public void disableIdea(Idea idea);
	public void disableComment(Comment comment);
	public void disableUser(User user);
	public void deleteUser(User user);
	public Category addCategory();
	public void deleteCategory(Category category);
	public void customizeCategory(Category category);
	
	
	
	
}
