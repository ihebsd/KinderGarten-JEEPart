package tn.esprit.jsf_app.services;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

public class MainTest {

	public static void main(String[] args) {
		 String GlobalEndPoint = "localhost:44326";
		 Claim cs = new Claim(13,"azertyr","ahi","On_Teachers");
		 Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://" + GlobalEndPoint + "/api/ClaimPost");
			WebTarget hello = target.path("");
			Response response = hello.request().post(Entity.entity(cs, MediaType.APPLICATION_JSON));
			String result = response.readEntity(String.class);
			System.out.println(result);
		
			response.close();
		}
	

}
