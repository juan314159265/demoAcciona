
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;


import com.sine95.tweetsrv.enums.*;





/**
* 
*/

@SuppressWarnings("unused")
public class TaskActivasExt  implements Serializable
{
	private static final long serialVersionUID = 1L;

	//id
	private Long id;
	private Collection< Long > id_IN;
	private Collection< Long > id_NOTIN;

	public Long getId()
	{
		return id;
	}
	public TaskActivasExt setId(Long _id)
	{
		id=_id;
		return this;
	}
	public Collection< Long > getId_IN()
	{
		return id_IN;
	}
	public TaskActivasExt setId_IN(Collection< Long > _id)
	{
		id_IN=_id;
		return this;
	}
	public Collection< Long > getId_NOTIN()
	{
		return id_NOTIN;
	}
	public TaskActivasExt setId_NOTIN(Collection< Long > _id)
	{
		id_NOTIN=_id;
		return this;
	}





	private Long id_DISTINCT;
	private Long id_GREATERTHAN;
	private Long id_GREATEROREQUALTHAN;
	private Long id_LESSTHAN;
	private Long id_LESSOREQUALTHAN;

	public Long getId_DISTINCT()
	{
		return id_DISTINCT;
	}
	public TaskActivasExt setId_DISTINCT(Long _id)
	{
		id_DISTINCT=_id;
		return this;
	}

	public Long getId_GREATERTHAN()
	{
		return id_GREATERTHAN;
	}
	public TaskActivasExt setId_GREATERTHAN(Long _id)
	{
		id_GREATERTHAN=_id;
		return this;
	}

	public Long getId_GREATEROREQUALTHAN()
	{
		return id_GREATEROREQUALTHAN;
	}
	public TaskActivasExt setId_GREATEROREQUALTHAN(Long _id)
	{
		id_GREATEROREQUALTHAN=_id;
		return this;
	}

	public Long getId_LESSTHAN()
	{
		return id_LESSTHAN;
	}
	public TaskActivasExt setId_LESSTHAN(Long _id)
	{
		id_LESSTHAN=_id;
		return this;
	}

	public Long getId_LESSOREQUALTHAN()
	{
		return id_LESSOREQUALTHAN;
	}
	public TaskActivasExt setId_LESSOREQUALTHAN(Long _id)
	{
		id_LESSOREQUALTHAN=_id;
		return this;
	}



	//tarea
	private TareasPeriodicas tarea;
	private Collection< TareasPeriodicas > tarea_IN;
	private Collection< TareasPeriodicas > tarea_NOTIN;

	public TareasPeriodicas getTarea()
	{
		return tarea;
	}
	public TaskActivasExt setTarea(TareasPeriodicas _tarea)
	{
		tarea=_tarea;
		return this;
	}
	public Collection< TareasPeriodicas > getTarea_IN()
	{
		return tarea_IN;
	}
	public TaskActivasExt setTarea_IN(Collection< TareasPeriodicas > _tarea)
	{
		tarea_IN=_tarea;
		return this;
	}
	public Collection< TareasPeriodicas > getTarea_NOTIN()
	{
		return tarea_NOTIN;
	}
	public TaskActivasExt setTarea_NOTIN(Collection< TareasPeriodicas > _tarea)
	{
		tarea_NOTIN=_tarea;
		return this;
	}







	//activa
	private SiNo activa;
	private Collection< SiNo > activa_IN;
	private Collection< SiNo > activa_NOTIN;

	public SiNo getActiva()
	{
		return activa;
	}
	public TaskActivasExt setActiva(SiNo _activa)
	{
		activa=_activa;
		return this;
	}
	public Collection< SiNo > getActiva_IN()
	{
		return activa_IN;
	}
	public TaskActivasExt setActiva_IN(Collection< SiNo > _activa)
	{
		activa_IN=_activa;
		return this;
	}
	public Collection< SiNo > getActiva_NOTIN()
	{
		return activa_NOTIN;
	}
	public TaskActivasExt setActiva_NOTIN(Collection< SiNo > _activa)
	{
		activa_NOTIN=_activa;
		return this;
	}







	private String orderby[];

	public String [] getOrderBy()
	{
		return orderby;
	}

	public TaskActivasExt setOrderBy(String[] order)
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

	public TaskActivasExt setMaxElemsPerPage(Integer max)
	{
		maxElemsPerPage=max;
		return this;
	}
	public Integer  getPage()
	{
		return page;
	}

	public TaskActivasExt setPage(Integer page)
	{
		this.page=page;
		return this;
	}





/*


*/
}


