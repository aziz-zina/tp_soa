package webservices;


import entities.Logement;
import metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(("/logement"))
public class LogementResource {


    private final LogementBusiness logementBusiness;

    public LogementResource() {
        this.logementBusiness = new LogementBusiness();

    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {

        return Response
                .status(200)
                .entity(logementBusiness.getLogements())
                .build();

    }

    @GET
    @Path("/{ref}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByRef(@PathParam("ref") int ref) {
        return Response
                .status(200)
                .entity(logementBusiness.getLogementsByReference(ref))
                .build();

    }

    @GET
    @Path("/all/{ref}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllByRef(@PathParam("ref") int ref) {
        return Response
                .status(200)
                .entity(logementBusiness.getLogementsListeByref(ref))
                .build();

    }

    @DELETE
    @Path("/{ref}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteByRef(@PathParam("ref") int ref) {
        return Response
                .status(200)
                .entity(logementBusiness.deleteLogement(ref))
                .build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Logement logement) {
        return Response
                .status(200)
                .entity(logementBusiness.addLogement(logement))
                .build();

    }

    @POST
    @Path("{ref}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("ref") int ref, Logement logement) {
        return Response
                .status(200)
                .entity(logementBusiness.updateLogement(ref, logement))
                .build();

    }

}