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

import tn.esprit.jsf_app.DTO.KinderGarten;
import tn.esprit.jsf_app.interfaces.KinderGartenServiceRemote;

@Stateful
@LocalBean
public class KinderGartenService implements KinderGartenServiceRemote {
	public String GlobalEndPoint = "localhost:44326";
	EntityManager em;

	@Override
	public List<KinderGarten> GetAll() {
		List<KinderGarten> lasp = new ArrayList<KinderGarten>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("http://" + GlobalEndPoint + "/api/KinderGarten");

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			KinderGarten m = new KinderGarten();
			m.setKinderGartenId(object.getJsonObject(i).getInt("KinderGartenId"));
			m.setName(object.getJsonObject(i).getString("Name"));
			m.setImage(object.getJsonObject(i).getString("Image"));
			m.setAddress(object.getJsonObject(i).getString("Address"));
			m.setDescription(object.getJsonObject(i).getString("Description"));
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			;
			try {
				m.setDateCreation(format.parse(object.getJsonObject(i).getString("DateCreation")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			m.setCost(object.getJsonObject(i).getInt("Cost"));
			m.setNbrEmp(object.getJsonObject(i).getInt("NbrEmp"));
			m.setPhone(object.getJsonObject(i).getInt("Phone"));
			m.setLatitude(Double.parseDouble(object.getJsonObject(i).getString("latitude")));
			m.setLongitude(Double.parseDouble(object.getJsonObject(i).getString("longitude")));


			lasp.add(m);
		}

		return lasp;
	}

	@Override
	public void Delete(KinderGarten KinderGarten) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://" + GlobalEndPoint + "/api/KinderGarten/Delete?id=" + KinderGarten.getKinderGartenId());
		WebTarget hello = target.path("");
		Response response = hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();

		System.out.println("LOG DELETED" + response.getStatus());
		String result = response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:" + result);

		response.close();

	}

	@Override
	public void Create(KinderGarten p) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://" + GlobalEndPoint + "/api/KinderGarten/Create");
		WebTarget hello = target.path("");
		Response response = hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON));

		String result = response.readEntity(String.class);
		System.out.println(result);

		response.close();
	}

	@Override
	public void Update(int id, KinderGarten k) {
		KinderGarten km = new KinderGarten();

		km.setName(k.getName());
		km.setImage(k.getImage());
		km.setCost(k.getCost());
		km.setDescription(k.getDescription());
		km.setPhone(k.getPhone());
		km.setNbrEmp(k.getNbrEmp());
		km.setAddress(k.getAddress());

		System.out.println("iddddddddd" + k);

		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://" + GlobalEndPoint + "/api/KinderGarten/Put?id="+id);
		Response response = target
		                 .request()
		                 .put(Entity.entity(k, MediaType.APPLICATION_JSON));
		   System.out.println(response);
	}

}
