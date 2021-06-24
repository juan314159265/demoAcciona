

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import com.sine95.tweetsrv.enums.*;



/**
 */
@SuppressWarnings("unused")
public class ParamOutTasks implements Serializable
{
	private static final long serialVersionUID = 1L;

	private TareasPeriodicas tarea;

	private SiNo activo;

	private String periodicidad;

	private String info;

	public ParamOutTasks()
	{
		super();
	}
	
	public ParamOutTasks(TareasPeriodicas tarea,SiNo activo,String periodicidad,String info)
	{

		setTarea(tarea);

		setActivo(activo);

		setPeriodicidad(periodicidad);

		setInfo(info);

	}

  public ParamOutTasks setTarea(TareasPeriodicas valor){
    this.tarea=valor;
    return this;
  }

  public ParamOutTasks tarea(TareasPeriodicas valor){
    this.tarea=valor;
    return this;
  }

  public TareasPeriodicas getTarea(){
    return this.tarea;
  }

  public ParamOutTasks setActivo(SiNo valor){
    this.activo=valor;
    return this;
  }

  public ParamOutTasks activo(SiNo valor){
    this.activo=valor;
    return this;
  }

  public SiNo getActivo(){
    return this.activo;
  }

  public ParamOutTasks setPeriodicidad(String valor){
    this.periodicidad=valor;
    return this;
  }

  public ParamOutTasks periodicidad(String valor){
    this.periodicidad=valor;
    return this;
  }

  public String getPeriodicidad(){
    return this.periodicidad;
  }

  public ParamOutTasks setInfo(String valor){
    this.info=valor;
    return this;
  }

  public ParamOutTasks info(String valor){
    this.info=valor;
    return this;
  }

  public String getInfo(){
    return this.info;
  }


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ParamOutTasks obj = (ParamOutTasks) o;

		if (obj.getTarea() != getTarea()) {
			if (obj.getTarea() == null || getTarea() == null) return false;
			if (!obj.getTarea().equals(getTarea())) return false;
		}

		if (obj.getActivo() != getActivo()) {
			if (obj.getActivo() == null || getActivo() == null) return false;
			if (!obj.getActivo().equals(getActivo())) return false;
		}

		if (obj.getPeriodicidad() != getPeriodicidad()) {
			if (obj.getPeriodicidad() == null || getPeriodicidad() == null) return false;
			if (!obj.getPeriodicidad().equals(getPeriodicidad())) return false;
		}

		if (obj.getInfo() != getInfo()) {
			if (obj.getInfo() == null || getInfo() == null) return false;
			if (!obj.getInfo().equals(getInfo())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getTarea()==null?"":getTarea().toString())+(getActivo()==null?"":getActivo().toString())+(getPeriodicidad()==null?"":getPeriodicidad().toString())+(getInfo()==null?"":getInfo().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "ParamOutTasks{" +
			"tarea=" + getTarea() + ", activo=" + getActivo() + ", periodicidad=" + getPeriodicidad() + ", info=" + getInfo() + "}";
	}
	



/*


*/
} // Eliminar


