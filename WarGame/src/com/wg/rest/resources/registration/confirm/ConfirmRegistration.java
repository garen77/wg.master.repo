package com.wg.rest.resources.registration.confirm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wg.rest.resources.RestResource;

@Path("/ConfirmRegistration")
public class ConfirmRegistration extends RestResource{

	@Path("{idUser}")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public void viewUser(@PathParam("idUser") long idUser)
	{
		
	}
}
