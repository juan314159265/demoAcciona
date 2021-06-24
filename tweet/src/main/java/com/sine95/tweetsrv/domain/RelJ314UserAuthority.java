
package com.sine95.tweetsrv.domain;

import java.io.Serializable;
//import java.util.*;


/**
* *Comentarios*
*/

@SuppressWarnings("unused")
public class RelJ314UserAuthority implements Serializable
{
	private static final long serialVersionUID = 1L;

	private J314User usuario;

	public void setUsuario(J314User valor){
		this.usuario=valor;
	}
	
	public J314User getUsuario(){
		return this.usuario;
	}


	private J314Authority authority;

	public void setAuthority(J314Authority valor){
		this.authority=valor;
	}
	
	public J314Authority getAuthority(){
		return this.authority;
	}


	private J314UserAuthority j314UserAuthority;
	
	public void setJ314UserAuthority(J314UserAuthority valor)
	{
		this.j314UserAuthority=valor;
	}

	public J314UserAuthority getJ314UserAuthority()
	{
		return j314UserAuthority;
	}
	
	public RelJ314UserAuthority()
	{
		super();
	}
	
	public RelJ314UserAuthority(J314UserAuthority o)
	{
		this();

		this.j314UserAuthority=o;

		this.usuario=o.getUsuario();

		this.authority=o.getAuthority();

	}

//Si hay que añadir métodos se incluyen aquí, se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}
