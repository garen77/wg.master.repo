package com.wg.beans;


import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.wg.beans.loader.WarGameLoaderBean;
import com.wg.beans.state.ViewState;
import com.wg.services.factory.ServicesFactory;
import com.wg.services.spi.LoaderService;
import com.wg.spring.beans.SpringBeans;

public abstract class BaseBean implements Serializable{

	private static final ServicesFactory sf = new ServicesFactory();

	private LoaderService loaderService;

	
	private WarGameLoaderBean warGameLoaderBean;

	protected ViewState viewState;

	public LoaderService getLoaderService()
	{
		if(loaderService == null)
		{
			loaderService = (LoaderService) sf.getService(LoaderService.SERVICE_NAME);
		}
		return loaderService;
	}
	
	public WarGameLoaderBean getWarGameLoaderBean()
	{
		if(warGameLoaderBean == null)
		{
			warGameLoaderBean = (WarGameLoaderBean)SpringBeans.getBean(WarGameLoaderBean.BEAN_NAME);
		}
		return warGameLoaderBean;
	}
	
	@PostConstruct
	public void init()
	{
		initActivity();
	}
	
	public abstract void initActivity();

	public ViewState getViewState() {
		return viewState;
	}

	public void setViewState(ViewState viewState) {
		this.viewState = viewState;
	}

}
