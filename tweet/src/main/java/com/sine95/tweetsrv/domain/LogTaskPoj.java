

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

	import com.sine95.tweetsrv.domain.LogTask;
	


/**
 */
@SuppressWarnings("unused")
public class LogTaskPoj implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date horaInicio;

	private Date horaFin;

	private String clase;

	private String metodo;

	private String errores;

	private String warnings;

	private String infos;

	public LogTaskPoj()
	{
		super();
	}
	
	public LogTaskPoj(Long id,Date horaInicio,Date horaFin,String clase,String metodo,String errores,String warnings,String infos)
	{

		setId(id);

		setHoraInicio(horaInicio);

		setHoraFin(horaFin);

		setClase(clase);

		setMetodo(metodo);

		setErrores(errores);

		setWarnings(warnings);

		setInfos(infos);

	}

  public LogTaskPoj setId(Long valor){
    this.id=valor;
    return this;
  }

  public LogTaskPoj id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public LogTaskPoj setHoraInicio(Date valor){
    this.horaInicio=valor;
    return this;
  }

  public LogTaskPoj horaInicio(Date valor){
    this.horaInicio=valor;
    return this;
  }

  public Date getHoraInicio(){
    return this.horaInicio;
  }

  public LogTaskPoj setHoraFin(Date valor){
    this.horaFin=valor;
    return this;
  }

  public LogTaskPoj horaFin(Date valor){
    this.horaFin=valor;
    return this;
  }

  public Date getHoraFin(){
    return this.horaFin;
  }

  public LogTaskPoj setClase(String valor){
    this.clase=valor;
    return this;
  }

  public LogTaskPoj clase(String valor){
    this.clase=valor;
    return this;
  }

  public String getClase(){
    return this.clase;
  }

  public LogTaskPoj setMetodo(String valor){
    this.metodo=valor;
    return this;
  }

  public LogTaskPoj metodo(String valor){
    this.metodo=valor;
    return this;
  }

  public String getMetodo(){
    return this.metodo;
  }

  public LogTaskPoj setErrores(String valor){
    this.errores=valor;
    return this;
  }

  public LogTaskPoj errores(String valor){
    this.errores=valor;
    return this;
  }

  public String getErrores(){
    return this.errores;
  }

  public LogTaskPoj setWarnings(String valor){
    this.warnings=valor;
    return this;
  }

  public LogTaskPoj warnings(String valor){
    this.warnings=valor;
    return this;
  }

  public String getWarnings(){
    return this.warnings;
  }

  public LogTaskPoj setInfos(String valor){
    this.infos=valor;
    return this;
  }

  public LogTaskPoj infos(String valor){
    this.infos=valor;
    return this;
  }

  public String getInfos(){
    return this.infos;
  }

	public Long getId_()
	{
		return this.id;
	}

	public LogTaskPoj(LogTask o)
	{
		if (o==null) return;

		this.id = o.getId();

		this.horaInicio = o.getHoraInicio();

		this.horaFin = o.getHoraFin();

		this.clase = o.getClase();

		this.metodo = o.getMetodo();

		this.errores = o.getErrores();

		this.warnings = o.getWarnings();

		this.infos = o.getInfos();

	}
	

	public static LogTask getModel(LogTaskPoj p)
	{

		LogTask o = new LogTask();

		o.setId(p.getId());

		o.setHoraInicio(p.getHoraInicio());

		o.setHoraFin(p.getHoraFin());

		o.setClase(p.getClase());

		o.setMetodo(p.getMetodo());

		o.setErrores(p.getErrores());

		o.setWarnings(p.getWarnings());

		o.setInfos(p.getInfos());

		return o;
	}

	public static List< LogTask > toModelList(List< LogTaskPoj > l)
	{
		ArrayList< LogTask > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< LogTaskPoj > it = l.iterator();
			while(it.hasNext())
			{
				LogTaskPoj o = it.next();
				if (o!=null)
				{
					LogTask m = getModel(o);
					res.add(m);
				}
			}
		}
		return res;
	}
	

	public static List< LogTaskPoj > toPOJOList(List< LogTask > l)
	{
		ArrayList< LogTaskPoj > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< LogTask > it = l.iterator();
			while(it.hasNext())
			{
				LogTask o = it.next();
				if (o!=null)
				{
					LogTaskPoj m = new LogTaskPoj(o);
					res.add(m);
				}
			}
		}
		return res;
	}

	public static Page< LogTaskPoj > toPOJOPage(Page< LogTask > p)
	{
		if (p==null) return null;
		List< LogTask > l = p.getContent();
		List< LogTaskPoj > ll  = toPOJOList(l);
		PageImpl< LogTaskPoj > pageImpl = new PageImpl<>(ll,p.getPageable(),p.getTotalElements());
		
		Page< LogTaskPoj > res = pageImpl;

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
		LogTaskPoj obj = (LogTaskPoj) o;

		if (obj.getId() != getId()) {
			if (obj.getId() == null || getId() == null) return false;
			if (!obj.getId().equals(getId())) return false;
		}

		if (obj.getHoraInicio() != getHoraInicio()) {
			if (obj.getHoraInicio() == null || getHoraInicio() == null) return false;
			if (!obj.getHoraInicio().equals(getHoraInicio())) return false;
		}

		if (obj.getHoraFin() != getHoraFin()) {
			if (obj.getHoraFin() == null || getHoraFin() == null) return false;
			if (!obj.getHoraFin().equals(getHoraFin())) return false;
		}

		if (obj.getClase() != getClase()) {
			if (obj.getClase() == null || getClase() == null) return false;
			if (!obj.getClase().equals(getClase())) return false;
		}

		if (obj.getMetodo() != getMetodo()) {
			if (obj.getMetodo() == null || getMetodo() == null) return false;
			if (!obj.getMetodo().equals(getMetodo())) return false;
		}

		if (obj.getErrores() != getErrores()) {
			if (obj.getErrores() == null || getErrores() == null) return false;
			if (!obj.getErrores().equals(getErrores())) return false;
		}

		if (obj.getWarnings() != getWarnings()) {
			if (obj.getWarnings() == null || getWarnings() == null) return false;
			if (!obj.getWarnings().equals(getWarnings())) return false;
		}

		if (obj.getInfos() != getInfos()) {
			if (obj.getInfos() == null || getInfos() == null) return false;
			if (!obj.getInfos().equals(getInfos())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getId()==null?"":getId().toString())+(getHoraInicio()==null?"":getHoraInicio().toString())+(getHoraFin()==null?"":getHoraFin().toString())+(getClase()==null?"":getClase().toString())+(getMetodo()==null?"":getMetodo().toString())+(getErrores()==null?"":getErrores().toString())+(getWarnings()==null?"":getWarnings().toString())+(getInfos()==null?"":getInfos().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "LogTaskPoj{" +
			"id=" + getId() + ", horaInicio=" + getHoraInicio() + ", horaFin=" + getHoraFin() + ", clase=" + getClase() + ", metodo=" + getMetodo() + ", errores=" + getErrores() + ", warnings=" + getWarnings() + ", infos=" + getInfos() + "}";
	}
	



/*


*/
} // Eliminar


