package hr.hep.tesla.powerplant.registry.interfaces.information;

import java.util.List;

import hr.hep.tesla.common.exception.TeslaException;
import hr.hep.tesla.powerplant.registry.model.Powerplant;
import hr.hep.tesla.powerplant.registry.model.Region;

public interface IPowerplantRegistryInformation {

	public List<Powerplant> listPowerplants();

	public Powerplant readPowerplant(Integer id);

	public Powerplant updatePowerplant(Powerplant powerplant) throws TeslaException;

	public Powerplant createPowerplant(Powerplant powerplant) throws TeslaException;

	public Powerplant deletePowerplant(Integer id) throws TeslaException;

	public List<Region> listRegions();

	public Region readRegion(Integer id);

	public Region updateRegion(Region region) throws TeslaException;

	public Region createRegion(Region region) throws TeslaException;

	public Region deleteRegion(Integer id) throws TeslaException;
}
