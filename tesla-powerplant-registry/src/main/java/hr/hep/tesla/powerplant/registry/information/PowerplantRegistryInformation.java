package hr.hep.tesla.powerplant.registry.information;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import hr.hep.tesla.common.exception.MessageCode;
import hr.hep.tesla.common.exception.TeslaException;
import hr.hep.tesla.powerplant.registry.interfaces.information.IPowerplantRegistryInformation;
import hr.hep.tesla.powerplant.registry.model.Powerplant;
import hr.hep.tesla.powerplant.registry.model.Region;

@Dependent
public class PowerplantRegistryInformation implements IPowerplantRegistryInformation {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Powerplant> listPowerplants() {
		return queryItems("listPowerplants", null, Powerplant.class);
	}

	@Override
	public Powerplant readPowerplant(Integer id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);

		return querySingleItem("readPowerplant", parameters, Powerplant.class);
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public Powerplant updatePowerplant(Powerplant powerplant) throws TeslaException {
		if (powerplant == null)
			throw new TeslaException(MessageCode.ERROR_GENERAL_MISSING_INPUT_OBJECT);
		if (powerplant.getId() == null)
			throw new TeslaException(MessageCode.ERROR_GENERAL_MISSING_ID_UPDATE);

		powerplant = em.merge(powerplant);

		return powerplant;
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public Powerplant createPowerplant(Powerplant powerplant) throws TeslaException {
		if (powerplant == null)
			throw new TeslaException(MessageCode.ERROR_GENERAL_MISSING_INPUT_OBJECT);
		if (powerplant.getId() != null)
			throw new TeslaException(MessageCode.ERROR_GENERAL_PROVIDED_ID_INSERT);

		powerplant = em.merge(powerplant);

		return powerplant;
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public Powerplant deletePowerplant(Integer id) throws TeslaException {
		if (id == null)
			throw new TeslaException(MessageCode.ERROR_GENERAL_MISSING_ID_DELETE);

		Powerplant powerplant = readPowerplant(id);
		powerplant.setArchived(true);

		powerplant = em.merge(powerplant);

		return powerplant;
	}

	@Override
	public List<Region> listRegions() {
		return queryItems("listRegions", null, Region.class);
	}

	@Override
	public Region readRegion(Integer id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);

		return querySingleItem("readRegion", parameters, Region.class);
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public Region updateRegion(Region region) throws TeslaException {
		if (region == null)
			throw new TeslaException(MessageCode.ERROR_GENERAL_MISSING_INPUT_OBJECT);
		if (region.getId() == null)
			throw new TeslaException(MessageCode.ERROR_GENERAL_MISSING_ID_UPDATE);

		region = em.merge(region);

		return region;
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public Region createRegion(Region region) throws TeslaException {
		if (region == null)
			throw new TeslaException(MessageCode.ERROR_GENERAL_MISSING_INPUT_OBJECT);
		if (region.getId() != null)
			throw new TeslaException(MessageCode.ERROR_GENERAL_PROVIDED_ID_INSERT);

		region = em.merge(region);

		return region;
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public Region deleteRegion(Integer id) throws TeslaException {
		if (id == null)
			throw new TeslaException(MessageCode.ERROR_GENERAL_MISSING_ID_DELETE);

		Region region = readRegion(id);
		region.setArchived(true);

		region = em.merge(region);

		return region;
	}

	private <T> T querySingleItem(String queryName, Map<String, Object> parameters, Class<T> _class) {
		TypedQuery<T> query = (TypedQuery<T>) em.createNamedQuery(queryName, _class);

		for (String item : parameters.keySet())
			query.setParameter(item, parameters.get(item));
		query.setMaxResults(1);

		List<T> results = query.getResultList();

		return results.isEmpty() ? null : results.get(0);
	}

	private <T> List<T> queryItems(String queryName, Map<String, Object> parameters, Class<T> _class) {
		TypedQuery<T> query = (TypedQuery<T>) em.createNamedQuery(queryName, _class);

		if (parameters != null)
			for (String item : parameters.keySet())
				query.setParameter(item, parameters.get(item));

		return query.getResultList();
	}
}
