
package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.List;
import io.github.jhipster.service.filter.*;
import org.sine95.kernel.base.filter.*;




@SuppressWarnings("unused")
public class SecurityGroupCrit implements Serializable {
	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private StringFilter allowedgroup;

	private StringFilter identifier;

	public SecurityGroupCrit setId(LongFilter valor)
	{
		this.id=valor;
		return this;
	}
	
	public SecurityGroupCrit id(LongFilter valor)
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

	public SecurityGroupCrit setAllowedgroup(StringFilter valor)
	{
		this.allowedgroup=valor;
		return this;
	}
	
	public SecurityGroupCrit allowedgroup(StringFilter valor)
	{
		this.allowedgroup=valor;
		return this;
	}
	
	public StringFilter getAllowedgroup(){
		return this.allowedgroup;
	}
	
	public StringFilter allowedgroup(){
		return this.allowedgroup;
	}

	public SecurityGroupCrit setIdentifier(StringFilter valor)
	{
		this.identifier=valor;
		return this;
	}
	
	public SecurityGroupCrit identifier(StringFilter valor)
	{
		this.identifier=valor;
		return this;
	}
	
	public StringFilter getIdentifier(){
		return this.identifier;
	}
	
	public StringFilter identifier(){
		return this.identifier;
	}

    @Override
    public String toString() {
        return "SecurityGroup{" +
        "id=" + getId() +
        ", allowedgroup=" + getAllowedgroup() +
        ", identifier=" + getIdentifier() +
        
        "}";
    }

//Si hay que annadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}
