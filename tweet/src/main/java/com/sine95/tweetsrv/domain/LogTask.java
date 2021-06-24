
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;






/**
* 
*/

@Entity(name = "LogTask")
@Table(name = "LOGTASK")
@SuppressWarnings("unused")
public class LogTask  implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenLogTask")
	@SequenceGenerator(name = "seqGenLogTask",sequenceName="logtask_seq", allocationSize=1)

	
	private Long id;
	@NotNull
	@Column(name = "HORAINICIO", nullable = false)
	private Date horaInicio;

	@Column(name = "HORAFIN", nullable = true)
	private Date horaFin;
	@NotNull	@Size(max = 250)
	@Column(name = "CLASE", length = 250, nullable = false)
	private String clase;
	@NotNull	@Size(max = 250)
	@Column(name = "METODO", length = 250, nullable = false)
	private String metodo;
	@Size(max = 4000)
	@Column(name = "ERRORES", length = 4000, nullable = true)
	private String errores;
	@Size(max = 4000)
	@Column(name = "WARNINGS", length = 4000, nullable = true)
	private String warnings;
	@Size(max = 4000)
	@Column(name = "INFOS", length = 4000, nullable = true)
	private String infos;

// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

  public LogTask setId(Long valor){
    this.id=valor;
    return this;
  }

  public LogTask id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public LogTask setHoraInicio(Date valor){
    this.horaInicio=valor;
    return this;
  }

  public LogTask horaInicio(Date valor){
    this.horaInicio=valor;
    return this;
  }

  public Date getHoraInicio(){
    return this.horaInicio;
  }

  public LogTask setHoraFin(Date valor){
    this.horaFin=valor;
    return this;
  }

  public LogTask horaFin(Date valor){
    this.horaFin=valor;
    return this;
  }

  public Date getHoraFin(){
    return this.horaFin;
  }

  public LogTask setClase(String valor){
    this.clase=valor;
    return this;
  }

  public LogTask clase(String valor){
    this.clase=valor;
    return this;
  }

  public String getClase(){
    return this.clase;
  }

  public LogTask setMetodo(String valor){
    this.metodo=valor;
    return this;
  }

  public LogTask metodo(String valor){
    this.metodo=valor;
    return this;
  }

  public String getMetodo(){
    return this.metodo;
  }

  public LogTask setErrores(String valor){
    this.errores=valor;
    return this;
  }

  public LogTask errores(String valor){
    this.errores=valor;
    return this;
  }

  public String getErrores(){
    return this.errores;
  }

  public LogTask setWarnings(String valor){
    this.warnings=valor;
    return this;
  }

  public LogTask warnings(String valor){
    this.warnings=valor;
    return this;
  }

  public String getWarnings(){
    return this.warnings;
  }

  public LogTask setInfos(String valor){
    this.infos=valor;
    return this;
  }

  public LogTask infos(String valor){
    this.infos=valor;
    return this;
  }

  public String getInfos(){
    return this.infos;
  }

// jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
/*  Con clases controladas por hibernate esto no funciona porque usa clases proxy (mediante herencia) y las considera distintas
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
*/
		LogTask obj = null;
		try {
			obj = (LogTask) o;
		}
		catch(ClassCastException cce)
		{
			return false;
		}
		if (obj.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), obj.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
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




/*


*/
}


