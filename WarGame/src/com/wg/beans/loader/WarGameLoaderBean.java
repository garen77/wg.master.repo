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
	
	private static final ServicesFactory sf = new ServicesFactory();
	
	private LoaderService loaderService;
	
	private List<SelectItem> chars;
	
	private String selectedCharacter;
	
	private String userName;
	
	private String password;
	
	private ViewState viewState;
	
	public LoaderService getLoaderService()
	{
		if(loaderService == null)
		{
			loaderService = (LoaderService) sf.getService(LoaderService.SERVICE_NAME);
		}
		return loaderService;
	}
	
	@Override
	public void initActivity() {
		
		if(viewState == null)
		{
			viewState = new LoginState();
		}
			
	}

	public String login()
	{
		String res = "failure";
		boolean loginOk = false;
		UserDTO userDto = new UserDTO();
		userDto.setUserName(userName);
		userDto.setPassword(password);
		loginOk = getLoaderService().login(userDto);
		if(loginOk)
		{
			res = "successful";
		}
		return res;
	}
	
	public String register()
	{
		this.viewState = new RegisterState();
		return "";
	}
	
	public String back()
	{
		return "back";
	}
	
	public String start()
	{
		return "";
	}
	
	public List<SelectItem> getChars() {
		if(chars == null)
		{
			chars = new ArrayList<SelectItem>();

			List<com.wg.model.Character> chs = (List<Character>) getLoaderService().loadAllCharacter();
			if(chs != null && chs.size()>0)
			{
				for(com.wg.model.Character itemCharOb : chs)
				{
					if(itemCharOb != null)
					{
						chars.add(new SelectItem(itemCharOb.getId(),itemCharOb.getDes()));
					}
				}
			}
		}
		return chars;
	}

	public void setChars(List<SelectItem> chars) {
		this.chars = chars;
	}

	public String getSelectedCharacter() {
		return selectedCharacter;
	}

	public void setSelectedCharacter(String selectedCharacter) {
		this.selectedCharacter = selectedCharacter;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ViewState getViewState() {
		return viewState;
	}

	public void setViewState(ViewState viewState) {
		this.viewState = viewState;
	}

}
