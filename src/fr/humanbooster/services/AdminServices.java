package fr.humanbooster.services;

import fr.humanbooster.ideas.Category;
import fr.humanbooster.ideas.Comment;
import fr.humanbooster.ideas.Idea;
import fr.humanbooster.users.User;

public interface AdminServices {

//	Liste des actions réalisables par l'admin:
//	
//	Valider inscription utilisateur
//	Consulter liste d'alertes
//	désactiver une idée
//	désactiver un commentaire
//	désactiver un utilisateur
//	supprimer un utilisateur
//	Ajouter catégorie
//	Supprimer catégorie
//	Modifier catégorie
	
	
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
