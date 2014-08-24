package com.wg.services.spi;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wg.assembler.UserAssembler;
import com.wg.criteria.MailSenderCriteria;
import com.wg.dao.spi.UserDao;
import com.wg.dto.UserDTO;
import com.wg.model.User;
import com.wg.result.MailSenderResult;
import com.wg.result.RegisterResult;
import com.wg.services.api.IMailSenderServices;
import com.wg.services.api.IRegisterServices;
import com.wg.services.factory.ServicesFactory;

@Service(value=IRegisterServices.SERVICE_NAME)
@Transactional
public class RegisterServices extends GenericService implements IRegisterServices {

	
	protected static final ServicesFactory sf = new ServicesFactory();
	
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
				result.getMessages().add(he.getMessage());
			}
			// sending mail
			MailSenderCriteria mailSenderCriteria = new MailSenderCriteria();
			mailSenderCriteria.setFromAddr("pippo@pelo.it");
			mailSenderCriteria.setToAddr(userDto.getMail());
			IMailSenderServices mailSenderServices = (IMailSenderServices)sf.getBean(IMailSenderServices.SERVICE_NAME);
			MailSenderResult mailSenderResult = mailSenderServices.sendMail(mailSenderCriteria);
			
			if((result.getMessages() == null || result.getMessages().isEmpty())
					&&
					(mailSenderResult == null || mailSenderResult.getMessages() == null
					|| mailSenderResult.getMessages().isEmpty()))
			{
				result.setRegisterOperation(true);
			}
		}
		else if(users != null && users.size()==1)
		{
			result.getMessages().add("User already registered");
		}
		return result;
	}

}
