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

import tn.esprit.jsf_app.DTO.Claim;
import tn.esprit.jsf_app.DTO.KinderGarten;
import tn.esprit.jsf_app.interfaces.ClaimServiceRemote;

@Stateful
@LocalBean
public class ClaimService implements ClaimServiceRemote {

	public String GlobalEndPoint = "localhost:44326";
	EntityManager em ;
	
	public ClaimService() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Claim> GetAll() {
		List<Claim> lasp = new ArrayList<Claim>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("http://" + GlobalEndPoint + "/api/Claim");

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			Claim m = new Claim();
			m.setComplaintId(object.getJsonObject(i).getInt("ComplaintId"));
			m.setDescription(object.getJsonObject(i).getString("Description"));
			m.setName(object.getJsonObject(i).getString("Name"));
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			;
			try {
				m.setClaimDate(format.parse(object.getJsonObject(i).getString("ClaimDate")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			m.setClaimType(object.getJsonObject(i).getString("ClaimType"));
			m.setStatus(object.getJsonObject(i).getString("status"));
		

			lasp.add(m);
		}
		System.out.println("icii method");
		return lasp;
	}
	@Override
	public void Delete(Claim ComplaintId) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://" + GlobalEndPoint + "/api/ClaimDelete?id=" + ComplaintId.getComplaintId());
		WebTarget hello = target.path("");
		Response response = hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();

		System.out.println("LOG DELETED" + response.getStatus());
		String result = response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:" + result);

		response.close();
		
	}
	@Override
	public void Create(Claim c) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://" + GlobalEndPoint + "/api/ClaimPost");
		WebTarget hello = target.path("");
		Response response = hello.request().post(Entity.entity(c, MediaType.APPLICATION_JSON));

		String result = response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}
	@Override
	public void Update(int id, Claim c) {
		Claim cl = new Claim();

		cl.setName(c.getName());
		cl.setDescription(c.getDescription());
		cl.setClaimDate(c.getClaimDate());
		cl.setClaimType(c.getClaimType());
		cl.setStatus(c.getStatus());

		System.out.println("iddddddddd" + c);

		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://" + GlobalEndPoint + "/api/KinderGarten/Put?id="+id);
		Response response = target
		                 .request()
		                 .put(Entity.entity(c, MediaType.APPLICATION_JSON));
		   System.out.println(response);
		
	}
	
	

}
