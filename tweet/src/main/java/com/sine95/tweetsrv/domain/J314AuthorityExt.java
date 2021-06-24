
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;






/**
* *Comentarios*
*/

@SuppressWarnings("unused")
public class J314AuthorityExt  implements Serializable
{
	private static final long serialVersionUID = 1L;

	//name
	private String name;
	private Collection< String > name_IN;
	private Collection< String > name_NOTIN;

	public String getName()
	{
		return name;
	}
	public J314AuthorityExt setName(String _name)
	{
		name=_name;
		return this;
	}
	public Collection< String > getName_IN()
	{
		return name_IN;
	}
	public J314AuthorityExt setName_IN(Collection< String > _name)
	{
		name_IN=_name;
		return this;
	}
	public Collection< String > getName_NOTIN()
	{
		return name_NOTIN;
	}
	public J314AuthorityExt setName_NOTIN(Collection< String > _name)
	{
		name_NOTIN=_name;
		return this;
	}



	private String name_LIKE;
	private String name_NOTLIKE;

	public String getName_LIKE()
	{
		return name_LIKE;
	}
	public J314AuthorityExt setName_LIKE(String _name)
	{
		name_LIKE=_name;
		return this;
	}
	public String getName_NOTLIKE()
	{
		return name_NOTLIKE;
	}
	public J314AuthorityExt setName_NOTLIKE(String _name)
	{
		name_NOTLIKE=_name;
		return this;
	}





	private String orderby[];

	public String [] getOrderBy()
	{
		return orderby;
	}

	public J314AuthorityExt setOrderBy(String[] order)
	{
		orderby=order;
		return this;
	}

	private Integer maxElemsPerPage=10;
	private Integer page=0;

	public Integer  getMaxElemsPerPage()
	{
		return maxElemsPerPage;
	}

	public J314AuthorityExt setMaxElemsPerPage(Integer max)
	{
		maxElemsPerPage=max;
		return this;
	}
	public Integer  getPage()
	{
		return page;
	}

	public J314AuthorityExt setPage(Integer page)
	{
		this.page=page;
		return this;
	}





/*


*/
}


