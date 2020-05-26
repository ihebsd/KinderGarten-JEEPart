package tn.esprit.jsf_app.presentation.mbeans;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.jsf_app.DTO.Claim;
import tn.esprit.jsf_app.DTO.FeedBack;
import tn.esprit.jsf_app.DTO.User;
import tn.esprit.jsf_app.services.ClaimService;
import tn.esprit.jsf_app.services.FeedBackService;

@ManagedBean
@SessionScoped
public class FeedBackBean {

	int Us = User.getConnectedUser().getIdUser();
	public int FeedBackId;
	public String Description;
	public Date FeedBackDate;
	public String sentiment;
	private List<FeedBack> FeedBacks;
	private static final long serialVersionUID = 1L;
	public FeedBackService Cs = new FeedBackService();

	public int getFeedBackId() {
		return FeedBackId;
	}

	public void setFeedBackId(int feedBackId) {
		FeedBackId = feedBackId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getFeedBackDate() {
		return FeedBackDate;
	}

	public void setFeedBackDate(Date feedBackDate) {
		FeedBackDate = feedBackDate;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	public String supprimer(FeedBack F) {
		Cs.Delete(F);
		return "/Claim/Claim?faces-redirect=true";
	}

	public String addClaim() {

		Cs.Create(new FeedBack(Description, FeedBackDate, sentiment));

		return "/FeedBack/FeedBack?faces-redirect=true";

	}

	public String modifier(FeedBack e) throws IOException {

		this.setFeedBackId(e.getFeedBackId());
		this.setDescription(e.getDescription());
		this.setFeedBackDate(e.getFeedBackDate());
		this.setSentiment(e.getSentiment());

		return "/FeedBack/Edit?faces-redirect=true";

	}

	public String Details(FeedBack e) throws IOException {

		this.setFeedBackId(e.getFeedBackId());
		this.setDescription(e.getDescription());
		this.setFeedBackDate(e.getFeedBackDate());
		this.setSentiment(e.getSentiment());

		return "/FeedBack/Details?faces-redirect=true";

	}

}
