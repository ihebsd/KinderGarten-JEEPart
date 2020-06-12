package tn.esprit.jsf_app.presentation.mbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import tn.esprit.jsf_app.DTO.Comment;
import tn.esprit.jsf_app.DTO.KinderGarten;
import tn.esprit.jsf_app.DTO.Publication;
import tn.esprit.jsf_app.DTO.User;
import tn.esprit.jsf_app.services.PublicationService;
import tn.esprit.jsf_app.services.UserService;

@ManagedBean
@SessionScoped
public class PublicationBean {
	private int PublicationId;
	private String titlePub;
	private String descriptionPub;
	private static String imagePub;
	private Date datePub;
	private int nbLike;
	private int nbDislike;
	private Boolean Like;
	private Boolean Dislike;
	private int ParentFk;
	private int us ;
	private List<Publication> Publications;
	private List<Comment>Comments;
	private PublicationService ps = new PublicationService();
	private UserService userS=new UserService();
	private String nom,prenom;
	private String img;
	private String com;
	private int comId;
	private int nbr;

	public PublicationBean() {
		this.ParentFk = User.getConnectedUser().getIdUser();
		
	}

	public int getPublicationId() {
		return PublicationId;
	}

	public void setPublicationId(int publicationId) {
		PublicationId = publicationId;
	}

	public int getUs() {
		return us;
	}

	public void setUs(int us) {
		this.us = us;
	}

	public List<Comment> getComments() {
		return Comments;
	}

	public void setComments(List<Comment> comments) {
		Comments = comments;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
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

	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public static String getImagePub() {
		return imagePub;
	}

	public static void setImagePub(String imagePub) {
		PublicationBean.imagePub = imagePub;
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

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
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

	public List<Publication> getPublications() {
		Publications = ps.GetAll();
		return Publications;
	}

	public void setPublications(List<Publication> publications) {
		Publications = publications;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	private Part logo;

	public Part getLogo() {
		return logo;
	}

	public void setLogo(Part logo) {
		this.logo = logo;
	}

	public void doUpload() {

		try {
			InputStream in = logo.getInputStream();
			imagePub = logo.getSubmittedFileName();
			File f = new File(
					"C:\\Users\\Rosewild\\Desktop\\Pi PaaS SaaS Kindergarten\\KinderGarten-JEEPart-hsinejee\\POC_PI_AWS-web\\src\\main\\webapp\\Ressources\\Uploads\\"
							+ logo.getSubmittedFileName());
			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);

			byte[] buffer = new byte[1024];
			int length;

			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			out.close();
			in.close();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

	public String addPublication() {

		ps.Create(new Publication(titlePub, descriptionPub, imagePub, ParentFk));

		return "/Publication/Publication?faces-redirect=true";

	}

	public String supprimer(Publication p) {
		ps.Delete(p);
		return "/Publication/Publication?faces-redirect=true";
	}

	public String modifier(Publication e) throws IOException {
		this.setPublicationId(e.getPublicationId());
		this.setDescriptionPub(e.getDescriptionPub());
		this.setTitlePub(e.getTitlePub());

		return "/Publication/Edit?faces-redirect=true";

	}

	public Boolean test(Publication p) {
		this.us = User.getConnectedUser().getIdUser();
		System.out.println("user conn"+us);
		System.out.println("user conn"+p.getParentFk());
		if (p.getParentFk() == us)
			return true;
		return false;
	}
	public Boolean testcom(Comment p) {
		String us1 = User.getConnectedUser().getNom();
		
		System.out.println("user conn"+us1);
		System.out.println("user conn"+p.getNomUser());
		if (p.getNomUser().equals(us1))
			return true;
		return false;
	}
	public String PutPub() throws InterruptedException {

		ps.Update(PublicationId, new Publication(titlePub, descriptionPub, imagePub));

		return "/Publication/Publication?faces-redirect=true";
	}
	public String Like(Publication p) {
		if(!ps.TestLike(p.getPublicationId(), User.getConnectedUser().getIdUser())) 
		ps.Like(p.getPublicationId(),User.getConnectedUser().getIdUser());
		else
			ps.AnnulerLike(p.getPublicationId(), User.getConnectedUser().getIdUser());
		return "/Publication/Publication?faces-redirect=true";
	}
	public String disLike(Publication p) {
		if(!ps.TestDislike(p.getPublicationId(), User.getConnectedUser().getIdUser())) 
		ps.Dislike(p.getPublicationId(),User.getConnectedUser().getIdUser());
		else
			ps.AnnulerDislike(p.getPublicationId(), User.getConnectedUser().getIdUser());
		return "/Publication/Publication?faces-redirect=true";
	}
	public String annLike(Publication p) {
		ps.AnnulerLike(p.getPublicationId(),User.getConnectedUser().getIdUser());
		return "/Publication/Publication?faces-redirect=true";
	}
	public String anndisLike(Publication p) {
		ps.AnnulerDislike(p.getPublicationId(),User.getConnectedUser().getIdUser());
		return "/Publication/Publication?faces-redirect=true";
	}
	public String details(Publication e)  {
		this.prenom=userS.GetUserById(ParentFk).getPrenom();
		this.nom=userS.GetUserById(ParentFk).getNom();

		this.setPublicationId(e.getPublicationId());
		this.setDescriptionPub(e.getDescriptionPub());
		this.setTitlePub(e.getTitlePub());
		this.setImg(e.getImagePub());
		this.setPublicationId(e.getPublicationId());
		this.setDatePub(e.getDatePub());
		this.Comments=ps.GetCommentByPub(PublicationId);
		this.nbr=Comments.size();

		return "/Publication/Details?faces-redirect=true";

	}
	public String CreateComm() {
		String nomU=User.getConnectedUser().getNom();
		ps.CreateComment(PublicationId, new Comment(com, nomU));
		this.com=null;
		return details(ps.GetById(PublicationId));
		 
	}
	public String deleteCom(Comment c) {
		ps.DeleteCom(c);
		return details(ps.GetById(PublicationId));

	}
	public String UpdateComm(Comment c) {
		this.comId=c.getCommentId();
		this.com=c.getPost();
		this.PublicationId=c.getPublicationFK();
		return "/Publication/EditCom?faces-redirect=true";
	}
	public String UpdateComme() {
		ps.UpdateCom(comId, new Comment(com));
		this.com=null;
		System.out.println("she"+PublicationId);
		return details(ps.GetById(PublicationId));
	}
}
