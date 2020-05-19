package tn.esprit.jsf_app.DTO;

import java.io.Serializable;

public class User implements Serializable {
	private static User ConnectedUser;
	private int idUser;

	private String nom;

	private String prenom;

	private String login;

	private String email;

	private String password;
	private role role;
	private String Confirmpassword;
	private boolean IsEmailVerified;
	private String ResetPasswordCode;
	public String ActivationCode ;
	private static final long serialVersionUID = 1L;

	public String getActivationCode() {
		return ActivationCode;
	}

	public void setActivationCode(String activationCode) {
		ActivationCode = activationCode;
	}

	public static User getConnectedUser() {
		return ConnectedUser;
	}

	public static void setConnectedUser(User connectedUser) {
		ConnectedUser = connectedUser;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return Confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		Confirmpassword = confirmpassword;
	}

	public boolean isIsEmailVerified() {
		return IsEmailVerified;
	}

	public void setIsEmailVerified(boolean isEmailVerified) {
		IsEmailVerified = isEmailVerified;
	}

	public String getResetPasswordCode() {
		return ResetPasswordCode;
	}

	public void setResetPasswordCode(String resetPasswordCode) {
		ResetPasswordCode = resetPasswordCode;
	}

	public role getRole() {
		return role;
	}

	public void setRole(role role) {
		this.role = role;
	}

	
	public User(String nom, String prenom, String login, String email, String password, tn.esprit.jsf_app.DTO.role role,
			String confirmpassword) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.email = email;
		this.password = password;
		this.role = role;
		Confirmpassword = confirmpassword;
	}

	public User() {
		super();
	}

	public User(String email) {
		super();
		this.email = email;
	}
	public User(String password, String confirmpassword, String resetPasswordCode) {
		super();
		this.password = password;
		Confirmpassword = confirmpassword;
		ResetPasswordCode = resetPasswordCode;
	}
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", email="
				+ email + ", password=" + password + ", role=" + role + ", Confirmpassword=" + Confirmpassword
				+ ", IsEmailVerified=" + IsEmailVerified + ", ResetPasswordCode=" + ResetPasswordCode + "]";
	}

	
	
}
