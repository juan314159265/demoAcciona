

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

// import com.sine95.tweetsrv.domain.J314Authority;

// import com.sine95.tweetsrv.domain.J314User;

	import com.sine95.tweetsrv.domain.J314UserAuthority;
	


/**
 */
@SuppressWarnings("unused")
public class J314UserAuthorityPoj implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long usuario;

	private String authority;

	public J314UserAuthorityPoj()
	{
		super();
	}
	
	public J314UserAuthorityPoj(Long usuario,String authority)
	{

		setUsuario(usuario);

		setAuthority(authority);

	}

  public J314UserAuthorityPoj setUsuario(Long valor){
    this.usuario=valor;
    return this;
  }

  public J314UserAuthorityPoj usuario(Long valor){
    this.usuario=valor;
    return this;
  }

  public Long getUsuario(){
    return this.usuario;
  }

  public J314UserAuthorityPoj setAuthority(String valor){
    this.authority=valor;
    return this;
  }

  public J314UserAuthorityPoj authority(String valor){
    this.authority=valor;
    return this;
  }

  public String getAuthority(){
    return this.authority;
  }

	public J314UserAuthorityPoj(J314UserAuthority o)
	{
		if (o==null) return;

//		this.usuario = o.getUsuario().getId();
		this.usuario = o.getUsuario()==null?null:o.getUsuario().getId();

//		this.authority = o.getAuthority().getName();
		this.authority = o.getAuthority()==null?null:o.getAuthority().getName();

	}
	

	public static J314UserAuthority getModel(J314UserAuthorityPoj p)
	{

		J314UserAuthority o = new J314UserAuthority();

		return o;
	}

	public static List< J314UserAuthority > toModelList(List< J314UserAuthorityPoj > l)
	{
		ArrayList< J314UserAuthority > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< J314UserAuthorityPoj > it = l.iterator();
			while(it.hasNext())
			{
				J314UserAuthorityPoj o = it.next();
				if (o!=null)
				{
					J314UserAuthority m = getModel(o);
					res.add(m);
				}
			}
		}
		return res;
	}
	

	public static List< J314UserAuthorityPoj > toPOJOList(List< J314UserAuthority > l)
	{
		ArrayList< J314UserAuthorityPoj > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< J314UserAuthority > it = l.iterator();
			while(it.hasNext())
			{
				J314UserAuthority o = it.next();
				if (o!=null)
				{
					J314UserAuthorityPoj m = new J314UserAuthorityPoj(o);
					res.add(m);
				}
			}
		}
		return res;
	}

	public static Page< J314UserAuthorityPoj > toPOJOPage(Page< J314UserAuthority > p)
	{
		if (p==null) return null;
		List< J314UserAuthority > l = p.getContent();
		List< J314UserAuthorityPoj > ll  = toPOJOList(l);
		PageImpl< J314UserAuthorityPoj > pageImpl = new PageImpl<>(ll,p.getPageable(),p.getTotalElements());
		
		Page< J314UserAuthorityPoj > res = pageImpl;

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
		J314UserAuthorityPoj obj = (J314UserAuthorityPoj) o;

		if (obj.getUsuario() != getUsuario()) {
			if (obj.getUsuario() == null || getUsuario() == null) return false;
			if (!obj.getUsuario().equals(getUsuario())) return false;
		}

		if (obj.getAuthority() != getAuthority()) {
			if (obj.getAuthority() == null || getAuthority() == null) return false;
			if (!obj.getAuthority().equals(getAuthority())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getUsuario()==null?"":getUsuario().toString())+(getAuthority()==null?"":getAuthority().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "J314UserAuthorityPoj{" +
			"}";
	}
	



/*


*/
} // Eliminar


