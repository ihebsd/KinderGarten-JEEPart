package tn.esprit.jsf_app.DTO;

import java.io.Serializable;

public class Kid implements Serializable{
	private int IdKid;
	private String FirstName;
	public int getIdKid() {
		return IdKid;
	}
	public void setIdKid(int idKid) {
		IdKid = idKid;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	

}
