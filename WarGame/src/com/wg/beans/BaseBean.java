package com.wg.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;

public abstract class BaseBean implements Serializable{
	
	@PostConstruct
	public void init()
	{
		initActivity();
	}
	
	public abstract void initActivity();

}
