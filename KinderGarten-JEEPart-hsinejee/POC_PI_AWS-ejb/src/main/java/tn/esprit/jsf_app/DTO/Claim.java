package tn.esprit.jsf_app.DTO;

import java.io.Serializable;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;

public class Claim implements Serializable {
	public int ComplaintId;
	public String Name;
	public String Description;
	public String ClaimDate;
	public String ClaimType;
	public String Status;

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

	public String getClaimDate() {
		return ClaimDate;
	}

	public void setClaimDate(String claimdate) {
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

	@Override
	public String toString() {
		return "Claim [ComplaintId=" + ComplaintId + ", Name=" + Name + ", Description=" + Description + ", ClaimDate="
				+ ClaimDate + ", ClaimType=" + ClaimType + ", Status=" + Status + "]";
	}
	public Claim( String Name, String ClaimDate,String Description, String ClaimType, String Status) {
		
		Name = Name;
		Description = Description;
		ClaimDate = ClaimDate;
		ClaimType = ClaimType ;
		Status=Status ;	
	}
	public Claim( int ComplaintId ,String Name, String ClaimDate,String Description, String ClaimType, String Status) {
		super();
		ComplaintId =ComplaintId;
		Name = Name;
		Description = Description;
		ClaimDate = ClaimDate;
		ClaimType = ClaimType ;
		Status=Status ;	
	}
	
	
}
