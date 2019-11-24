package hr.hep.tesla.powerplant.registry.interfaces.integration;

import javax.ws.rs.core.Response;

import hr.hep.tesla.powerplant.registry.model.Powerplant;

public interface IPowerplantRegistryService {

	public Response listPowerplants();

	public Powerplant readPowerplant(Integer id);

	public Response updatePowerplant(Powerplant powerplant);

	public Powerplant createPowerplant(Powerplant powerplant);

	public Response deletePowerplant(Powerplant powerplant);

}
