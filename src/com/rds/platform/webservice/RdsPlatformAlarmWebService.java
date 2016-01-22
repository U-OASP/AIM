package com.rds.platform.webservice;

import java.io.Serializable;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rds.platform.webservice.model.RdsPlatformWsResultModel;

/**
 * 告警ws处理接口
 * 
 * restful版
 * 
 * @author chenwei
 *
 */

@Produces( { MediaType.APPLICATION_JSON })
public interface RdsPlatformAlarmWebService extends Serializable {
	
	@POST
	@Path("/sendAlarms")
	public RdsPlatformWsResultModel sendAlarms(@FormParam("alarms") String alarms);
	
	@GET
	@Path("/demo/{number}")
	Object queryDemo(@PathParam(value = "number") String number);
	
	@POST
	@Path("/updateAlarms")
	public RdsPlatformWsResultModel updateAlarms(@FormParam("alarms") String alarms);
}
