package com.wg.services.api;

import com.wg.dto.UserDTO;

public interface ILoginServices {

	public boolean login(UserDTO userDto)  throws IllegalArgumentException, IllegalAccessException;
	
}
