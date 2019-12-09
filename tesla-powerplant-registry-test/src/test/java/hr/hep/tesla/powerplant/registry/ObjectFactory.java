package hr.hep.tesla.powerplant.registry;

import hr.hep.tesla.powerplant.registry.model.Powerplant;
import hr.hep.tesla.powerplant.registry.model.PowerplantType;
import hr.hep.tesla.powerplant.registry.model.Region;

public class ObjectFactory {

	public static Region createRegon() {
		Region region = new Region();
		region.setName("Test Region");

		return region;
	}

	public static Powerplant createPowerplant() {
		Powerplant powerplant = new Powerplant();
		powerplant.setName("Test Powerplant");
		powerplant.setPower(999);
		powerplant.setType(PowerplantType.COAL);
		powerplant.setRegion(createRegon());

		return powerplant;
	}

}
