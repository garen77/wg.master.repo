package com.wg.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import com.wg.dto.UserDTO;
import com.wg.services.api.ILoaderServices;

@Path("/WGRest")
public class WGRest extends RestResource {

	@Path("/users/{idUser}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public UserDTO viewUser(@PathParam("idUser") long idUser) throws JAXBException
	{
		ILoaderServices services = (ILoaderServices)sf.getService(ILoaderServices.SERVICE_NAME);
		return services.loadUser(idUser);
	}
}
