package tn.esprit.jsf_app.services;


import java.io.StringReader;
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
import tn.esprit.jsf_app.DTO.Event;
import tn.esprit.jsf_app.interfaces.EventServiceRemote;


@Stateful
@LocalBean
public class EventService implements EventServiceRemote {
	
	public String GlobalEndPoint = "localhost:44326"; 
	//https://localhost:44326/4640
	EntityManager em ;
	@Override
	public List<Event> GetAll() {
		//Client client = ClientBuilder.newClient();
		//WebTarget target = client.target("http://localhost:31618/api/PubWebApi/");
		//WebTarget hello =target.path("");
		//Response response =hello.request().get();
		
		//String result=response.readEntity(String.class);
		
		//PublicationDTO[] pubs =  response.readEntity(PublicationDTO[].class);

		//response.close();
		//return pubs;
		List<Event>  lasp = new ArrayList<Event>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:44326/Api/EventWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	
    	 
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Event m = new Event();
    	 //String dateString;
       	 m.setEventId(object.getJsonObject(i).getInt("EventId")); 
    	 m.setName(object.getJsonObject(i).getString("Name")); 
    	 //m.setImage(object.getJsonObject(i).getString("image")); 
    	// m.setCategory(object.getJsonObject(i).getString("Category")); 
    	 m.setDescription(object.getJsonObject(i).getString("Description"));
    	 m.setDateEvent(object.getJsonObject(i).getString("DateEvent"));
    	 m.setHeureF(object.getJsonObject(i).getString("HeureF"));
    	 m.setHeureD(object.getJsonObject(i).getString("HeureD"));
    	 m.setNumber_P(object.getJsonObject(i).getInt("number_P"));

    	
    	 lasp.add(m);
    	}
    	

return lasp;    	
	}

	

	@Override
	public void Create(Event p) {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:44326/api/EventPost");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		
		String result=response.readEntity(String.class);
		System.out.println(result);
		
		

		response.close();		
	}
	
	
	
	
	@Override
	public void Update(int id,Event p) {
		// TODO Auto-generated method stub
		Event e = new Event();
		e.setEventId(p.EventId);
		e.setName(p.Name);
		e.setImage(p.image);
		e.setCategory(p.Category);
		e.setDescription(p.Description);
       e.setDateEvent(p.DateEvent);
       e.setHeureD(p.HeureD);
       e.setHeureF(p.HeureF);
       e.setNumber_P(p.number_P);

        
  		System.out.println("iddddddddd"+id);
  		System.out.println("OK");

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://"+GlobalEndPoint+"/api/EventApi/Put?id="+id);
		Response response = target
		                 .request()
		                 .put(Entity.entity(e, MediaType.APPLICATION_JSON));
		   System.out.println(response);
			}
	
	
	@Override
	public void Delete(Event eve)
	{
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://"+GlobalEndPoint+"/api/EventWebApi?id="+eve.getEventId()); 
		WebTarget hello = target.path("");     	
    	Response res=(Response) hello.request().delete();
	}




	

}
