package webservices;

import entities.Logement;
import metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/logement/xml")
public class LogementResourceXml {

    private final LogementBusiness logementBusiness;

    public LogementResourceXml() {
        this.logementBusiness = new LogementBusiness();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_XML)
    public Response findAll() {
        List<Logement> logements = logementBusiness.getLogements();
        GenericEntity<List<Logement>> entity = new GenericEntity<>(logements) {
        };
        return Response
                .status(200)
                .entity(entity)
                .build();
    }

    @GET
    @Path("/{ref}")
    @Produces(MediaType.APPLICATION_XML)
    public Response findByRef(@PathParam("ref") int ref) {
        return Response
                .status(200)
                .entity(logementBusiness.getLogementsByReference(ref))
                .build();
    }

    @GET
    @Path("/all/{ref}")
    @Produces(MediaType.APPLICATION_XML)
    public Response findAllByRef(@PathParam("ref") int ref) {
        List<Logement> logements = logementBusiness.getLogementsListeByref(ref);
        GenericEntity<List<Logement>> entity = new GenericEntity<>(logements) {
        };
        return Response
                .status(200)
                .entity(entity)
                .build();
    }

    @DELETE
    @Path("/{ref}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteByRef(@PathParam("ref") int ref) {
        return Response
                .status(200)
                .entity(logementBusiness.deleteLogement(ref))
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response add(Logement logement) {
        return Response
                .status(200)
                .entity(logementBusiness.addLogement(logement))
                .build();
    }

    @POST
    @Path("{ref}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response update(@PathParam("ref") int ref, Logement logement) {
        return Response
                .status(200)
                .entity(logementBusiness.updateLogement(ref, logement))
                .build();
    }
}