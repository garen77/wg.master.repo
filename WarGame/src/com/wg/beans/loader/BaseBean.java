package com.wg.beans.loader;

import javax.annotation.PostConstruct;

public abstract class BaseBean {
	
	@PostConstruct
	public void init()
	{
		initActivity();
	}
	
	public abstract void initActivity();

}
