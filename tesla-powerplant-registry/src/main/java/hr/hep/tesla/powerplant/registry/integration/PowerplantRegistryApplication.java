package hr.hep.tesla.powerplant.registry.integration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import hr.hep.tesla.common.exception.TeslaExceptionMapper;
import hr.hep.tesla.powerplant.registry.CORSFilter;

@ApplicationScoped
@ApplicationPath("/")
public class PowerplantRegistryApplication extends Application {

	private final Set<Class<?>> classes;

	public PowerplantRegistryApplication() {
		super();
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(PowerplantRegistryService.class);
		classes.add(TeslaExceptionMapper.class);
		classes.add(CORSFilter.class);
		this.classes = Collections.unmodifiableSet(classes);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return this.classes;
	}
}