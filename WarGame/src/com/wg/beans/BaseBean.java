package com.wg.beans;


import java.io.Serializable;

import javax.annotation.PostConstruct;

import com.wg.beans.state.ViewState;
import com.wg.services.factory.ServicesFactory;
import com.wg.services.spi.LoaderService;

public abstract class BaseBean implements Serializable{

	private static final ServicesFactory sf = new ServicesFactory();

	private LoaderService loaderService;

	protected ViewState viewState;

	public LoaderService getLoaderService()
	{
		if(loaderService == null)
		{
			loaderService = (LoaderService) sf.getService(LoaderService.SERVICE_NAME);
		}
		return loaderService;
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
