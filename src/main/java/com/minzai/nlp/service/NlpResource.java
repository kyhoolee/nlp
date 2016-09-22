package com.minzai.nlp.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.minzai.nlp.api.DateParser;
import com.minzai.nlp.model.NlpDate;
import com.minzai.nlp.utils.LoggerUtil;



@Path("/nlp")
public class NlpResource {
	public static Logger logger = LoggerUtil.getDailyLogger("NlpResource_log");

	
	ObjectMapper mapper = new ObjectMapper();
	public NlpResource() {

	}
	
	@Path("date")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getCityLottery(@QueryParam("source") String source) {


		List<NlpDate> result = DateParser.parseDate(source);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}


}
