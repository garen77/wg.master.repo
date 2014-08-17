package com.wg.beans.loader;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.wg.beans.BaseBean;
import com.wg.beans.state.LoginState;
import com.wg.beans.state.RegisterState;
import com.wg.beans.state.ViewState;
import com.wg.dto.UserDTO;
import com.wg.model.Character;
import com.wg.services.factory.ServicesFactory;
import com.wg.services.spi.LoaderService;

@Service(value = WarGameLoaderBean.BEAN_NAME)
@Scope(value = "session")
public class WarGameLoaderBean extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6912038048020271313L;

	public static final String BEAN_NAME= "warGameLoaderBean";
	
	
	
	
	
	@Override
	public void initActivity() {
		
		if(viewState == null)
		{
			viewState = new LoginState();
		}
			
	}

	
	
	public String back()
	{
		return "back";
	}
	
	public String start()
	{
		return "";
	}


}
