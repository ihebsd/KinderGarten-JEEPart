package tn.esprit.jsf_app.services;

import java.io.StringReader;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.jsf_app.DTO.User;
import tn.esprit.jsf_app.interfaces.UserServiceRemote;

public class UserService implements UserServiceRemote {
	public String GlobalEndPoint = "localhost:44326";

	@Override
	public User Login(String email, String password) {
		List<User> users = new ArrayList<User>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client
				.target("http://" + GlobalEndPoint + "/api/Login/Login?email=" + email + "&password=" + password);

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			User user = new User();
			user.setIdUser(object.getJsonObject(i).getInt("idUser"));
			try {
				user.setNom(object.getJsonObject(i).getString("nom"));
				user.setPrenom(object.getJsonObject(i).getString("prenom"));
				user.setPassword(object.getJsonObject(i).getString("password"));
				user.setConfirmpassword(object.getJsonObject(i).getString("Confirmpassword"));
				user.setEmail(object.getJsonObject(i).getString("email"));

				user.setLogin(object.getJsonObject(i).getString("login"));

			} catch (Exception e) {
			}
			users.add(user);

		}

		return users.get(0);
	}

	public boolean VerifyAccount(String id) {
		List<Boolean> bools = new ArrayList<Boolean>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("http://" + GlobalEndPoint + "/api/LoginApi/VerifyAccount?id=" + id);

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

	public boolean Verify(String id) {
		List<Boolean> bools = new ArrayList<Boolean>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("http://" + GlobalEndPoint + "/api/LoginApi/Verify?id=" + id);

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
	public void Register(User user) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://" + GlobalEndPoint + "/api/Login/Register");
		WebTarget hello = target.path("");
		Response response = hello.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));

		String result = response.readEntity(String.class);
		System.out.println(result);

		response.close();

	}

	public void ForgotPassword(User user) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:44326/api/LoginApi/ForgotPassword");
		WebTarget hello = target.path("");
		Response response = hello.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));

		String result = response.readEntity(String.class);
		System.out.println(result);

		response.close();

	}
	public void ResetPassword(User user) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:44326/api/LoginApi/ResetPassword");
		WebTarget hello = target.path("");
		Response response = hello.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));

		String result = response.readEntity(String.class);
		System.out.println(result);

		response.close();

	}
	public User GetUserById(int id) {
		List<User> users = new ArrayList<User>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client
				.target("http://" + GlobalEndPoint + "/api/GetUserById?id=" + id);

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			User user = new User();
			user.setIdUser(object.getJsonObject(i).getInt("idUser"));
			try {
				user.setNom(object.getJsonObject(i).getString("nom"));
				user.setPrenom(object.getJsonObject(i).getString("prenom"));
				user.setPassword(object.getJsonObject(i).getString("password"));
				user.setConfirmpassword(object.getJsonObject(i).getString("Confirmpassword"));
				user.setEmail(object.getJsonObject(i).getString("email"));

				user.setLogin(object.getJsonObject(i).getString("login"));

			} catch (Exception e) {
			}
			users.add(user);

		}

		return users.get(0);
	}
}
