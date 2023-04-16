package controller;

import resource.*;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/composting")
public class ApplicationController extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet supportedResources = new HashSet<Class<?>>();
        supportedResources.add(ServicesV1.class);
        supportedResources.add(ServicesV2.class);
        supportedResources.add(ServicesV3.class);
        supportedResources.add(MaterialsV1.class);
        supportedResources.add(MaterialsV2.class);
        supportedResources.add(MaterialsV3.class);
        supportedResources.add(PeriodsV1.class);
        supportedResources.add(PeriodsV2.class);
        supportedResources.add(PeriodsV3.class);
        supportedResources.add(PricesV1.class);
        supportedResources.add(PricesV2.class);
        supportedResources.add(PricesV3.class);
        return supportedResources;
    }
}