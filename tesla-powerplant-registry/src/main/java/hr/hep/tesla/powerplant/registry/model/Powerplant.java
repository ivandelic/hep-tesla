package hr.hep.tesla.powerplant.registry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "readPowerplant", query = "select P from Powerplant P where P.id = :id")
@NamedQuery(name = "listPowerplants", query = "select P from Powerplant P where P.archived = false order by P.created desc")
public class Powerplant extends TeslaEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private PowerplantType type;

	@Column
	private String name;

	@Column
	private Integer power;

	@ManyToOne(fetch = FetchType.EAGER)
	private Region region;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PowerplantType getType() {
		return type;
	}

	public void setType(PowerplantType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
