package com.wg.rest.services.spi;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.assembler.UserAssembler;
import com.wg.dao.spi.UserDao;
import com.wg.dto.UserDTO;
import com.wg.model.User;
import com.wg.rest.services.api.ILoadUserServices;

@Service(value = ILoadUserServices.SERVICE_NAME)
public class LoadUserServices extends RestServices<UserDTO> implements ILoadUserServices{

	@Autowired
	private UserDao userDao;
	
	@Override
	public String xmlUser(long idUser) throws JAXBException {
		
		User user = userDao.findByKey(idUser);
		
		UserAssembler assembler = new UserAssembler();
		UserDTO userDto = new UserDTO();
		assembler.toDto(user, userDto);
		return marshallObject(userDto);		
	}

	
}
