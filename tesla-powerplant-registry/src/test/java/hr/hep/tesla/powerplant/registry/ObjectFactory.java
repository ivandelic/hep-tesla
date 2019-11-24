package hr.hep.tesla.powerplant.registry;

import hr.hep.tesla.powerplant.registry.model.Powerplant;
import hr.hep.tesla.powerplant.registry.model.PowerplantType;
import hr.hep.tesla.powerplant.registry.model.Region;

public class ObjectFactory {

	public static Region createRegon(String name) {
		Region region = new Region();
		region.setName(name);

		return region;
	}

	public static Powerplant createPowerplant(String name, Integer power) {
		Powerplant powerplant = new Powerplant();
		powerplant.setName(name);
		powerplant.setPower(power);
		powerplant.setType(PowerplantType.COAL);
		powerplant.setRegion(createRegon("Istarska Županija"));

		return powerplant;
	}

}
