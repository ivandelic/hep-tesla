package hr.hep.tesla.powerplant.registry.information;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import hr.hep.tesla.powerplant.registry.interfaces.information.IPowerplantRegistryInformation;
import hr.hep.tesla.powerplant.registry.model.Powerplant;

@Dependent
public class PowerplantRegistryInformation implements IPowerplantRegistryInformation {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Powerplant> listPowerplants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Powerplant readPowerplant(Integer id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);

		return readQuery("readPowerplant", parameters, Powerplant.class);
	}

	@Override
	public Powerplant updatePowerplant(Powerplant powerplant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public Powerplant createPowerplant(Powerplant powerplant) {
		powerplant = em.merge(powerplant);
		return powerplant;
	}

	@Override
	public Powerplant deletePowerplant(Powerplant powerplant) {
		return powerplant;
		// TODO Auto-generated method stub

	}

	private <T> T readQuery(String queryName, Map<String, Object> parameters, Class<T> _class) {
		TypedQuery<T> query = (TypedQuery<T>) em.createNamedQuery(queryName, _class);

		for (String item : parameters.keySet())
			query.setParameter(item, parameters.get(item));
		query.setMaxResults(1);

		List<T> results = query.getResultList();

		return results.isEmpty() ? null : results.get(0);
	}
}
