package com.wg.services.spi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.dao.spi.CharacterDao;
import com.wg.model.BaseModel;
import com.wg.services.api.IService;

@Service(value=LoaderService.LOADER_SERVICE_NAME)
public class LoaderService implements IService {

	public static final String LOADER_SERVICE_NAME = "loaderService";

	@Autowired
	private CharacterDao characterDao;

	@Override
	public List<? extends BaseModel> loadAllCharacter() {
		// TODO Auto-generated method stub
		return characterDao.findAll();
	}
	
	
	
}
