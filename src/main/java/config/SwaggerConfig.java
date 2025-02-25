package config;

import io.swagger.jaxrs.config.BeanConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class SwaggerConfig extends Application implements ServletContextListener {

    public SwaggerConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8085");
        beanConfig.setBasePath("/LogementRendezVous_Etudiant_war/api");
        beanConfig.setResourcePackage("webservices"); // Change this if your resources are in a different package
        beanConfig.setScan(true);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {}

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }
}
