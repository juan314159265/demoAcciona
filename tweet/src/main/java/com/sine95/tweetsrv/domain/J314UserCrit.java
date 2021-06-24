
package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.List;
import io.github.jhipster.service.filter.*;
import org.sine95.kernel.base.filter.*;

import com.sine95.tweetsrv.enums.*;




@SuppressWarnings("unused")
public class J314UserCrit implements Serializable {
	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private StringFilter created_by;

	private DateFilter created_date;

	private StringFilter last_modified_by;

	private DateFilter last_modified_date;

	public static class SiNoFilter extends Filter< SiNo > {
		private static final long serialVersionUID = 1L;
		@Override
		public List< SiNo > getIn() {
			List< SiNo > in = super.getIn();
			if(in!=null && in.isEmpty())
			{
				return null;
			}
			return in;
		}
	}

	private SiNoFilter activated;

	private StringFilter activation_key;

	private StringFilter login;

	private StringFilter email;

	private StringFilter first_name;

	private StringFilter last_name;

	private StringFilter image_url;

	private StringFilter lang_key;

	private StringFilter password_hash;

	private DateFilter reset_date;

	private StringFilter reset_key;

	private LongFilter tiempoSesion;

	public J314UserCrit setId(LongFilter valor)
	{
		this.id=valor;
		return this;
	}
	
	public J314UserCrit id(LongFilter valor)
	{
		this.id=valor;
		return this;
	}
	
	public LongFilter getId(){
		return this.id;
	}
	
	public LongFilter id(){
		return this.id;
	}

	public J314UserCrit setCreated_by(StringFilter valor)
	{
		this.created_by=valor;
		return this;
	}
	
	public J314UserCrit created_by(StringFilter valor)
	{
		this.created_by=valor;
		return this;
	}
	
	public StringFilter getCreated_by(){
		return this.created_by;
	}
	
	public StringFilter created_by(){
		return this.created_by;
	}

	public J314UserCrit setCreated_date(DateFilter valor)
	{
		this.created_date=valor;
		return this;
	}
	
	public J314UserCrit created_date(DateFilter valor)
	{
		this.created_date=valor;
		return this;
	}
	
	public DateFilter getCreated_date(){
		return this.created_date;
	}
	
	public DateFilter created_date(){
		return this.created_date;
	}

	public J314UserCrit setLast_modified_by(StringFilter valor)
	{
		this.last_modified_by=valor;
		return this;
	}
	
	public J314UserCrit last_modified_by(StringFilter valor)
	{
		this.last_modified_by=valor;
		return this;
	}
	
	public StringFilter getLast_modified_by(){
		return this.last_modified_by;
	}
	
	public StringFilter last_modified_by(){
		return this.last_modified_by;
	}

	public J314UserCrit setLast_modified_date(DateFilter valor)
	{
		this.last_modified_date=valor;
		return this;
	}
	
	public J314UserCrit last_modified_date(DateFilter valor)
	{
		this.last_modified_date=valor;
		return this;
	}
	
	public DateFilter getLast_modified_date(){
		return this.last_modified_date;
	}
	
	public DateFilter last_modified_date(){
		return this.last_modified_date;
	}

	public J314UserCrit setActivated(SiNoFilter valor)
	{
		this.activated=valor;
		return this;
	}
	
	public J314UserCrit activated(SiNoFilter valor)
	{
		this.activated=valor;
		return this;
	}
	
	public SiNoFilter getActivated(){
		return this.activated;
	}
	
	public SiNoFilter activated(){
		return this.activated;
	}

	public J314UserCrit setActivation_key(StringFilter valor)
	{
		this.activation_key=valor;
		return this;
	}
	
	public J314UserCrit activation_key(StringFilter valor)
	{
		this.activation_key=valor;
		return this;
	}
	
	public StringFilter getActivation_key(){
		return this.activation_key;
	}
	
	public StringFilter activation_key(){
		return this.activation_key;
	}

	public J314UserCrit setLogin(StringFilter valor)
	{
		this.login=valor;
		return this;
	}
	
	public J314UserCrit login(StringFilter valor)
	{
		this.login=valor;
		return this;
	}
	
	public StringFilter getLogin(){
		return this.login;
	}
	
	public StringFilter login(){
		return this.login;
	}

