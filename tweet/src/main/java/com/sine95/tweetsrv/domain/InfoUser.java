

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import com.sine95.tweetsrv.enums.*;



/**
 */
@SuppressWarnings("unused")
public class InfoUser implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String login;

	private String email;

	private String first_name;

	private String last_name;

	private String image_url;

	private String lang_key;

	public InfoUser()
	{
		super();
	}
	
	public InfoUser(String login,String email,String first_name,String last_name,String image_url,String lang_key)
	{

		setLogin(login);

		setEmail(email);

		setFirst_name(first_name);

		setLast_name(last_name);

		setImage_url(image_url);

		setLang_key(lang_key);

	}

  public InfoUser setLogin(String valor){
    this.login=valor;
    return this;
  }

  public InfoUser login(String valor){
    this.login=valor;
    return this;
  }

  public String getLogin(){
    return this.login;
  }

  public InfoUser setEmail(String valor){
    this.email=valor;
    return this;
  }

  public InfoUser email(String valor){
    this.email=valor;
    return this;
  }

  public String getEmail(){
    return this.email;
  }

  public InfoUser setFirst_name(String valor){
    this.first_name=valor;
    return this;
  }

  public InfoUser first_name(String valor){
    this.first_name=valor;
    return this;
  }

  public String getFirst_name(){
    return this.first_name;
  }

  public InfoUser setLast_name(String valor){
    this.last_name=valor;
    return this;
  }

  public InfoUser last_name(String valor){
    this.last_name=valor;
    return this;
  }

  public String getLast_name(){
    return this.last_name;
  }

  public InfoUser setImage_url(String valor){
    this.image_url=valor;
    return this;
  }

  public InfoUser image_url(String valor){
    this.image_url=valor;
    return this;
  }

  public String getImage_url(){
    return this.image_url;
  }

  public InfoUser setLang_key(String valor){
    this.lang_key=valor;
    return this;
  }

  public InfoUser lang_key(String valor){
    this.lang_key=valor;
    return this;
  }

  public String getLang_key(){
    return this.lang_key;
  }


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InfoUser obj = (InfoUser) o;

		if (obj.getLogin() != getLogin()) {
			if (obj.getLogin() == null || getLogin() == null) return false;
			if (!obj.getLogin().equals(getLogin())) return false;
		}

		if (obj.getEmail() != getEmail()) {
			if (obj.getEmail() == null || getEmail() == null) return false;
			if (!obj.getEmail().equals(getEmail())) return false;
		}

		if (obj.getFirst_name() != getFirst_name()) {
			if (obj.getFirst_name() == null || getFirst_name() == null) return false;
			if (!obj.getFirst_name().equals(getFirst_name())) return false;
		}

		if (obj.getLast_name() != getLast_name()) {
			if (obj.getLast_name() == null || getLast_name() == null) return false;
			if (!obj.getLast_name().equals(getLast_name())) return false;
		}

		if (obj.getImage_url() != getImage_url()) {
			if (obj.getImage_url() == null || getImage_url() == null) return false;
			if (!obj.getImage_url().equals(getImage_url())) return false;
		}

		if (obj.getLang_key() != getLang_key()) {
			if (obj.getLang_key() == null || getLang_key() == null) return false;
			if (!obj.getLang_key().equals(getLang_key())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getLogin()==null?"":getLogin().toString())+(getEmail()==null?"":getEmail().toString())+(getFirst_name()==null?"":getFirst_name().toString())+(getLast_name()==null?"":getLast_name().toString())+(getImage_url()==null?"":getImage_url().toString())+(getLang_key()==null?"":getLang_key().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "InfoUser{" +
			"login=" + getLogin() + ", email=" + getEmail() + ", first_name=" + getFirst_name() + ", last_name=" + getLast_name() + ", image_url=" + getImage_url() + ", lang_key=" + getLang_key() + "}";
	}
	



/*


*/
} // Eliminar


