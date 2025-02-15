package webservices;

import entities.Logement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/logement", description = "Operations on Logements")
@Path("/logement")
public class LogementResource {

    private final LogementBusiness logementBusiness;

    public LogementResource() {
        this.logementBusiness = new LogementBusiness();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all logements", response = Logement.class, responseContainer = "List")
    public Response findAll() {
        return Response
                .status(200)
                .entity(logementBusiness.getLogements())
                .build();
    }

    @GET
    @Path("/{ref}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get logement by reference", response = Logement.class)
    public Response findByRef(@ApiParam(value = "Reference of the logement", required = true) @PathParam("ref") int ref) {
        return Response
                .status(200)
                .entity(logementBusiness.getLogementsByReference(ref))
                .build();
    }

    @GET
    @Path("/all/{ref}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all logements by reference", response = Logement.class, responseContainer = "List")
    public Response findAllByRef(@ApiParam(value = "Reference of the logements", required = true) @PathParam("ref") int ref) {
        return Response
                .status(200)
                .entity(logementBusiness.getLogementsListeByref(ref))
                .build();
    }

    @DELETE
    @Path("/{ref}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Delete logement by reference")
    public Response deleteByRef(@ApiParam(value = "Reference of the logement to delete", required = true) @PathParam("ref") int ref) {
        return Response
                .status(200)
                .entity(logementBusiness.deleteLogement(ref))
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Add a new logement", response = Boolean.class)
    public Response add(@ApiParam(value = "Logement object to add", required = true) Logement logement) {
        return Response
                .status(200)
                .entity(logementBusiness.addLogement(logement))
                .build();
    }

    @POST
    @Path("{ref}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Update logement by reference", response = Boolean.class)
    public Response update(@ApiParam(value = "Reference of the logement to update", required = true) @PathParam("ref") int ref,
                           @ApiParam(value = "Updated logement object", required = true) Logement logement) {
        return Response
                .status(200)
                .entity(logementBusiness.updateLogement(ref, logement))
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get logements by delegation", response = Logement.class, responseContainer = "List")
    public Response findByAllByDelegation(@ApiParam(value = "Delegation of the logements", required = true) @QueryParam("delegation") String delegation) {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(logementBusiness.getLogementsByDeleguation(delegation))
                .build();
    }
}