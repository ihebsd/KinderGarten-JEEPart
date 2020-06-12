package tn.esprit.jsf_app.services;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import tn.esprit.jsf_app.DTO.CarPool;
import tn.esprit.jsf_app.DTO.Kid;
import tn.esprit.jsf_app.interfaces.CarPoolServiceRemote;

@Stateful
@LocalBean
public class CarPoolService implements CarPoolServiceRemote {

	public String GlobalEndPoint = "localhost:44326";
	EntityManager em;

	@Override
	public List<CarPool> GetAll() {
		// Client client = ClientBuilder.newClient();
		// WebTarget target = client.target("http://localhost:31618/api/PubWebApi/");
		// WebTarget hello =target.path("");
		// Response response =hello.request().get();

		// String result=response.readEntity(String.class);

		// PublicationDTO[] pubs = response.readEntity(PublicationDTO[].class);

		// response.close();
		// return pubs;
		List<CarPool> lasp = new ArrayList<CarPool>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("http://localhost:44326"  + "/api/CarPoolApi/");

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		// System.out.println(result);
		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			CarPool m = new CarPool();
			// String dateString;
			m.setId(object.getJsonObject(i).getInt("Id"));
			m.setIdParent(object.getJsonObject(i).getInt("idParent"));
			m.setIdKid(object.getJsonObject(i).getInt("idKid"));
			m.setTitle(object.getJsonObject(i).getString("Title"));
			m.setFrom(object.getJsonObject(i).getString("From"));
			// m.setCategory(object.getJsonObject(i).getCategory("Category"));
			m.setTo(object.getJsonObject(i).getString("To"));
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			;
			try {
				m.setDatee(format.parse(object.getJsonObject(i).getString("Date")));
				m.setTimee(format.parse(object.getJsonObject(i).getString("Time")));
				// m.setUntilDatee(format.parse(object.getJsonObject(i).getString("UntilDate")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			m.setMessage(object.getJsonObject(i).getString("Message"));
			m.setNbPlaceDispo(object.getJsonObject(i).getInt("NbPlaceDispo"));
			m.setDaily(object.getJsonObject(i).getBoolean("Daily"));
			m.setWeekly(object.getJsonObject(i).getBoolean("Weekly"));
			m.setEveryWeekDay(object.getJsonObject(i).getBoolean("EveryWeekDay"));
			m.setOthers(object.getJsonObject(i).getBoolean("Others"));

			lasp.add(m);
		}
		return lasp;

	}

	public List<Kid> GetKidById(int idp) {

		List<Kid> lasp = new ArrayList<Kid>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("http://localhost:44326" + "/api/GetKids?idp=" + idp);

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		// System.out.println(result);
		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			Kid m = new Kid();
			// String dateString;
			m.setIdKid(object.getJsonObject(i).getInt("IdKid"));

			m.setFirstName(object.getJsonObject(i).getString("FirstName"));

			lasp.add(m);
		}

		return lasp;
	}

	public int GetIDKidByNom(String idp) {

		List<Integer> ints = new ArrayList<Integer>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("http://localhost:44326" + "/api/GetIdKid?idp=" + idp);

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		// System.out.println(result);
		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			int m;
			m=object.getInt(i);
			ints.add(m);
		}

		return ints.get(0);
	}

	@Override
	public List<CarPool> GetMyCar(int idp) {
		// Client client = ClientBuilder.newClient();
		// WebTarget target = client.target("http://localhost:31618/api/PubWebApi/");
		// WebTarget hello =target.path("");
		// Response response =hello.request().get();

		// String result=response.readEntity(String.class);

		// PublicationDTO[] pubs = response.readEntity(PublicationDTO[].class);

		// response.close();
		// return pubs;
		List<CarPool> lasps = new ArrayList<CarPool>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("http://localhost:44326"  + "/api/MyCar?idp=" + idp);

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		// System.out.println(result);
		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			CarPool m = new CarPool();
			// String dateString;
			m.setId(object.getJsonObject(i).getInt("Id"));
			m.setIdParent(object.getJsonObject(i).getInt("idParent"));
			m.setIdKid(object.getJsonObject(i).getInt("idKid"));
			m.setTitle(object.getJsonObject(i).getString("Title"));
			m.setFrom(object.getJsonObject(i).getString("From"));
			// m.setCategory(object.getJsonObject(i).getCategory("Category"));
			m.setTo(object.getJsonObject(i).getString("To"));
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			;
			try {
				m.setDatee(format.parse(object.getJsonObject(i).getString("Date")));
				m.setTimee(format.parse(object.getJsonObject(i).getString("Time")));
				// m.setUntilDatee(format.parse(object.getJsonObject(i).getString("UntilDate")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			m.setMessage(object.getJsonObject(i).getString("Message"));
			m.setNbPlaceDispo(object.getJsonObject(i).getInt("NbPlaceDispo"));
			m.setDaily(object.getJsonObject(i).getBoolean("Daily"));
			m.setWeekly(object.getJsonObject(i).getBoolean("Weekly"));
			m.setEveryWeekDay(object.getJsonObject(i).getBoolean("EveryWeekDay"));
			m.setOthers(object.getJsonObject(i).getBoolean("Others"));

			lasps.add(m);
		}

		return lasps;
	}

	@Override
	public void Create(CarPool p) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:44326" + "/api/CarPost");
		WebTarget hello = target.path("");

		Response response = hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON));

		String result = response.readEntity(String.class);
		System.out.println(result);

		response.close();
	}

	@Override
	public void Update(int idcar, CarPool p) {
		// TODO Auto-generated method stub
		CarPool e = new CarPool();
		e.setTitle(p.Title);
		e.setFrom(p.From);
		e.setTo(p.To);
		e.setTime(p.Time);
		e.setDate(p.Date);
		e.setMessage(p.Message);
		e.setNbPlaceDispo(p.NbPlaceDispo);
		e.setDaily(p.Daily);
		e.setWeekly(p.Weekly);
		e.setEveryWeekDay(p.EveryWeekDay);
		e.setOthers(p.Others);
		e.setUntilDate(p.UntilDate);

		System.out.println("iddddddddd" + idcar);
		System.out.println("OK");

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:44326"  + "/api/Car/Put?idcar=" + idcar);
		Response response = target.request().put(Entity.entity(e, MediaType.APPLICATION_JSON));
		System.out.println(response);
	}

	@Override
	public void Delete(CarPool car) {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:44326"  + "/api/CarPoolApi?id=" + car.getId());
		WebTarget hello = target.path("");
		Response res = (Response) hello.request().delete();
	}

}
