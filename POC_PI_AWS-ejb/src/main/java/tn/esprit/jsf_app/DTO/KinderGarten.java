package tn.esprit.jsf_app.DTO;

import java.io.Serializable;
import java.util.Date;

public class KinderGarten implements Serializable {
	public int KinderGartenId;
	public String Name;
	public String Description;
	public String Address;
	public float Cost;
	public int Phone;
	public Date DateCreation;
	public String Image;
	public int NbrEmp;
	private static final long serialVersionUID = 1L;
	public KinderGarten() {
		super();
	}
	public int getKinderGartenId() {
		return KinderGartenId;
	}
	public void setKinderGartenId(int kinderGartenId) {
		KinderGartenId = kinderGartenId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public float getCost() {
		return Cost;
	}
	public void setCost(float cost) {
		Cost = cost;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getNbrEmp() {
		return NbrEmp;
	}
	public void setNbrEmp(int nbrEmp) {
		NbrEmp = nbrEmp;
	}
	@Override
	public String toString() {
		return "KinderGarten [KinderGartenId=" + KinderGartenId + ", Name=" + Name + ", Description=" + Description
				+ ", Address=" + Address + ", Cost=" + Cost + ", Phone=" + Phone + ", DateCreation=" + DateCreation
				+ ", Image=" + Image + ", NbrEmp=" + NbrEmp + "]";
	}
	public KinderGarten(int kinderGartenId, String name, String description, String address, float cost, int phone,
			Date dateCreation, String image, int nbrEmp) {
		super();
		KinderGartenId = kinderGartenId;
		Name = name;
		Description = description;
		Address = address;
		Cost = cost;
		Phone = phone;
		DateCreation = dateCreation;
		Image = image;
		NbrEmp = nbrEmp;
	}
	public KinderGarten(String name, String description, String address, float cost, int phone, Date dateCreation,
			String image, int nbrEmp) {
		super();
		Name = name;
		Description = description;
		Address = address;
		Cost = cost;
		Phone = phone;
		DateCreation = dateCreation;
		Image = image;
		NbrEmp = nbrEmp;
	}

}
