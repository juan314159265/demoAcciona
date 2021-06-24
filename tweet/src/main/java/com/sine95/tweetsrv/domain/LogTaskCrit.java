
package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.List;
import io.github.jhipster.service.filter.*;
import org.sine95.kernel.base.filter.*;




@SuppressWarnings("unused")
public class LogTaskCrit implements Serializable {
	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private DateFilter horaInicio;

	private DateFilter horaFin;

	private StringFilter clase;

	private StringFilter metodo;

	private StringFilter errores;

	private StringFilter warnings;

	private StringFilter infos;

	public LogTaskCrit setId(LongFilter valor)
	{
		this.id=valor;
		return this;
	}
	
	public LogTaskCrit id(LongFilter valor)
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

	public LogTaskCrit setHoraInicio(DateFilter valor)
	{
		this.horaInicio=valor;
		return this;
	}
	
	public LogTaskCrit horaInicio(DateFilter valor)
	{
		this.horaInicio=valor;
		return this;
	}
	
	public DateFilter getHoraInicio(){
		return this.horaInicio;
	}
	
	public DateFilter horainicio(){
		return this.horaInicio;
	}

	public LogTaskCrit setHoraFin(DateFilter valor)
	{
		this.horaFin=valor;
		return this;
	}
	
	public LogTaskCrit horaFin(DateFilter valor)
	{
		this.horaFin=valor;
		return this;
	}
	
	public DateFilter getHoraFin(){
		return this.horaFin;
	}
	
	public DateFilter horafin(){
		return this.horaFin;
	}

	public LogTaskCrit setClase(StringFilter valor)
	{
		this.clase=valor;
		return this;
	}
	
	public LogTaskCrit clase(StringFilter valor)
	{
		this.clase=valor;
		return this;
	}
	
	public StringFilter getClase(){
		return this.clase;
	}
	
	public StringFilter clase(){
		return this.clase;
	}

	public LogTaskCrit setMetodo(StringFilter valor)
	{
		this.metodo=valor;
		return this;
	}
	
	public LogTaskCrit metodo(StringFilter valor)
	{
		this.metodo=valor;
		return this;
	}
	
	public StringFilter getMetodo(){
		return this.metodo;
	}
	
	public StringFilter metodo(){
		return this.metodo;
	}

	public LogTaskCrit setErrores(StringFilter valor)
	{
		this.errores=valor;
		return this;
	}
	
	public LogTaskCrit errores(StringFilter valor)
	{
		this.errores=valor;
		return this;
	}
	
	public StringFilter getErrores(){
		return this.errores;
	}
	
	public StringFilter errores(){
		return this.errores;
	}

	public LogTaskCrit setWarnings(StringFilter valor)
	{
		this.warnings=valor;
		return this;
	}
	
	public LogTaskCrit warnings(StringFilter valor)
	{
		this.warnings=valor;
		return this;
	}
	
	public StringFilter getWarnings(){
		return this.warnings;
	}
	
	public StringFilter warnings(){
		return this.warnings;
	}

	public LogTaskCrit setInfos(StringFilter valor)
	{
		this.infos=valor;
		return this;
	}
	
	public LogTaskCrit infos(StringFilter valor)
	{
		this.infos=valor;
		return this;
	}
	
	public StringFilter getInfos(){
		return this.infos;
	}
	
	public StringFilter infos(){
		return this.infos;
	}

    @Override
    public String toString() {
        return "LogTask{" +
        "id=" + getId() +
        ", horaInicio=" + getHoraInicio() +
        ", horaFin=" + getHoraFin() +
        ", clase=" + getClase() +
        ", metodo=" + getMetodo() +
        ", errores=" + getErrores() +
        ", warnings=" + getWarnings() +
        ", infos=" + getInfos() +
        
        "}";
    }

//Si hay que annadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}
