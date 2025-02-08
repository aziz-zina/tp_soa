package webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class HelloRessources {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello(){
        String message =
                "              (\n" +
                "               )\n" +
                "              (\n" +
                "        /\\  .-\"\"\"-.  /\\\n" +
                "       //\\\\/  ,,,  \\//\\\\\n" +
                "       |/\\| ,;;;;;, |/\\|\n" +
                "       //\\\\\\;-\"\"\"-;///\\\\\n" +
                "      //  \\/   .   \\/  \\\\\n" +
                "     (| ,-_| \\ | / |_-, |)\n" +
                "       //`__\\.-.-./__`\\\\\n" +
                "      // /.-(() ())-.\\ \\\\\n" +
                "     (\\ |)   '---'   (| /)\n" +
                "      ` (|           |) `\n" +
                "jgs     \\)           (/";
        return Response.
                status(200).
                entity("Hello Aziz (Your friendly neighborhood spider-man) and Timoumi Iheb <3" + message).
                build();
    }
}
