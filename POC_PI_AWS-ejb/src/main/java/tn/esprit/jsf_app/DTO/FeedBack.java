package tn.esprit.jsf_app.DTO;

import java.io.Serializable;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;

public class FeedBack implements Serializable {
	public int FeedBackId;	
	public String Description;
	public Date FeedBackDate;
	public String sentiment;
	

	private static final long serialVersionUID = 1L;

	public FeedBack() {
		super();
	}   

	public int getFeedBackId() {
		return FeedBackId;
	}

	@Override
	public String toString() {
		return "FeedBack [FeedBackId=" + FeedBackId + ", Description=" + Description + ", FeedBackDate=" + FeedBackDate
				+ ", sentiment=" + sentiment + "]";
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

	public void setFeedBackId(int feedBackId) {
		FeedBackId = feedBackId;
	}

	public FeedBack(String description, Date feedBackDate, String sentiment) {
		super();
		Description = description;
		FeedBackDate = feedBackDate;
		this.sentiment = sentiment;
	}

	public FeedBack(int feedBackId, String description, Date feedBackDate, String sentiment) {
		super();
		FeedBackId = feedBackId;
		Description = description;
		FeedBackDate = feedBackDate;
		this.sentiment = sentiment;
	}
	

}