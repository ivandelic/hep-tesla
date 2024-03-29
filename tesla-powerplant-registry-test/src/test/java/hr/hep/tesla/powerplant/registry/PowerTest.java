package hr.hep.tesla.powerplant.registry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.helidon.microprofile.server.Server;

class PowerTest {

	private static Server server;

	private static final String REST_URI = "http://localhost:8080/powerplant-registry/powerplant";

	@BeforeAll
	public static void startTheServer() throws Exception {
		server = Server.create().start();
	}

	@Test
	void test_CreatePowerplant() {
		Client client = ClientBuilder.newClient();

		Response response = client.target(REST_URI).request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(ObjectFactory.createPowerplant(), MediaType.APPLICATION_JSON));

		Assertions.assertEquals(Status.OK.getStatusCode(), response.getStatus(), "default message");
	}
}
