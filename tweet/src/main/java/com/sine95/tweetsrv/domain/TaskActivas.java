
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

@Entity(name = "TaskActivas")
@Table(name = "TASKACTIVAS")
@SuppressWarnings("unused")
public class TaskActivas  implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenTaskActivas")
	@SequenceGenerator(name = "seqGenTaskActivas",sequenceName="taskactivas_seq", allocationSize=1)

	
	private Long id;
	@NotNull	@Enumerated(EnumType.STRING)
	@Column(name = "TAREA", nullable = false)
	private TareasPeriodicas tarea;
	@NotNull	@Enumerated(EnumType.STRING)
	@Column(name = "ACTIVA", nullable = false)
	private SiNo activa;

// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

  public TaskActivas setId(Long valor){
    this.id=valor;
    return this;
  }

  public TaskActivas id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public TaskActivas setTarea(TareasPeriodicas valor){
    this.tarea=valor;
    return this;
  }

  public TaskActivas tarea(TareasPeriodicas valor){
    this.tarea=valor;
    return this;
  }

  public TareasPeriodicas getTarea(){
    return this.tarea;
  }

  public TaskActivas setActiva(SiNo valor){
    this.activa=valor;
    return this;
  }

  public TaskActivas activa(SiNo valor){
    this.activa=valor;
    return this;
  }

  public SiNo getActiva(){
    return this.activa;
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
		TaskActivas obj = null;
		try {
			obj = (TaskActivas) o;
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
		return "TaskActivas{" +
			
			"id=" + getId() +
			
			", tarea=" + getTarea() +
			
			", activa=" + getActiva() +
			
			"}";
	}




/*


*/
}


