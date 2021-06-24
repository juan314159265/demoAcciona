

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

// import com.sine95.tweetsrv.domain.J314UserAuthority;

	import com.sine95.tweetsrv.domain.J314User;
	
import com.sine95.tweetsrv.enums.*;



/**
 */
@SuppressWarnings("unused")
public class J314UserPoj implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String created_by;

	private Date created_date;

	private String last_modified_by;

	private Date last_modified_date;

	private SiNo activated;

	private String activation_key;

	private String login;

	private String email;

	private String first_name;

	private String last_name;

	private String image_url;

	private String lang_key;

	private String password_hash;

	private Date reset_date;

	private String reset_key;

	private Long tiempoSesion;

	public J314UserPoj()
	{
		super();
	}
	
	public J314UserPoj(Long id,String created_by,Date created_date,String last_modified_by,Date last_modified_date,SiNo activated,String activation_key,String login,String email,String first_name,String last_name,String image_url,String lang_key,String password_hash,Date reset_date,String reset_key,Long tiempoSesion)
	{

		setId(id);

		setCreated_by(created_by);

		setCreated_date(created_date);

		setLast_modified_by(last_modified_by);

		setLast_modified_date(last_modified_date);

		setActivated(activated);

		setActivation_key(activation_key);

		setLogin(login);

		setEmail(email);

		setFirst_name(first_name);

		setLast_name(last_name);

		setImage_url(image_url);

		setLang_key(lang_key);

		setPassword_hash(password_hash);

		setReset_date(reset_date);

		setReset_key(reset_key);

		setTiempoSesion(tiempoSesion);

	}

  public J314UserPoj setId(Long valor){
    this.id=valor;
    return this;
  }

  public J314UserPoj id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public J314UserPoj setCreated_by(String valor){
    this.created_by=valor;
    return this;
  }

  public J314UserPoj created_by(String valor){
    this.created_by=valor;
    return this;
  }

  public String getCreated_by(){
    return this.created_by;
  }

  public J314UserPoj setCreated_date(Date valor){
    this.created_date=valor;
    return this;
  }

  public J314UserPoj created_date(Date valor){
    this.created_date=valor;
    return this;
  }

  public Date getCreated_date(){
    return this.created_date;
  }

  public J314UserPoj setLast_modified_by(String valor){
    this.last_modified_by=valor;
    return this;
  }

  public J314UserPoj last_modified_by(String valor){
    this.last_modified_by=valor;
    return this;
  }

  public String getLast_modified_by(){
    return this.last_modified_by;
  }

  public J314UserPoj setLast_modified_date(Date valor){
    this.last_modified_date=valor;
    return this;
  }

  public J314UserPoj last_modified_date(Date valor){
    this.last_modified_date=valor;
    return this;
  }

  public Date getLast_modified_date(){
    return this.last_modified_date;
  }

  public J314UserPoj setActivated(SiNo valor){
    this.activated=valor;
    return this;
  }

  public J314UserPoj activated(SiNo valor){
    this.activated=valor;
    return this;
  }

  public SiNo getActivated(){
    return this.activated;
  }

  public J314UserPoj setActivation_key(String valor){
    this.activation_key=valor;
    return this;
  }

  public J314UserPoj activation_key(String valor){
    this.activation_key=valor;
    return this;
  }

  public String getActivation_key(){
    return this.activation_key;
  }

  public J314UserPoj setLogin(String valor){
    this.login=valor;
    return this;
  }

  public J314UserPoj login(String valor){
    this.login=valor;
    return this;
  }

  public String getLogin(){
    return this.login;
  }

  public J314UserPoj setEmail(String valor){
    this.email=valor;
    return this;
  }

  public J314UserPoj email(String valor){
    this.email=valor;
    return this;
  }

  public String getEmail(){
    return this.email;
  }

  public J314UserPoj setFirst_name(String valor){
    this.first_name=valor;
    return this;
  }

  public J314UserPoj first_name(String valor){
    this.first_name=valor;
    return this;
  }

  public String getFirst_name(){
    return this.first_name;
  }

  public J314UserPoj setLast_name(String valor){
    this.last_name=valor;
    return this;
  }

  public J314UserPoj last_name(String valor){
    this.last_name=valor;
    return this;
  }

  public String getLast_name(){
    return this.last_name;
  }

  public J314UserPoj setImage_url(String valor){
    this.image_url=valor;
    return this;
  }

  public J314UserPoj image_url(String valor){
    this.image_url=valor;
    return this;
  }

  public String getImage_url(){
    return this.image_url;
  }

  public J314UserPoj setLang_key(String valor){
    this.lang_key=valor;
    return this;
  }

  public J314UserPoj lang_key(String valor){
    this.lang_key=valor;
    return this;
  }

  public String getLang_key(){
    return this.lang_key;
  }

  public J314UserPoj setPassword_hash(String valor){
    this.password_hash=valor;
    return this;
  }

  public J314UserPoj password_hash(String valor){
    this.password_hash=valor;
    return this;
  }

  public String getPassword_hash(){
    return this.password_hash;
  }

  public J314UserPoj setReset_date(Date valor){
    this.reset_date=valor;
    return this;
  }

  public J314UserPoj reset_date(Date valor){
    this.reset_date=valor;
    return this;
  }

  public Date getReset_date(){
    return this.reset_date;
  }

  public J314UserPoj setReset_key(String valor){
    this.reset_key=valor;
    return this;
  }

  public J314UserPoj reset_key(String valor){
    this.reset_key=valor;
    return this;
  }

  public String getReset_key(){
    return this.reset_key;
  }

  public J314UserPoj setTiempoSesion(Long valor){
    this.tiempoSesion=valor;
    return this;
  }

  public J314UserPoj tiempoSesion(Long valor){
    this.tiempoSesion=valor;
    return this;
  }

  public Long getTiempoSesion(){
    return this.tiempoSesion;
  }

	public Long getId_()
	{
		return this.id;
	}

	public J314UserPoj(J314User o)
	{
		if (o==null) return;

		this.id = o.getId();

		this.created_by = o.getCreated_by();

		this.created_date = o.getCreated_date();

		this.last_modified_by = o.getLast_modified_by();

		this.last_modified_date = o.getLast_modified_date();

		this.activated = o.getActivated();

		this.activation_key = o.getActivation_key();

		this.login = o.getLogin();

		this.email = o.getEmail();

		this.first_name = o.getFirst_name();

		this.last_name = o.getLast_name();

		this.image_url = o.getImage_url();

		this.lang_key = o.getLang_key();

		this.password_hash = o.getPassword_hash();

		this.reset_date = o.getReset_date();

		this.reset_key = o.getReset_key();

		this.tiempoSesion = o.getTiempoSesion();

	}
	

	public static J314User getModel(J314UserPoj p)
	{

		J314User o = new J314User();

		o.setId(p.getId());

		o.setCreated_by(p.getCreated_by());

		o.setCreated_date(p.getCreated_date());

		o.setLast_modified_by(p.getLast_modified_by());

		o.setLast_modified_date(p.getLast_modified_date());

		o.setActivated(p.getActivated());

		o.setActivation_key(p.getActivation_key());

		o.setLogin(p.getLogin());

		o.setEmail(p.getEmail());

		o.setFirst_name(p.getFirst_name());

		o.setLast_name(p.getLast_name());

		o.setImage_url(p.getImage_url());

		o.setLang_key(p.getLang_key());

		o.setPassword_hash(p.getPassword_hash());

		o.setReset_date(p.getReset_date());

		o.setReset_key(p.getReset_key());

		o.setTiempoSesion(p.getTiempoSesion());

		return o;
	}

	public static List< J314User > toModelList(List< J314UserPoj > l)
	{
		ArrayList< J314User > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< J314UserPoj > it = l.iterator();
			while(it.hasNext())
			{
				J314UserPoj o = it.next();
				if (o!=null)
				{
					J314User m = getModel(o);
					res.add(m);
				}
			}
		}
		return res;
	}
	

	public static List< J314UserPoj > toPOJOList(List< J314User > l)
	{
		ArrayList< J314UserPoj > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< J314User > it = l.iterator();
			while(it.hasNext())
			{
				J314User o = it.next();
				if (o!=null)
				{
					J314UserPoj m = new J314UserPoj(o);
					res.add(m);
				}
			}
		}
		return res;
	}

	public static Page< J314UserPoj > toPOJOPage(Page< J314User > p)
	{
		if (p==null) return null;
		List< J314User > l = p.getContent();
		List< J314UserPoj > ll  = toPOJOList(l);
		PageImpl< J314UserPoj > pageImpl = new PageImpl<>(ll,p.getPageable(),p.getTotalElements());
		
		Page< J314UserPoj > res = pageImpl;

		return res;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		J314UserPoj obj = (J314UserPoj) o;

		if (obj.getId() != getId()) {
			if (obj.getId() == null || getId() == null) return false;
			if (!obj.getId().equals(getId())) return false;
		}

		if (obj.getCreated_by() != getCreated_by()) {
			if (obj.getCreated_by() == null || getCreated_by() == null) return false;
			if (!obj.getCreated_by().equals(getCreated_by())) return false;
		}

		if (obj.getCreated_date() != getCreated_date()) {
			if (obj.getCreated_date() == null || getCreated_date() == null) return false;
			if (!obj.getCreated_date().equals(getCreated_date())) return false;
		}

		if (obj.getLast_modified_by() != getLast_modified_by()) {
			if (obj.getLast_modified_by() == null || getLast_modified_by() == null) return false;
			if (!obj.getLast_modified_by().equals(getLast_modified_by())) return false;
		}

		if (obj.getLast_modified_date() != getLast_modified_date()) {
			if (obj.getLast_modified_date() == null || getLast_modified_date() == null) return false;
			if (!obj.getLast_modified_date().equals(getLast_modified_date())) return false;
		}

		if (obj.getActivated() != getActivated()) {
			if (obj.getActivated() == null || getActivated() == null) return false;
			if (!obj.getActivated().equals(getActivated())) return false;
		}

		if (obj.getActivation_key() != getActivation_key()) {
			if (obj.getActivation_key() == null || getActivation_key() == null) return false;
			if (!obj.getActivation_key().equals(getActivation_key())) return false;
		}

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

		if (obj.getPassword_hash() != getPassword_hash()) {
			if (obj.getPassword_hash() == null || getPassword_hash() == null) return false;
			if (!obj.getPassword_hash().equals(getPassword_hash())) return false;
		}

		if (obj.getReset_date() != getReset_date()) {
			if (obj.getReset_date() == null || getReset_date() == null) return false;
			if (!obj.getReset_date().equals(getReset_date())) return false;
		}

		if (obj.getReset_key() != getReset_key()) {
			if (obj.getReset_key() == null || getReset_key() == null) return false;
			if (!obj.getReset_key().equals(getReset_key())) return false;
		}

		if (obj.getTiempoSesion() != getTiempoSesion()) {
			if (obj.getTiempoSesion() == null || getTiempoSesion() == null) return false;
			if (!obj.getTiempoSesion().equals(getTiempoSesion())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getId()==null?"":getId().toString())+(getCreated_by()==null?"":getCreated_by().toString())+(getCreated_date()==null?"":getCreated_date().toString())+(getLast_modified_by()==null?"":getLast_modified_by().toString())+(getLast_modified_date()==null?"":getLast_modified_date().toString())+(getActivated()==null?"":getActivated().toString())+(getActivation_key()==null?"":getActivation_key().toString())+(getLogin()==null?"":getLogin().toString())+(getEmail()==null?"":getEmail().toString())+(getFirst_name()==null?"":getFirst_name().toString())+(getLast_name()==null?"":getLast_name().toString())+(getImage_url()==null?"":getImage_url().toString())+(getLang_key()==null?"":getLang_key().toString())+(getPassword_hash()==null?"":getPassword_hash().toString())+(getReset_date()==null?"":getReset_date().toString())+(getReset_key()==null?"":getReset_key().toString())+(getTiempoSesion()==null?"":getTiempoSesion().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "J314UserPoj{" +
			"id=" + getId() + ", created_by=" + getCreated_by() + ", created_date=" + getCreated_date() + ", last_modified_by=" + getLast_modified_by() + ", last_modified_date=" + getLast_modified_date() + ", activated=" + getActivated() + ", activation_key=" + getActivation_key() + ", login=" + getLogin() + ", email=" + getEmail() + ", first_name=" + getFirst_name() + ", last_name=" + getLast_name() + ", image_url=" + getImage_url() + ", lang_key=" + getLang_key() + ", password_hash=" + getPassword_hash() + ", reset_date=" + getReset_date() + ", reset_key=" + getReset_key() + ", tiempoSesion=" + getTiempoSesion() + "}";
	}
	



/*


*/
} // Eliminar