	public J314UserCrit setEmail(StringFilter valor)
	{
		this.email=valor;
		return this;
	}
	
	public J314UserCrit email(StringFilter valor)
	{
		this.email=valor;
		return this;
	}
	
	public StringFilter getEmail(){
		return this.email;
	}
	
	public StringFilter email(){
		return this.email;
	}

	public J314UserCrit setFirst_name(StringFilter valor)
	{
		this.first_name=valor;
		return this;
	}
	
	public J314UserCrit first_name(StringFilter valor)
	{
		this.first_name=valor;
		return this;
	}
	
	public StringFilter getFirst_name(){
		return this.first_name;
	}
	
	public StringFilter first_name(){
		return this.first_name;
	}

	public J314UserCrit setLast_name(StringFilter valor)
	{
		this.last_name=valor;
		return this;
	}
	
	public J314UserCrit last_name(StringFilter valor)
	{
		this.last_name=valor;
		return this;
	}
	
	public StringFilter getLast_name(){
		return this.last_name;
	}
	
	public StringFilter last_name(){
		return this.last_name;
	}

	public J314UserCrit setImage_url(StringFilter valor)
	{
		this.image_url=valor;
		return this;
	}
	
	public J314UserCrit image_url(StringFilter valor)
	{
		this.image_url=valor;
		return this;
	}
	
	public StringFilter getImage_url(){
		return this.image_url;
	}
	
	public StringFilter image_url(){
		return this.image_url;
	}

	public J314UserCrit setLang_key(StringFilter valor)
	{
		this.lang_key=valor;
		return this;
	}
	
	public J314UserCrit lang_key(StringFilter valor)
	{
		this.lang_key=valor;
		return this;
	}
	
	public StringFilter getLang_key(){
		return this.lang_key;
	}
	
	public StringFilter lang_key(){
		return this.lang_key;
	}

	public J314UserCrit setPassword_hash(StringFilter valor)
	{
		this.password_hash=valor;
		return this;
	}
	
	public J314UserCrit password_hash(StringFilter valor)
	{
		this.password_hash=valor;
		return this;
	}
	
	public StringFilter getPassword_hash(){
		return this.password_hash;
	}
	
	public StringFilter password_hash(){
		return this.password_hash;
	}

	public J314UserCrit setReset_date(DateFilter valor)
	{
		this.reset_date=valor;
		return this;
	}
	
	public J314UserCrit reset_date(DateFilter valor)
	{
		this.reset_date=valor;
		return this;
	}
	
	public DateFilter getReset_date(){
		return this.reset_date;
	}
	
	public DateFilter reset_date(){
		return this.reset_date;
	}

	public J314UserCrit setReset_key(StringFilter valor)
	{
		this.reset_key=valor;
		return this;
	}
	
	public J314UserCrit reset_key(StringFilter valor)
	{
		this.reset_key=valor;
		return this;
	}
	
	public StringFilter getReset_key(){
		return this.reset_key;
	}
	
	public StringFilter reset_key(){
		return this.reset_key;
	}

	public J314UserCrit setTiempoSesion(LongFilter valor)
	{
		this.tiempoSesion=valor;
		return this;
	}
	
	public J314UserCrit tiempoSesion(LongFilter valor)
	{
		this.tiempoSesion=valor;
		return this;
	}
	
	public LongFilter getTiempoSesion(){
		return this.tiempoSesion;
	}
	
	public LongFilter tiemposesion(){
		return this.tiempoSesion;
	}

    @Override
    public String toString() {
        return "J314User{" +
        "id=" + getId() +
        ", created_by=" + getCreated_by() +
        ", created_date=" + getCreated_date() +
        ", last_modified_by=" + getLast_modified_by() +
        ", last_modified_date=" + getLast_modified_date() +
        ", activated=" + getActivated() +
        ", activation_key=" + getActivation_key() +
        ", login=" + getLogin() +
        ", email=" + getEmail() +
        ", first_name=" + getFirst_name() +
        ", last_name=" + getLast_name() +
        ", image_url=" + getImage_url() +
        ", lang_key=" + getLang_key() +
        ", password_hash=" + getPassword_hash() +
        ", reset_date=" + getReset_date() +
        ", reset_key=" + getReset_key() +
        ", tiempoSesion=" + getTiempoSesion() +
        
        "}";
    }

//Si hay que annadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}
