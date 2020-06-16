package tn.esprit.jsf_app.services;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.jsf_app.DTO.Comment;
import tn.esprit.jsf_app.DTO.Publication;
import tn.esprit.jsf_app.interfaces.PublicationServiceRemote;

@Stateful
@LocalBean
public class PublicationService implements PublicationServiceRemote {
	public String GlobalEndPoint = "kindergartenazure.azurewebsites.net";
	EntityManager em;

	public void Like(int idp,int idu) {
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("https://" + GlobalEndPoint + "/api/like?idp="+idp+"&idu="+idu);

		Response response = web.request().get();

	}

	public void Dislike(int idp,int idu) {
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("https://" + GlobalEndPoint + "/api/dislike?idp="+idp+"&idu="+idu);

		Response response = web.request().get();

	}
	public void AnnulerLike(int idp,int idu) {
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("https://" + GlobalEndPoint + "/api/annulerlike?idp="+idp+"&idu="+idu);

		Response response = web.request().get();

	}

	public void AnnulerDislike(int idp,int idu) {
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("https://" + GlobalEndPoint + "/api/annulerdislike?idp="+idp+"&idu="+idu);

		Response response = web.request().get();

	}
	public boolean TestLike(int idp,int idu) {
		List<Boolean> bools = new ArrayList<Boolean>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("https://" + GlobalEndPoint + "/api/testLike?idp=" + idp+"&idu="+idu);

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {
			boolean test;
			test = object.getBoolean(i);

			bools.add(test);

		}

		return bools.get(0);
	}
	public boolean TestDislike(int idp,int idu) {
		List<Boolean> bools = new ArrayList<Boolean>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("https://" + GlobalEndPoint + "/api/testDislike?idp=" + idp+"&idu="+idu);

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {
			boolean test;
			test = object.getBoolean(i);

			bools.add(test);

		}

		return bools.get(0);
	}

	@Override
	public List<Publication> GetAll() {
		List<Publication> lasp = new ArrayList<Publication>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("https://" + GlobalEndPoint + "/api/PublicationApi");

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			Publication m = new Publication();
			m.setPublicationId(object.getJsonObject(i).getInt("PublicationId"));
			m.setDescriptionPub(object.getJsonObject(i).getString("descriptionPub"));
			m.setTitlePub(object.getJsonObject(i).getString("titlePub"));
			m.setImagePub(object.getJsonObject(i).getString("imagePub"));
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			;
			try {
				m.setDatePub(format.parse(object.getJsonObject(i).getString("datePub")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			m.setNbDislike(object.getJsonObject(i).getInt("nbDislike"));
			m.setNbLike(object.getJsonObject(i).getInt("nbLike"));
			m.setParentFk(object.getJsonObject(i).getInt("ParentFK"));
			m.setLike(object.getJsonObject(i).getBoolean("Like"));
			m.setDislike(object.getJsonObject(i).getBoolean("Dislike"));

			lasp.add(m);
		}

		return lasp;
	}
	public Publication GetById(int id) {
		List<Publication> lasp = new ArrayList<Publication>();
		Client client = ClientBuilder.newClient();
		WebTarget web = client.target("https://" + GlobalEndPoint + "/api/PublicationApi/Details?id="+id);

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			Publication m = new Publication();
			m.setPublicationId(object.getJsonObject(i).getInt("PublicationId"));
			m.setDescriptionPub(object.getJsonObject(i).getString("descriptionPub"));
			m.setTitlePub(object.getJsonObject(i).getString("titlePub"));
			m.setImagePub(object.getJsonObject(i).getString("imagePub"));
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			;
			try {
				m.setDatePub(format.parse(object.getJsonObject(i).getString("datePub")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			m.setNbDislike(object.getJsonObject(i).getInt("nbDislike"));
			m.setNbLike(object.getJsonObject(i).getInt("nbLike"));
			m.setParentFk(object.getJsonObject(i).getInt("ParentFK"));
			m.setLike(object.getJsonObject(i).getBoolean("Like"));
			m.setDislike(object.getJsonObject(i).getBoolean("Dislike"));

			lasp.add(m);
		}

		return lasp.get(0);
	}
	@Override
	public void Delete(Publication publication) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("https://" + GlobalEndPoint + "/api/PublicationApi/Delete?id=" + publication.getPublicationId());
		WebTarget hello = target.path("");
		Response response = hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();

		System.out.println("LOG DELETED" + response.getStatus());
		String result = response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:" + result);

		response.close();
	}

	@Override
	public void Create(Publication p) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://" + GlobalEndPoint + "/api/PublicationApi/Create");
		WebTarget hello = target.path("");
		Response response = hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON));

		String result = response.readEntity(String.class);
		System.out.println(result);

		response.close();
	}

	@Override
	public void Update(int id, Publication k) {
		Publication km = new Publication();

		km.setTitlePub(k.getTitlePub());
		km.setImagePub(k.getImagePub());
		km.setDescriptionPub(k.getDescriptionPub());

		System.out.println("iddddddddd" + k);

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://" + GlobalEndPoint + "/api/PublicationApi/Put?id=" + id);
		Response response = target.request().put(Entity.entity(k, MediaType.APPLICATION_JSON));
		System.out.println(response);

	}

	public List<Comment> GetCommentByPub(int id) {
		List<Comment> lasp = new ArrayList<Comment>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("https://" + GlobalEndPoint + "/api/Comments?id=" + id);

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			Comment m = new Comment();
			m.setCommentId(object.getJsonObject(i).getInt("CommentId"));
			m.setPost(object.getJsonObject(i).getString("post"));
			m.setNomUser(object.getJsonObject(i).getString("nomUser"));
			m.setPublicationFK(object.getJsonObject(i).getInt("PublicationFK"));

			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			;
			try {
				m.setDateCom(format.parse(object.getJsonObject(i).getString("dateCom")));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			lasp.add(m);
		}
		return lasp;

	}
	public void CreateComment(int id,Comment p) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://" + GlobalEndPoint + "/api/Comment/Create?id="+id);
		WebTarget hello = target.path("");
		Response response = hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON));

		String result = response.readEntity(String.class);
		System.out.println(result);

		response.close();
	}
	public void DeleteCom(Comment comment) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("https://" + GlobalEndPoint + "/api/Comment/Delete?id=" + comment.getCommentId());
		WebTarget hello = target.path("");
		Response response = hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();

		System.out.println("LOG DELETED" + response.getStatus());
		String result = response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:" + result);

		response.close();
	}
	public void UpdateCom(int id, Comment k) {
		Comment km = new Comment();

		km.setPost(k.getPost());
		


		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://" + GlobalEndPoint + "/api/Comment/Put?id=" + id);
		Response response = target.request().put(Entity.entity(k, MediaType.APPLICATION_JSON));

	}
}
