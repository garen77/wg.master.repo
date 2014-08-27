package com.wg.rest.services.api;

import javax.xml.bind.JAXBException;


public interface ILoadUserServices {

	public static final String SERVICE_NAME = "loadUserServices";
	
	public String xmlUser(long idUser)  throws JAXBException;
}
