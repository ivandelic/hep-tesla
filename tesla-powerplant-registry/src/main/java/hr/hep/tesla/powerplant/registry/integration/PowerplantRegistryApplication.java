package hr.hep.tesla.powerplant.registry.integration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/")
public class PowerplantRegistryApplication extends Application {

    private final Set<Class<?>> classes;

    public PowerplantRegistryApplication() {
        super();
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(PowerplantRegistryService.class);
        this.classes = Collections.unmodifiableSet(classes);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return this.classes;
    }
}