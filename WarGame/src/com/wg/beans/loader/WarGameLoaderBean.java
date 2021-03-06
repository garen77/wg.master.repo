package com.wg.beans.loader;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.wg.model.Character;
import com.wg.services.factory.ServicesFactory;
import com.wg.services.spi.LoaderService;

@Service(value = WarGameLoaderBean.BEAN_NAME)
@Scope(value = "session")
public class WarGameLoaderBean extends BaseBean{

	public static final String BEAN_NAME= "warGameLoaderBean";
	
	private static final ServicesFactory sf = new ServicesFactory();
	
	private LoaderService loaderService;
	
	private List<SelectItem> chars;
	
	private String selectedCharacter;
	
	
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
		// TODO Auto-generated method stub
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
			
	}

	public String start()
	{
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
		return "";
	}
	
	public List<SelectItem> getChars() {
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

}
