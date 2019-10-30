package javafiles;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ServerHallDBService")
public class ServerHallDBService 
{

    private static ServerHallDBDao serverDao = new ServerHallDBDao();

    @GET
    @Path("/hi")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() 
    {

        return "Jag lever!";
    }

    @GET
    @Path("/temperature/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Temp> getLatestTemperature() 
    {
        return serverDao.getLatestTemperature();
    }

    @GET
    @Path("/elforbrukning/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ElForbrukning> getLatestElForbrukning() 
    {
        return serverDao.getLatestElForbrukning();
    }

    @GET
    @Path("/elkostnad/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ElKostnad> getelkostnad() 
    {
        return serverDao.getelkostnad();
    }

    @POST
    @Path("/temperature/add")
    public Response insertTemp(Temp t) 
    {

        Response res = new Response("Ny Temperature added", Boolean.FALSE);

        serverDao.insertTemp(t);
        res.setStatus(Boolean.TRUE);
        return res;

    }

    @POST
    @Path("/elkostnad/add")
    public Response insertelkostnad(ElKostnad t) 
    {

        Response res = new Response("Ny elkostnad added", Boolean.FALSE);

        serverDao.insertelkostnad(t);
        res.setStatus(Boolean.TRUE);
        return res;

    }
    
    @GET
    @Path("/temperature/avg")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GenomsnittTemp> RapportGenomSnittMinMax()
    {
        return serverDao.RapportGenomSnittMinMax();
    }
    
    @GET
    @Path("/elforbrukning/avg")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GenomsnittElForbrukning> RapportGenomsnittElForbrukning()
    {
        return serverDao.RapportGenomsnittElForbrukning();
    }
}