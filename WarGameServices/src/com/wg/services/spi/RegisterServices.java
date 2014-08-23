package com.wg.services.spi;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wg.assembler.UserAssembler;
import com.wg.dao.spi.UserDao;
import com.wg.dto.UserDTO;
import com.wg.model.User;
import com.wg.result.RegisterResult;
import com.wg.services.api.IRegisterServices;

@Service(value=RegisterServices.SERVICE_NAME)
@Transactional
public class RegisterServices implements IRegisterServices {

	
	
	@Autowired
	private UserDao userDao;

	@Override
	public RegisterResult register(UserDTO userDto) throws IllegalArgumentException, IllegalAccessException
	{		
		RegisterResult result = new RegisterResult();
		UserAssembler assembler = new UserAssembler();
		User user = new User();
		assembler.fromDto(user, userDto);
		List<User> users = userDao.findByCriteria(user);
		if(users == null ||users.size()==0)
		{
			try
			{
				userDao.save(user);
			}
			catch(HibernateException he)
			{
				result.setMessage(he.getMessage());
			}
			if(result.getMessage() == null)
			{
				result.setRegisterOperation(true);
			}
		}
		else if(users != null && users.size()==1)
		{
			result.setMessage("User already registered");
		}
		return result;
	}

}
