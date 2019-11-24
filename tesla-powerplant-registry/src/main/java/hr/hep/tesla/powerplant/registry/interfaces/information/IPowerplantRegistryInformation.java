package hr.hep.tesla.powerplant.registry.interfaces.information;

import java.util.List;

import hr.hep.tesla.powerplant.registry.model.Powerplant;

public interface IPowerplantRegistryInformation {

	public List<Powerplant> listPowerplants();

	public Powerplant readPowerplant(Integer id);

	public Powerplant updatePowerplant(Powerplant powerplant);

	public Powerplant createPowerplant(Powerplant powerplant);

	public Powerplant deletePowerplant(Powerplant powerplant);
}
