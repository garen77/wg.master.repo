package com.wg.rest.resources.registration.confirm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import com.wg.rest.resources.RestResource;
import com.wg.rest.services.api.ILoadUserServices;

@Path("/ConfirmRegistration")
public class ConfirmRegistration extends RestResource{

	@Path("{idUser}")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public String viewUser(@PathParam("idUser") long idUser) throws JAXBException
	{
		ILoadUserServices loaderServices = (ILoadUserServices)sf.getService(ILoadUserServices.SERVICE_NAME);
		return loaderServices.xmlUser(idUser);
	}
}
