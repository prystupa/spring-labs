package com.prystupa;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.Map;

@Produces(value = {"application/json", "application/xml"})
@Path(value = "/AutoStatsService")
public class AutoStatServiceImpl implements IAutoStatService {

    private static final Map<Long, AutoStatistics> stats = new HashMap<Long, AutoStatistics>();

    static {
        AutoStatistics stat1 = new AutoStatistics(1000001L, "Acura TSX V6", 130F);
        stats.put(stat1.getId(), stat1);
        AutoStatistics stat2 = new AutoStatistics(1000002L, "Alfa Romeo 8C Competizione", 181F);
        stats.put(stat2.getId(), stat2);
        AutoStatistics stat3 = new AutoStatistics(1000003L, "Audi A5 2.0T Quattro", 130F);
        stats.put(stat3.getId(), stat3);
        AutoStatistics stat4 = new AutoStatistics(1000004L, "Cadillac CTS-V", 191F);
        stats.put(stat4.getId(), stat4);
        AutoStatistics stat5 = new AutoStatistics(1000005L, "Chevrolet Camaro SS Coupe", 155F);
        stats.put(stat5.getId(), stat5);
        AutoStatistics stat6 = new AutoStatistics(1000006L, "Nissan 370Z", 155F);
        stats.put(stat6.getId(), stat6);
    }

    @Override
    @GET
    @Path("/autostats/{id}")
    public AutoStatistics getAutoStatistics(@PathParam("id") Long id) {
        return stats.get(id);
    }

    @Override
    @POST
    @Path("/add")
    @Consumes({"application/json", "application/xml"})
    public AutoStatistics addAutoStatistics(AutoStatistics autoStatistics) {
        stats.put(autoStatistics.getId(), autoStatistics);
        return autoStatistics;
    }
}
