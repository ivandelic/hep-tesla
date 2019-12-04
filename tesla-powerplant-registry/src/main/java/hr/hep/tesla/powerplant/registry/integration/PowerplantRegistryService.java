package hr.hep.tesla.powerplant.registry.integration;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import hr.hep.tesla.common.exception.TeslaException;
import hr.hep.tesla.powerplant.registry.information.PowerplantRegistryInformation;
import hr.hep.tesla.powerplant.registry.interfaces.integration.IPowerplantRegistryService;
import hr.hep.tesla.powerplant.registry.model.Powerplant;
import hr.hep.tesla.powerplant.registry.model.Region;

@Path("/powerplant-registry")
@RequestScoped
public class PowerplantRegistryService implements IPowerplantRegistryService {

	@Inject
	private PowerplantRegistryInformation pri;

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/powerplants")
	@GET
	@Override
	public List<Powerplant> listPowerplants() {
		List<Powerplant> powerplants = pri.listPowerplants();
		return powerplants;
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/powerplant/{id}")
	@GET
	@Override
	public Powerplant readPowerplant(@PathParam("id") Integer id) {
		Powerplant powerplant = pri.readPowerplant(id);
		return powerplant;
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/powerplant/")
	@POST
	@Operation(summary = "Update Powerplant", description = "Method updates powerplant.")
	@Override
	public Powerplant updatePowerplant(Powerplant powerplant) throws TeslaException {
		return pri.updatePowerplant(powerplant);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/powerplant/")
	@PUT
	@Operation(summary = "Create Powerplant", description = "Method creates new powerplant.")
	@Override
	public Powerplant createPowerplant(Powerplant powerplant) throws TeslaException {
		return pri.createPowerplant(powerplant);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/powerplant/{id}")
	@DELETE
	@Operation(summary = "Delete Powerplant", description = "Method deletes powerplant.")
	@Override
	public Powerplant deletePowerplant(@PathParam("id") Integer id) throws TeslaException {
		return pri.deletePowerplant(id);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/regions")
	@GET
	@Override
	public List<Region> listRegions() {
		return pri.listRegions();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/region/{id}")
	@GET
	@Override
	public Region readRegion(@PathParam("id") Integer id) {
		Region region = pri.readRegion(id);
		return region;
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/region/")
	@POST
	@Operation(summary = "Update Region", description = "Method updates region.")
	@Override
	public Region updateRegion(Region region) throws TeslaException {
		return pri.updateRegion(region);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/region/")
	@PUT
	@Operation(summary = "Create Region", description = "Method creates new region.")
	@Override
	public Region createRegion(Region region) throws TeslaException {
		return pri.createRegion(region);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/region/{id}")
	@DELETE
	@Operation(summary = "Delete Region", description = "Method deletes region.")
	@Override
	public Region deleteRegion(@PathParam("id") Integer id) throws TeslaException {
		return pri.deleteRegion(id);
	}
}
