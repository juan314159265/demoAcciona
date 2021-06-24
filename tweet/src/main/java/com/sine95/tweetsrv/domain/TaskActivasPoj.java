

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

	import com.sine95.tweetsrv.domain.TaskActivas;
	
import com.sine95.tweetsrv.enums.*;



/**
 */
@SuppressWarnings("unused")
public class TaskActivasPoj implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;

	private TareasPeriodicas tarea;

	private SiNo activa;

	public TaskActivasPoj()
	{
		super();
	}
	
	public TaskActivasPoj(Long id,TareasPeriodicas tarea,SiNo activa)
	{

		setId(id);

		setTarea(tarea);

		setActiva(activa);

	}

  public TaskActivasPoj setId(Long valor){
    this.id=valor;
    return this;
  }

  public TaskActivasPoj id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public TaskActivasPoj setTarea(TareasPeriodicas valor){
    this.tarea=valor;
    return this;
  }

  public TaskActivasPoj tarea(TareasPeriodicas valor){
    this.tarea=valor;
    return this;
  }

  public TareasPeriodicas getTarea(){
    return this.tarea;
  }

  public TaskActivasPoj setActiva(SiNo valor){
    this.activa=valor;
    return this;
  }

  public TaskActivasPoj activa(SiNo valor){
    this.activa=valor;
    return this;
  }

  public SiNo getActiva(){
    return this.activa;
  }

	public Long getId_()
	{
		return this.id;
	}

	public TaskActivasPoj(TaskActivas o)
	{
		if (o==null) return;

		this.id = o.getId();

		this.tarea = o.getTarea();

		this.activa = o.getActiva();

	}
	

	public static TaskActivas getModel(TaskActivasPoj p)
	{

		TaskActivas o = new TaskActivas();

		o.setId(p.getId());

		o.setTarea(p.getTarea());

		o.setActiva(p.getActiva());

		return o;
	}

	public static List< TaskActivas > toModelList(List< TaskActivasPoj > l)
	{
		ArrayList< TaskActivas > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< TaskActivasPoj > it = l.iterator();
			while(it.hasNext())
			{
				TaskActivasPoj o = it.next();
				if (o!=null)
				{
					TaskActivas m = getModel(o);
					res.add(m);
				}
			}
		}
		return res;
	}
	

	public static List< TaskActivasPoj > toPOJOList(List< TaskActivas > l)
	{
		ArrayList< TaskActivasPoj > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< TaskActivas > it = l.iterator();
			while(it.hasNext())
			{
				TaskActivas o = it.next();
				if (o!=null)
				{
					TaskActivasPoj m = new TaskActivasPoj(o);
					res.add(m);
				}
			}
		}
		return res;
	}

	public static Page< TaskActivasPoj > toPOJOPage(Page< TaskActivas > p)
	{
		if (p==null) return null;
		List< TaskActivas > l = p.getContent();
		List< TaskActivasPoj > ll  = toPOJOList(l);
		PageImpl< TaskActivasPoj > pageImpl = new PageImpl<>(ll,p.getPageable(),p.getTotalElements());
		
		Page< TaskActivasPoj > res = pageImpl;

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
		TaskActivasPoj obj = (TaskActivasPoj) o;

		if (obj.getId() != getId()) {
			if (obj.getId() == null || getId() == null) return false;
			if (!obj.getId().equals(getId())) return false;
		}

		if (obj.getTarea() != getTarea()) {
			if (obj.getTarea() == null || getTarea() == null) return false;
			if (!obj.getTarea().equals(getTarea())) return false;
		}

		if (obj.getActiva() != getActiva()) {
			if (obj.getActiva() == null || getActiva() == null) return false;
			if (!obj.getActiva().equals(getActiva())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getId()==null?"":getId().toString())+(getTarea()==null?"":getTarea().toString())+(getActiva()==null?"":getActiva().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "TaskActivasPoj{" +
			"id=" + getId() + ", tarea=" + getTarea() + ", activa=" + getActiva() + "}";
	}
	



/*


*/
} // Eliminar


