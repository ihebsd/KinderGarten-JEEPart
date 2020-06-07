package tn.esprit.jsf_app.DTO;

import java.io.Serializable;

public class User implements Serializable{
 	private static final long serialVersionUID = 1L;

	private String Email;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	

}
