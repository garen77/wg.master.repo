package com.wg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="\"User\"")
public class User extends BaseModel {

	@Id
	@SequenceGenerator(name="User_idUser_seq",
	sequenceName="User_idUser_seq",
	allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator="User_idUser_seq")
	@Column(name = "\"idUser\"", updatable=false)
	private String idUser;

	@Column(name="mail")
	private String mail;

	@Column(name="password")
	private String password;

	@Column(name="nick")
	private String nick;
	
	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
