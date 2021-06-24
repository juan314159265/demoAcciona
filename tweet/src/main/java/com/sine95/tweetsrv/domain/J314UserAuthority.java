
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;





/**
* *Comentarios*
*/
 
@Entity(name = "J314UserAuthority")
@Table(name = "J314UserAuthority")
@SuppressWarnings("unused")
public class J314UserAuthority implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private J314UserAuthorityId id;



	// Relacion "usuario"; Tipo: MAN; Extremo: A

		@ManyToOne(fetch = FetchType.LAZY)
//		@MapsId("usuario")

		@JoinColumn(name="usuario", insertable=false, updatable=false)

		private J314User usuario;



	public J314UserAuthority setUsuario(J314User valor){
		this.usuario=valor;
		return this;
	}
	
	public J314UserAuthority usuario(J314User valor){
		this.usuario=valor;
		return this;
	}
	
	public J314User getUsuario(){
		return this.usuario;
	}

	public void removeMeFromUsuario()
	{
		getUsuario().getAuthorities().remove(this);
	}


	// Relacion "authority"; Tipo: MAN; Extremo: A

		@ManyToOne(fetch = FetchType.LAZY)
//		@MapsId("authority")

		@JoinColumn(name="authority", insertable=false, updatable=false)

		private J314Authority authority;



	public J314UserAuthority setAuthority(J314Authority valor){
		this.authority=valor;
		return this;
	}
	
	public J314UserAuthority authority(J314Authority valor){
		this.authority=valor;
		return this;
	}
	
	public J314Authority getAuthority(){
		return this.authority;
	}

	public void removeMeFromAuthority()
	{
		getAuthority().getUsers().remove(this);
	}


	public J314UserAuthorityId getId()
	{
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		J314UserAuthority that = (J314UserAuthority)o;
		return Objects.equals(usuario, that.usuario)&&Objects.equals(authority, that.authority);
	}
 
	@Override
	public int hashCode() {
		return Objects.hash(usuario,authority);
  }

	@Override
	public String toString() {
		return "J314UserAuthority{" + "}";
	}
	
	public J314UserAuthority() {}
	
	public J314UserAuthority(J314User usuario,J314Authority authority)
	{
		this();
		this.usuario = usuario;

		this.authority = authority;
		
		this.id = new J314UserAuthorityId(this.usuario.getId(),this.authority.getName());
	}	
	
	public J314UserAuthority setId(J314UserAuthorityId id)
	{
		this.id = new J314UserAuthorityId(id.getUsuario(),id.getAuthority());
		return this;
	}
	
	public void clear()
	{
	
		setUsuario(null);
	
		setAuthority(null);
	
	}
	
}
