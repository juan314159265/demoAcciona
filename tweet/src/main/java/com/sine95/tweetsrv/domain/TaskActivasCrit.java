
package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.List;
import io.github.jhipster.service.filter.*;
import org.sine95.kernel.base.filter.*;

import com.sine95.tweetsrv.enums.*;




@SuppressWarnings("unused")
public class TaskActivasCrit implements Serializable {
	private static final long serialVersionUID = 1L;

	private LongFilter id;

	public static class TareasPeriodicasFilter extends Filter< TareasPeriodicas > {
		private static final long serialVersionUID = 1L;
		@Override
		public List< TareasPeriodicas > getIn() {
			List< TareasPeriodicas > in = super.getIn();
			if(in!=null && in.isEmpty())
			{
				return null;
			}
			return in;
		}
	}

	private TareasPeriodicasFilter tarea;

	public static class SiNoFilter extends Filter< SiNo > {
		private static final long serialVersionUID = 1L;
		@Override
		public List< SiNo > getIn() {
			List< SiNo > in = super.getIn();
			if(in!=null && in.isEmpty())
			{
				return null;
			}
			return in;
		}
	}

	private SiNoFilter activa;

	public TaskActivasCrit setId(LongFilter valor)
	{
		this.id=valor;
		return this;
	}
	
	public TaskActivasCrit id(LongFilter valor)
	{
		this.id=valor;
		return this;
	}
	
	public LongFilter getId(){
		return this.id;
	}
	
	public LongFilter id(){
		return this.id;
	}

	public TaskActivasCrit setTarea(TareasPeriodicasFilter valor)
	{
		this.tarea=valor;
		return this;
	}
	
	public TaskActivasCrit tarea(TareasPeriodicasFilter valor)
	{
		this.tarea=valor;
		return this;
	}
	
	public TareasPeriodicasFilter getTarea(){
		return this.tarea;
	}
	
	public TareasPeriodicasFilter tarea(){
		return this.tarea;
	}

	public TaskActivasCrit setActiva(SiNoFilter valor)
	{
		this.activa=valor;
		return this;
	}
	
	public TaskActivasCrit activa(SiNoFilter valor)
	{
		this.activa=valor;
		return this;
	}
	
	public SiNoFilter getActiva(){
		return this.activa;
	}
	
	public SiNoFilter activa(){
		return this.activa;
	}

    @Override
    public String toString() {
        return "TaskActivas{" +
        "id=" + getId() +
        ", tarea=" + getTarea() +
        ", activa=" + getActiva() +
        
        "}";
    }

//Si hay que annadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}
