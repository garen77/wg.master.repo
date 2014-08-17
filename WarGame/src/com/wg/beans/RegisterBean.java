package com.wg.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.wg.beans.state.RegisterState;

@Service(value = RegisterBean.BEAN_NAME)
@Scope(value = "request")
public class RegisterBean extends BaseBean {

	public static final String BEAN_NAME= "registerBean";
	/**
	 * 
	 */
	private static final long serialVersionUID = 5688262858996429268L;

	private String userName;
	
	private String password;

	@Override
	public void initActivity() {
		
		viewState = new RegisterState();

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


}
