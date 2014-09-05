package com.wg.beans;

import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.icesoft.faces.context.effects.JavascriptContext;

@Service(value = HomeBean.BEAN_NAME)
@Scope(value = "request")
public class HomeBean extends BaseBean {

	public static final String BEAN_NAME= "homeBean";
	
	@Override
	public void initActivity() {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		JavascriptContext.includeLib("/skins/js/json2.js", fc);
		JavascriptContext.includeLib("/skins/js/Underscore.js", fc);
		JavascriptContext.includeLib("/skins/js/Backbone.js", fc);

	}

}
