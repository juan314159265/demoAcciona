

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

// import com.sine95.tweetsrv.domain.J314UserAuthority;

	import com.sine95.tweetsrv.domain.J314Authority;
	


/**
 */
@SuppressWarnings("unused")
public class J314AuthorityPoj implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String name;

	public J314AuthorityPoj()
	{
		super();
	}
	
	public J314AuthorityPoj(String name)
	{

		setName(name);

	}

  public J314AuthorityPoj setName(String valor){
    this.name=valor;
    return this;
  }

  public J314AuthorityPoj name(String valor){
    this.name=valor;
    return this;
  }

  public String getName(){
    return this.name;
  }

	public String getId_()
	{
		return this.name;
	}

	public J314AuthorityPoj(J314Authority o)
	{
		if (o==null) return;

		this.name = o.getName();

	}
	

	public static J314Authority getModel(J314AuthorityPoj p)
	{

		J314Authority o = new J314Authority();

		o.setName(p.getName());

		return o;
	}

	public static List< J314Authority > toModelList(List< J314AuthorityPoj > l)
	{
		ArrayList< J314Authority > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< J314AuthorityPoj > it = l.iterator();
			while(it.hasNext())
			{
				J314AuthorityPoj o = it.next();
				if (o!=null)
				{
					J314Authority m = getModel(o);
					res.add(m);
				}
			}
		}
		return res;
	}
	

	public static List< J314AuthorityPoj > toPOJOList(List< J314Authority > l)
	{
		ArrayList< J314AuthorityPoj > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< J314Authority > it = l.iterator();
			while(it.hasNext())
			{
				J314Authority o = it.next();
				if (o!=null)
				{
					J314AuthorityPoj m = new J314AuthorityPoj(o);
					res.add(m);
				}
			}
		}
		return res;
	}

	public static Page< J314AuthorityPoj > toPOJOPage(Page< J314Authority > p)
	{
		if (p==null) return null;
		List< J314Authority > l = p.getContent();
		List< J314AuthorityPoj > ll  = toPOJOList(l);
		PageImpl< J314AuthorityPoj > pageImpl = new PageImpl<>(ll,p.getPageable(),p.getTotalElements());
		
		Page< J314AuthorityPoj > res = pageImpl;

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
		J314AuthorityPoj obj = (J314AuthorityPoj) o;

		if (obj.getName() != getName()) {
			if (obj.getName() == null || getName() == null) return false;
			if (!obj.getName().equals(getName())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getName()==null?"":getName().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "J314AuthorityPoj{" +
			"name=" + getName() + "}";
	}
	



/*


*/
} // Eliminar


