package tn.esprit.jsf_app.presentation.mbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import tn.esprit.jsf_app.DTO.KinderGarten;
import tn.esprit.jsf_app.DTO.User;
import tn.esprit.jsf_app.services.KinderGartenService;
import tn.esprit.jsf_app.services.UserService;

/**
 * @author Hsine
 *
 */
@ManagedBean
@SessionScoped
public class KinderGartenBean implements Serializable {
	int Us = User.getConnectedUser().getIdUser();
	public int KinderGartenId;
	public String Name;
	public String Description;
	public String Address;
	public float Cost;
	public int Phone;
	public Date DateCreation;
	public static String Image;
	public int NbrEmp;
	private int DirecteurId;
	private List<KinderGarten> KinderGarten;
	private static final long serialVersionUID = 1L;
	public KinderGartenService K = new KinderGartenService();
	private String LO;
	private double longitude;
	private double latitude;
	private MapModel simpleModel;
	private Part logo;
	private String email;
	private String searchString = "";
	UserService userservice = new UserService();

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getLO() {
		return LO;
	}

	public void setLO(String lO) {
		LO = lO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Part getLogo() {
		return logo;
	}

	public void setLogo(Part logo) {
		this.logo = logo;
	}

	public int getDirecteurId() {
		return DirecteurId;
	}

	public void setDirecteurId(int directeurId) {
		DirecteurId = directeurId;
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
		if (searchString.trim().equals(""))

			KinderGarten = K.GetAll();
		return KinderGarten;
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

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}

	public void doUpload() {

		try {
			InputStream in = logo.getInputStream();
			Image = logo.getSubmittedFileName();
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

	public String supprimer(KinderGarten k) {
		K.Delete(k);

		this.KinderGarten = K.GetAll();
		return "/KinderGarten/KinderGarten?faces-redirect=true";
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onPointSelect(PointSelectEvent event) {
		LatLng latlng = event.getLatLng();
		this.setLongitude(latlng.getLng());
		this.setLatitude(latlng.getLat());
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Point Selected",
				"Lat:" + latlng.getLat() + ", Lng:" + latlng.getLng()));
	}

	public String addKinderGarten() {

		K.Create(new KinderGarten(Name, Description, Address, Cost, Phone, Image, NbrEmp, Us, longitude, latitude));

		this.setName(null);
		this.setCost(0);
		this.setDescription(null);
		this.setAddress(null);
		this.setPhone(0);
		this.setNbrEmp(0);
		this.setDateCreation(null);
		this.setImage(null);
		this.setLongitude(0);
		this.setLatitude(0);
		this.KinderGarten = K.GetAll();

		return "/KinderGarten/KinderGarten?faces-redirect=true";

	}

	public String modifier(KinderGarten e) throws IOException {

		this.setKinderGartenId(e.getKinderGartenId());
		this.setName(e.getName());
		this.setCost(e.getCost());
		this.setDescription(e.getDescription());
		this.setAddress(e.getAddress());
		this.setPhone(e.getPhone());
		this.setNbrEmp(e.getNbrEmp());
		this.setDateCreation(e.getDateCreation());
		this.setImage(e.getImage());
		this.setLongitude(e.getLongitude());
		this.setLatitude(e.getLatitude());
		simpleModel = new DefaultMapModel();

		LatLng coord1 = new LatLng(latitude, longitude);
		simpleModel.addOverlay(new Marker(coord1, Name));

		return "/KinderGarten/Edit?faces-redirect=true";

	}

	public String Details(KinderGarten e) throws IOException {

		this.setKinderGartenId(e.getKinderGartenId());
		this.setName(e.getName());
		this.setCost(e.getCost());
		this.setDescription(e.getDescription());
		this.setAddress(e.getAddress());
		this.setPhone(e.getPhone());
		this.setNbrEmp(e.getNbrEmp());
		this.setDateCreation(e.getDateCreation());
		this.setLO(e.getImage());
		this.setLongitude(e.getLongitude());
		this.setLatitude(e.getLatitude());
		this.setDirecteurId(e.getDirecteurId());
		this.setEmail(userservice.GetUserById(DirecteurId).getEmail());
		simpleModel = new DefaultMapModel();

		LatLng coord1 = new LatLng(latitude, longitude);
		simpleModel.addOverlay(new Marker(coord1, Name));
		

		return "/KinderGarten/Details?faces-redirect=true";

	}

	public String PutKinder() throws InterruptedException {

		K.Update(KinderGartenId,
				new KinderGarten(KinderGartenId, Name, Description, Address, Cost, Phone, Image, NbrEmp,longitude,latitude));
		this.setKinderGartenId(0);
		this.setName(null);
		this.setCost(0);
		this.setDescription(null);
		this.setAddress(null);
		this.setPhone(0);
		this.setNbrEmp(0);
		this.setDateCreation(null);
		this.setImage(null);
		this.KinderGarten = K.GetAll();

		return "/KinderGarten/KinderGarten?faces-redirect=true";
	}

	public String search() {
		KinderGarten = K.GetAll();

		List<KinderGarten> kindergartens1 = new ArrayList<KinderGarten>();
		for (KinderGarten kindergarten : KinderGarten) {
			if (kindergarten.getName().toLowerCase().contains(searchString.toLowerCase())
					|| kindergarten.getDescription().toLowerCase().contains(searchString.toLowerCase()))
				kindergartens1.add(kindergarten);
		}
		this.setKinderGarten(kindergartens1);

		return "";
	}
}
