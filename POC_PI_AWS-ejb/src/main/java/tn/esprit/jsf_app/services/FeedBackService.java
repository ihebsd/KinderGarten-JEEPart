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
import tn.esprit.jsf_app.DTO.FeedBack;
import tn.esprit.jsf_app.interfaces.FeedBackServiceRemote;

@Stateful
@LocalBean
public class FeedBackService  implements FeedBackServiceRemote{

	public String GlobalEndPoint = "kindergartenazure.azurewebsites.net";
	EntityManager em ;
	
	@Override
	public List<FeedBack> GetAll() {
		List<FeedBack> lasp = new ArrayList<FeedBack>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("https://" + GlobalEndPoint + "/api/FeedBack");

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			FeedBack f = new FeedBack();
			f.setFeedBackId(object.getJsonObject(i).getInt("FeedBackId"));
			f.setDescription(object.getJsonObject(i).getString("Description"));
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			;
			try {
				f.setFeedBackDate(format.parse(object.getJsonObject(i).getString("FeedBackDate")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			f.setSentiment(object.getJsonObject(i).getString("sentiment"));
		

			lasp.add(f);
			}
		return lasp;
	}

	@Override
	public void Delete(FeedBack FeedBackId) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("https://" + GlobalEndPoint + "/api/FeedBackApi?id=" + FeedBackId.getFeedBackId());
		WebTarget hello = target.path("");
		Response response = hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();

		System.out.println("LOG DELETED" + response.getStatus());
		String result = response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:" + result);

		response.close();
		
	}

	@Override
	public void Create(FeedBack f) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://" + GlobalEndPoint + "/api/FeedPost");
		WebTarget hello = target.path("");
		Response response = hello.request().post(Entity.entity(f, MediaType.APPLICATION_JSON));

		String result = response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

	@Override
	public void Update(int id, FeedBack f) {
		FeedBack cl = new FeedBack();
		
		cl.setDescription(f.getDescription());
		cl.setFeedBackDate(f.getFeedBackDate());;
		cl.setSentiment(f.getSentiment());

		System.out.println("iddddddddd" + f);
	
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://" + GlobalEndPoint + "/api/FeedBackPut?id="+id);
		Response response = target
		                 .request()
		                 .put(Entity.entity(f, MediaType.APPLICATION_JSON));
		   System.out.println(response);
		
	}

}
