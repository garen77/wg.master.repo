package com.wg.services.spi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wg.assembler.UserAssembler;
import com.wg.dao.spi.CharacterDao;
import com.wg.dao.spi.UserDao;
import com.wg.dto.UserDTO;
import com.wg.model.BaseModel;
import com.wg.model.User;
import com.wg.services.api.ILoaderServices;
import com.wg.services.api.ILoginServices;

@Service(value=LoaderService.SERVICE_NAME)
@Transactional
public class LoaderService extends GenericService implements ILoaderServices,ILoginServices {

	public static final String SERVICE_NAME = "loaderService";

	@Autowired
	private CharacterDao characterDao;

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<? extends BaseModel> loadAllCharacter() {
		// TODO Auto-generated method stub
		return characterDao.findAll(new com.wg.model.Character());
	}

	@Override
	public boolean login(UserDTO userDto) {
		UserAssembler assembler = new UserAssembler();
		User user = new User();
		assembler.fromDto(user, userDto);
		List<com.wg.model.User> lst = userDao.findAll(user);
		return lst != null && lst.size() ==1;
	}
	
	
	
}
