package fr.humanbooster.users;

public class Member extends User {

	private boolean isActive;

	public Member(String email, String password, String username) {
		super(email, password, username);
		isActive = false;
	}

	public Member(String email, String password, String username, boolean isActive) {
		super(email, password, username);
		this.isActive = isActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		if (isActive) {
			return super.toString() + "\nMembre actif.";
		}
		return super.toString() + "\nMembre désactivé.";
	}
}