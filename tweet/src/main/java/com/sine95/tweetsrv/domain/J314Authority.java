
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;






/**
* *Comentarios*
*/

@Entity(name = "J314Authority")
@Table(name = "J314Authority")
@SuppressWarnings("unused")
public class J314Authority  implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Size(max = 50)
	
	private String name;


	// Relacion "users"; Tipo: MAN; Extremo: N

	@OneToMany(
	   mappedBy = "usuario" // CAMPO propietario de la relacion (no columna)

		,orphanRemoval = true
	)
	private List< J314UserAuthority > users = new ArrayList<>();





// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

  public J314Authority setName(String valor){
    this.name=valor;
    return this;
  }

  public J314Authority name(String valor){
    this.name=valor;
    return this;
  }

  public String getName(){
    return this.name;
  }

// Campo: users
// Campo virtual = true 
/*
campo[attributes={nombre=users, idioma=Users, virtual=S, null=S, columna=USERS, nombreBD=users}; value=[relacion[attributes={tipo=MAN, navegacion=N, nombre=users, entidad=J314UserAuthority, fk=usuario}; value=[extremo[attributes={nombre=usuario, entidad=J314User, idioma=User, fk=authorities, fkEnlace=usuario}; value=[]]]], list[attributes={show=S, mode=modify}; value=[campos[attributes={}; value=[campo[attributes={loc=user, nombre=login, idioma=Login}; value=[]], campo[attributes={loc=user, nombre=first_name, idioma=Nombre}; value=[]], campo[attributes={loc=user, nombre=last_name, idioma=Apellidos}; value=[]]]]]], form[attributes={show=S, subtype=list}; value=[]]]]
*/
// Tipo relacion = MAN
// Navegacion = N 
  public List< J314User > getSoloUsers(){
	  List< J314User > res = new ArrayList<>();
	  if (this.users!=null)
	  {
		  for (J314UserAuthority o:this.users)
		  {
			  res.add(o.getUsuario());
		  }
	  }
    return res;
  }

  public J314Authority setUsers(List< J314UserAuthority > valor){
    this.users=valor;
    return this;
  }

  public J314Authority users(List< J314UserAuthority > valor){
    this.users=valor;
    return this;
  }

  public List< J314UserAuthority > getUsers(){
    return this.users;
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
		J314Authority obj = null;
		try {
			obj = (J314Authority) o;
		}
		catch(ClassCastException cce)
		{
			return false;
		}
		if (obj.getName() == null || getName() == null) {
			return false;
		}
		return Objects.equals(getName(), obj.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getName());
	}
	@Override
	public String toString() {
		return "J314Authority{" +
			
			"name=" + getName() +
			
			"}";
	}




/*


*/
}


