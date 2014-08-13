package com.wg.services.spi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wg.dao.spi.CharacterDao;
import com.wg.dto.UserDTO;
import com.wg.model.BaseModel;
import com.wg.services.api.ILoaderServices;
import com.wg.services.api.ILoginServices;

@Service(value=LoaderService.SERVICE_NAME)
@Transactional
public class LoaderService implements ILoaderServices,ILoginServices {

	public static final String SERVICE_NAME = "loaderService";

	@Autowired
	private CharacterDao characterDao;

	@Override
	public List<? extends BaseModel> loadAllCharacter() {
		// TODO Auto-generated method stub
		return characterDao.findAll(new com.wg.model.Character());
	}

	@Override
	public boolean login(UserDTO userDto) {
		
		return false;
	}
	
	
	
}
