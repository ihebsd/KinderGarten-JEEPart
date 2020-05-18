package tn.esprit.jsf_app.presentation.mbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.servlet.http.Part;



import tn.esprit.jsf_app.DTO.KinderGarten;
import tn.esprit.jsf_app.DTO.User;
import tn.esprit.jsf_app.services.KinderGartenService;

@ManagedBean
public class KinderGartenBean {
	public int KinderGartenId;
	public String Name;
	public String Description;
	public String Address;
	public float Cost;
	public int Phone;
	public Date DateCreation;
	public static String Image;
	public int NbrEmp;
	private List<KinderGarten> KinderGarten;
	private static final long serialVersionUID = 1L;
	public KinderGartenService K = new KinderGartenService();

	private Part logo;
	private boolean upladed;

	public void doUpload() {

		try {
			InputStream in = logo.getInputStream();
			Image= logo.getSubmittedFileName();

			File f = new File("C:\\Users\\Hsine\\Desktop\\KinderGarten2\\KinderGarten\\Solution.Web\\Content\\Uploads\\"
					+ logo.getSubmittedFileName());
			System.out.println("hsiiiiiine" + f.getAbsolutePath());
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

	public void doUpload1() {

		try {
			InputStream in = logo.getInputStream();

			File f = new File(
					"C:\\Work\\PI-JEE\\KinderGarten-JEEPart\\POC_PI_AWS-web\\src\\main\\webapp\\Ressources\\Uploads\\"
							+ logo.getSubmittedFileName());
			System.out.println("hsiiiiiine" + f.getAbsolutePath());
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

	public Part getLogo() {
		return logo;
	}

	public void setLogo(Part logo) {
		this.logo = logo;
	}

	public boolean isUpladed() {
		return upladed;
	}

	public void setUpladed(boolean upladed) {
		this.upladed = upladed;
	}

	public int getKinderGartenId() {
		return KinderGartenId;
	}

	public List<KinderGarten> getKinderGarten() {
		return KinderGarten;
	}

	public void setKinderGarten(List<KinderGarten> kinderGarten) {
		KinderGarten = kinderGarten;
	}

	public List<KinderGarten> getKinderGartens() {
		KinderGarten = K.GetAll();
		return KinderGarten;
	}

	public String supprimer(KinderGarten e) {
		K.Delete(e);
		return "KinderGarten.jsf";

	}
	

	public String addKinderGarten() {
		 int Us=User.getConnectedUser().getIdUser();
		K.Create(new KinderGarten(Name,Description,Address,Cost,Phone,Image,NbrEmp,Us));

		return "/KinderGarten/KinderGarten?faces-redirect=true";

	}

	public String modifier(KinderGarten e) throws IOException {

		this.setKinderGartenId(e.getKinderGartenId());
		this.setName(e.getName());
		this.setImage(e.getImage());
		this.setCost(e.getCost());
		this.setDescription(e.getDescription());
		this.setDateCreation(e.getDateCreation());
		this.setAddress(e.getAddress());
		this.setPhone(e.getPhone());
		this.setNbrEmp(e.getNbrEmp());
		System.out.println(e.getKinderGartenId());

		return "Edit.jsf";

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

	

	public static String getImage() {
		return Image;
	}

	public static void setImage(String image) {
		Image = image;
	}

	public int getNbrEmp() {
		return NbrEmp;
	}

	public void setNbrEmp(int nbrEmp) {
		NbrEmp = nbrEmp;
	}

	public void setKinderGartenId(int kinderGartenId) {
		KinderGartenId = kinderGartenId;
	}


}
