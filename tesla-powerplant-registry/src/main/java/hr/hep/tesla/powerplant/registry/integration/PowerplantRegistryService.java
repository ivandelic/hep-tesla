package hr.hep.tesla.powerplant.registry.integration;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import hr.hep.tesla.powerplant.registry.information.PowerplantRegistryInformation;
import hr.hep.tesla.powerplant.registry.interfaces.integration.IPowerplantRegistryService;
import hr.hep.tesla.powerplant.registry.model.Powerplant;

@Path("/powerplant-registry")
@RequestScoped
public class PowerplantRegistryService implements IPowerplantRegistryService {

	@Inject
	private PowerplantRegistryInformation pri;

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	@GET
	@Override
	public Response listPowerplants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/powerplant/{id}")
	@GET
	@Override
	public Powerplant readPowerplant(@PathParam("id") Integer id) {
		Powerplant powerplant = pri.readPowerplant(id);
		return powerplant;
	}

	@Override
	public Response updatePowerplant(Powerplant powerplant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/powerplant/")
	@POST
	@Operation(summary = "Test", description = "Test")
	@Override
	public Powerplant createPowerplant(Powerplant powerplant) {
		return pri.createPowerplant(powerplant);
	}

	@Override
	public Response deletePowerplant(Powerplant powerplant) {
		// TODO Auto-generated method stub
		return null;
	}
}
