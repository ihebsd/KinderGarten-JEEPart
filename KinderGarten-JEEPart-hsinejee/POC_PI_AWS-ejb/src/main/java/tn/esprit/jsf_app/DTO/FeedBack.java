package tn.esprit.jsf_app.DTO;

import java.io.Serializable;

public class FeedBack implements Serializable {
	public int FeedBackId ;        
    public String FeedBackDate ;
    public String Description ;
    public String sentiment ;
    private static final long serialVersionUID = 1L;

	public FeedBack() {
		super();
	}
	public int getFeedBackId() {
		return FeedBackId;
	}

	public void setFeedBackId(int feedbackId) {
		FeedBackId = feedbackId;
	}

	public String getFeedBackDate() {
		return FeedBackDate;
	}

	public void setDescription(String description) {
		Description = description;
	}
	public String getsentiment() {
		return sentiment;
	}

	public void setsentiment(String sentiment) {
		sentiment = sentiment;
	}
	@Override
	public String toString() {
		return "FeedBack [FeedBackId=" + FeedBackId + ", Description=" + Description + ", FeedBackDate="
				+ FeedBackDate + ", sentiment=" + sentiment + "]" ;
	}
	public FeedBack( String Description, String FeedBackDate,String sentiment) {
		
		Description = Description;
		FeedBackDate = FeedBackDate ;
		sentiment = sentiment; 
	}
	public FeedBack( int FeedBackId ,String Description, String FeedBackDate,String sentiment) {
		super();
		FeedBackId= FeedBackId;
		Description = Description;
		FeedBackDate = FeedBackDate ;
		sentiment = sentiment; 
	}

	
}
