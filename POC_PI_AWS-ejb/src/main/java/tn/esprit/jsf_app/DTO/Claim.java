package tn.esprit.jsf_app.DTO;

import java.io.Serializable;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;

public class Claim implements Serializable {
	private int ComplaintId;
	private String Name;
	private String Description;
	private Date ClaimDate;
	private String ClaimType;
	private String Status;

	private static final long serialVersionUID = 1L;

	public Claim() {
		super();
	}   

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

	public void setClaimDate(Date claimdate) {
		ClaimDate = claimdate;
	}

	public String getClaimType() {
		return ClaimType;
	}

	public void setClaimType(String claimtype) {
		ClaimType = claimtype;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Claim(int complaintId, String name, String description, String claimType) {
		super();
		ComplaintId = complaintId;
		Name = name;
		Description = description;
		ClaimType = claimType;
	}

	@Override
	public String toString() {
		return "Claim [ComplaintId=" + ComplaintId + ", Name=" + Name + ", Description=" + Description + ", ClaimDate="
				+ ClaimDate + ", ClaimType=" + ClaimType + ", Status=" + Status + "]";
	}

	public Claim(int complaintId, String name, String description, Date claimDate, String claimType, String status) {
		super();
		ComplaintId = complaintId;
		Name = name;
		Description = description;
		ClaimDate = claimDate;
		ClaimType = claimType;
		Status = status;
	}

	public Claim(String name, String description, String claimType) {
		super();
		Name = name;
		Description = description;
		ClaimType = claimType;
	}

	public Claim(String name, String description, Date claimDate, String claimType, String status) {
		super();
		Name = name;
		Description = description;
		ClaimDate = claimDate;
		ClaimType = claimType;
		Status = status;
	}

	
	
	
}