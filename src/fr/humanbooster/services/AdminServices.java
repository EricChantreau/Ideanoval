package fr.humanbooster.services;

import java.util.List;

import fr.humanbooster.ideas.Alert;
import fr.humanbooster.ideas.Category;
import fr.humanbooster.ideas.Comment;
import fr.humanbooster.ideas.Post;
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
	public void disablePost(Post post);
	public Alert getAlerts(List<Alert> alerts);
	public void disableComment(Comment comment);
	public void disableUser(User user);
	public void deleteUser(User user);
	public Category addCategory();
	public void deleteCategory(Category category);
	public void customizeCategory(Category category);
}
