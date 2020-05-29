package tn.esprit.jsf_app.presentation.mbeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.jsf_app.DTO.Claim;
import tn.esprit.jsf_app.DTO.KinderGarten;
import tn.esprit.jsf_app.DTO.User;
import tn.esprit.jsf_app.services.ClaimService;
import tn.esprit.jsf_app.services.KinderGartenService;

@ManagedBean
@SessionScoped
public class ClaimBean {
	//int Us = User.getConnectedUser().getIdUser();
	public int ComplaintId;
	public String Name;
	public String Description;
	public Date ClaimDate;
	public String ClaimType;
	public String Status;
	private List<Claim> Claims ;
	private static final long serialVersionUID = 1L;
	public ClaimService Cs = new ClaimService();

	public int getComplaintId() {
		return ComplaintId;
	}

	public void setComplaintId(int complaintId) {
		ComplaintId = complaintId;
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

	public Date getClaimDate() {
		return ClaimDate;
	}

	public void setClaimDate(Date claimDate) {
		ClaimDate = claimDate;
	}

	public String getClaimType() {
		return ClaimType;
	}

	public void setClaimType(String claimType) {
		ClaimType = claimType;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String supprimer(Claim C) {
		Cs.Delete(C);
		return "/Claim/Claims?faces-redirect=true";
	}
	
	public String getClaim() {
		return "Claims.jsf";
	}
	public List<Claim> getClaims() {

		Claims=Cs.GetAll();
		System.out.println("ICII"+Cs.GetAll());
		return Claims;
	}

	public void setClaims(List<Claim> claims) {
		Claims = claims;
	}


	public String addClaim() {

		Cs.Create(new Claim(Name, Description,ClaimType));

		return "/Claim/AddClaim?faces-redirect=true";

	}

	public String modifier(Claim e) throws IOException {

		this.setName(e.getName());
		this.setDescription(e.getDescription());
		this.setClaimType(e.getClaimType());

		return "/Claim/Edit?faces-redirect=true";

	}

	public String Details(Claim e) throws IOException {

		this.setComplaintId(e.getComplaintId());
		this.setName(e.getName());
		this.setDescription(e.getDescription());
		this.setClaimDate(e.getClaimDate());
		this.setClaimType(e.getClaimType());
		this.setStatus(e.getStatus());

		return "/Claim/Details?faces-redirect=true";

	}
	public String PutClaim() throws InterruptedException {

		Cs.Update( ComplaintId,new Claim(Name, Description,ClaimType));
		
		return "/Claim/Claims?faces-redirect=true";
	}

	
}
