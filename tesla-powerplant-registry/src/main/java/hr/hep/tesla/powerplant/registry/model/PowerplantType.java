package hr.hep.tesla.powerplant.registry.model;

public enum PowerplantType {	
	COAL(1),
	HYDRO(2),
	NUCLEAR(3),
	GEOTHERMAL(4),
	SOLAR(5),
	WIND(6),
	BIOMASS(7);
	
	private int value;
	
	PowerplantType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
