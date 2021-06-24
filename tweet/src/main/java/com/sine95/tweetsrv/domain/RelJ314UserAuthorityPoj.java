

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.sine95.tweetsrv.domain.*;



/**
 */
@SuppressWarnings("unused")
public class RelJ314UserAuthorityPoj implements Serializable
{
	private static final long serialVersionUID = 1L;

	private J314UserPoj usuario;

	private J314AuthorityPoj authority;

	private J314UserAuthorityPoj j314UserAuthority;

	public RelJ314UserAuthorityPoj()
	{
		super();
	}
	
	public RelJ314UserAuthorityPoj(J314UserPoj usuario,J314AuthorityPoj authority,J314UserAuthorityPoj j314UserAuthority)
	{

		setUsuario(usuario);

		setAuthority(authority);

		setJ314UserAuthority(j314UserAuthority);

	}

  public RelJ314UserAuthorityPoj setUsuario(J314UserPoj valor){
    this.usuario=valor;
    return this;
  }

  public RelJ314UserAuthorityPoj usuario(J314UserPoj valor){
    this.usuario=valor;
    return this;
  }

  public J314UserPoj getUsuario(){
    return this.usuario;
  }

  public RelJ314UserAuthorityPoj setAuthority(J314AuthorityPoj valor){
    this.authority=valor;
    return this;
  }

  public RelJ314UserAuthorityPoj authority(J314AuthorityPoj valor){
    this.authority=valor;
    return this;
  }

  public J314AuthorityPoj getAuthority(){
    return this.authority;
  }

  public RelJ314UserAuthorityPoj setJ314UserAuthority(J314UserAuthorityPoj valor){
    this.j314UserAuthority=valor;
    return this;
  }

  public RelJ314UserAuthorityPoj j314UserAuthority(J314UserAuthorityPoj valor){
    this.j314UserAuthority=valor;
    return this;
  }

  public J314UserAuthorityPoj getJ314UserAuthority(){
    return this.j314UserAuthority;
  }

	public RelJ314UserAuthorityPoj(RelJ314UserAuthority o)
	{
		if (o==null) return;

		this.usuario = new J314UserPoj(o.getUsuario());

		this.authority = new J314AuthorityPoj(o.getAuthority());

		this.j314UserAuthority = new J314UserAuthorityPoj(o.getJ314UserAuthority());

	}
	
	

	public static List< RelJ314UserAuthorityPoj > toPOJOList(List< RelJ314UserAuthority > l)
	{
		ArrayList< RelJ314UserAuthorityPoj > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< RelJ314UserAuthority > it = l.iterator();
			while(it.hasNext())
			{
				RelJ314UserAuthority o = it.next();
				if (o!=null)
				{
					RelJ314UserAuthorityPoj m = new RelJ314UserAuthorityPoj(o);
					res.add(m);
				}
			}
		}
		return res;
	}

	public static Page< RelJ314UserAuthorityPoj > toPOJOPage(Page< RelJ314UserAuthority > p)
	{
		if (p==null) return null;
		List< RelJ314UserAuthority > l = p.getContent();
		List< RelJ314UserAuthorityPoj > ll  = toPOJOList(l);
		PageImpl< RelJ314UserAuthorityPoj > pageImpl = new PageImpl<>(ll,p.getPageable(),p.getTotalElements());
		
		Page< RelJ314UserAuthorityPoj > res = pageImpl;

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
		RelJ314UserAuthorityPoj obj = (RelJ314UserAuthorityPoj) o;

		if (obj.getUsuario() != getUsuario()) {
			if (obj.getUsuario() == null || getUsuario() == null) return false;
			if (!obj.getUsuario().equals(getUsuario())) return false;
		}

		if (obj.getAuthority() != getAuthority()) {
			if (obj.getAuthority() == null || getAuthority() == null) return false;
			if (!obj.getAuthority().equals(getAuthority())) return false;
		}

		if (obj.getJ314UserAuthority() != getJ314UserAuthority()) {
			if (obj.getJ314UserAuthority() == null || getJ314UserAuthority() == null) return false;
			if (!obj.getJ314UserAuthority().equals(getJ314UserAuthority())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getUsuario()==null?"":getUsuario().toString())+(getAuthority()==null?"":getAuthority().toString())+(getJ314UserAuthority()==null?"":getJ314UserAuthority().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "RelJ314UserAuthorityPoj{" +
			"}";
	}
	



/*


*/
} // Eliminar


