package org.jclouds.profitbricks.features;

import org.jclouds.http.filters.BasicAuthentication;
import org.jclouds.profitbricks.http.filters.ProfitBricksSoapMessageEnvelope;
import org.jclouds.rest.annotations.RequestFilters;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestFilters({BasicAuthentication.class, ProfitBricksSoapMessageEnvelope.class})
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface NicApi {

   /* @POST
    @Named("nics:getall")
    @Payload("<ws:getAllNic/>")
    @XMLResponseParser(NicListResponseHandler.class)
*/
}
