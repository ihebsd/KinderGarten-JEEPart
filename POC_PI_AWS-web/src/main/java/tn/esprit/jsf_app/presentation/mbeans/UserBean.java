package tn.esprit.jsf_app.presentation.mbeans;

import javax.faces.bean.ManagedBean;

import org.jboss.resteasy.util.GetRestful;

import tn.esprit.jsf_app.DTO.KinderGarten;
import tn.esprit.jsf_app.DTO.User;
import tn.esprit.jsf_app.DTO.role;
import tn.esprit.jsf_app.services.UserService;
import tn.esprit.utilities.UserGet;

@ManagedBean
public class UserBean {
	private String nom;

	private String prenom;

	private String login;

	private String email;

	private String password;
	private role role;
	private String Confirmpassword;
	private String message = "";
	UserService userService = new UserService();

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

	public role getRole() {
		return role;
	}

	public void setRole(role role) {
		this.role = role;
	}

	public String getConfirmpassword() {
		return Confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		Confirmpassword = confirmpassword;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String DoLogin() {
		User user = userService.Login(this.email, this.password);

		if (user.getIdUser() == 0) {
			message = "invalid mail";
			return "";
		} else if (user.getIdUser() == -1) {
			message = "invalid password";
			return "";

		}
		System.out.println("user"+user);
		// user static
		User.setConnectedUser(user);

		return "/Publication/Publication?faces-redirect=true";
	}

	public String DoRegister() {
		User u = new User(nom, prenom, login, email, password, role, Confirmpassword);
		userService.Register(u);

		return "/Login/Login?faces-redirect=true";

	}

	public String ForgotPassword() {
		User u = new User(email);
		userService.ForgotPassword(u);

		return "/Login/Login?faces-redirect=true";

	}

	public String ResetPassword() {
		User u = new User(password, Confirmpassword, UserGet.getResetcode());
		userService.ResetPassword(u);
		UserGet.setResetcode("");
		return "/Login/Login?faces-redirect=true";

	}

}
