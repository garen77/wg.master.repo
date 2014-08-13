package com.wg.dao.spi;

import org.springframework.stereotype.Service;

import com.wg.model.User;

@Service
public class UserDao extends GenericAbstractDao<User> {

	@Override
	public User findByKey(int key) {
		// TODO Auto-generated method stub
		return null;
	}

}
