package com.sine95.tweetsrv.domain;

import java.io.*;
import java.util.*;
import org.sine95.kernel.util.JSON;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
@SuppressWarnings("unused")
public class J314UserAuthorityId implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "usuario")
	private Long usuario;

	@Column(name = "authority")
	private String authority;

	private J314UserAuthorityId() {}
	
	public J314UserAuthorityId(Long usuario,String authority)
	{
		this();
	this.usuario = usuario;	this.authority = authority;
	}

	public J314UserAuthorityId(String json) throws JsonParseException, JsonMappingException, IOException
	{
		this();
		Map<String,Object> map = JSON.parseMap(json);

	
		this.usuario = Long.decode(map.get("usuario").toString());
	
		this.authority = map.get("authority").toString();

	}


  public void setUsuario(Long valor){
    this.usuario=valor;
  }

  public void usuario(Long valor){
    this.usuario=valor;
  }

  public Long getUsuario(){
    return this.usuario;
  }

  public void setAuthority(String valor){
    this.authority=valor;
  }

  public void authority(String valor){
    this.authority=valor;
  }

  public String getAuthority(){
    return this.authority;
  }
		
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        J314UserAuthorityId that = (J314UserAuthorityId) o;
        return 

      Objects.equals(usuario, that.usuario)
&&
      Objects.equals(authority, that.authority)
;		
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(

      usuario
,
      authority
		
			);
  }

//Si hay que a�adir m�todos se incluyen aqu�, se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

