package tn.esprit.jsf_app.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Publication implements Serializable {
	private static final long serialVersionUID = 1L;
	 private int PublicationId ;
     private String titlePub ;
     private String descriptionPub ;
     private String imagePub ;
     private Date datePub ;
     private int nbLike ;
     private int nbDislike ;
     private Boolean Like ;
     private Boolean Dislike ;
     private int ParentFk ;
     private List<Comment>commentList;
     
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public int getPublicationId() {
		return PublicationId;
	}
	public void setPublicationId(int publicationId) {
		PublicationId = publicationId;
	}
	public String getTitlePub() {
		return titlePub;
	}
	public void setTitlePub(String titlePub) {
		this.titlePub = titlePub;
	}
	public String getDescriptionPub() {
		return descriptionPub;
	}
	public void setDescriptionPub(String descriptionPub) {
		this.descriptionPub = descriptionPub;
	}
	public String getImagePub() {
		return imagePub;
	}
	public void setImagePub(String imagePub) {
		this.imagePub = imagePub;
	}
	public Date getDatePub() {
		return datePub;
	}
	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}
	public int getNbLike() {
		return nbLike;
	}
	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}
	public int getNbDislike() {
		return nbDislike;
	}
	public void setNbDislike(int nbDislike) {
		this.nbDislike = nbDislike;
	}
	public Boolean getLike() {
		return Like;
	}
	public void setLike(Boolean like) {
		Like = like;
	}
	public Boolean getDislike() {
		return Dislike;
	}
	public void setDislike(Boolean dislike) {
		Dislike = dislike;
	}
	public int getParentFk() {
		return ParentFk;
	}
	public void setParentFk(int parentFk) {
		ParentFk = parentFk;
	}
	public Publication() {
		super();
	}
	public Publication(String titlePub, String descriptionPub, String imagePub, int parentFk) {
		super();
		this.titlePub = titlePub;
		this.descriptionPub = descriptionPub;
		this.imagePub = imagePub;
		ParentFk = parentFk;
	}
	public Publication(String titlePub, String descriptionPub, String imagePub) {
		super();
		this.titlePub = titlePub;
		this.descriptionPub = descriptionPub;
		this.imagePub = imagePub;
	}
	@Override
	public String toString() {
		return "Publication [PublicationId=" + PublicationId + ", titlePub=" + titlePub + ", descriptionPub="
				+ descriptionPub + ", imagePub=" + imagePub + ", datePub=" + datePub + ", nbLike=" + nbLike
				+ ", nbDislike=" + nbDislike + ", Like=" + Like + ", Dislike=" + Dislike + ", ParentFk=" + ParentFk
				+ "]";
	}


     
     



    

}
