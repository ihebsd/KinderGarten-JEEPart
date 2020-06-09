package tn.esprit.jsf_app.DTO;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	private int CommentId;
	private String post;
	private String imageCom;
	private Date dateCom;
	private String nomUser;
	private int PublicationFK;

	public int getCommentId() {
		return CommentId;
	}

	public void setCommentId(int commentId) {
		CommentId = commentId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getImageCom() {
		return imageCom;
	}

	public void setImageCom(String imageCom) {
		this.imageCom = imageCom;
	}

	public Date getDateCom() {
		return dateCom;
	}

	public void setDateCom(Date dateCom) {
		this.dateCom = dateCom;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public int getPublicationFK() {
		return PublicationFK;
	}

	public void setPublicationFK(int publicationFK) {
		PublicationFK = publicationFK;
	}

	public Comment(String post, String nomUser) {
		super();
		this.post = post;
		this.nomUser = nomUser;
	}

	public Comment() {
		super();
	}

	public Comment(String post) {
		super();
		this.post = post;
	}
	
	

}
