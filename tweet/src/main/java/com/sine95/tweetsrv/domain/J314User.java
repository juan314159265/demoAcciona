
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;


import com.sine95.tweetsrv.enums.*;





/**
* *Comentarios*
*/

@Entity(name = "J314User")
@Table(name = "j314User")
@SuppressWarnings("unused")
public class J314User  implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenJ314User")
	@SequenceGenerator(name = "seqGenJ314User",sequenceName="j314user_seq", allocationSize=1)

	
	private Long id;
	@NotNull	@Size(max = 50)
	@Column(name = "created_by", length = 50, nullable = false)
	private String created_by;
	@NotNull
	@Column(name = "created_date", nullable = false)
	private Date created_date;
	@Size(max = 50)
	@Column(name = "last_modified_by", length = 50, nullable = true)
	private String last_modified_by;

	@Column(name = "last_modified_date", nullable = true)
	private Date last_modified_date;
	@NotNull	@Enumerated(EnumType.STRING)
	@Column(name = "activated", nullable = false)
	private SiNo activated;
	@Size(max = 20)
	@Column(name = "activation_key", length = 20, nullable = true)
	private String activation_key;
	@NotNull	@Size(max = 50)
	@Column(name = "login", length = 50, nullable = false)
	private String login;
	@Size(max = 254)
	@Column(name = "email", length = 254, nullable = true)
	private String email;
	@Size(max = 50)
	@Column(name = "first_name", length = 50, nullable = true)
	private String first_name;
	@Size(max = 50)
	@Column(name = "last_name", length = 50, nullable = true)
	private String last_name;
	@Size(max = 256)
	@Column(name = "image_url", length = 256, nullable = true)
	private String image_url;
	@Size(max = 6)
	@Column(name = "lang_key", length = 6, nullable = true)
	private String lang_key;
	@NotNull	@Size(max = 150)
	@Column(name = "password_hash", length = 150, nullable = false)
	private String password_hash;

	@Column(name = "reset_date", nullable = true)
	private Date reset_date;
	@Size(max = 20)
	@Column(name = "reset_key", length = 20, nullable = true)
	private String reset_key;

	@Column(name = "tiempoSesion", nullable = true)
	private Long tiempoSesion;


	// Relacion "authorities"; Tipo: MAN; Extremo: M

	@OneToMany(
	   mappedBy = "usuario" // CAMPO propietario de la relacion (no columna)

		,cascade = CascadeType.ALL

		,orphanRemoval = true
	)
	private List< J314UserAuthority > authorities = new ArrayList<>();


	public void addAuthority(J314Authority j314Authority)
	{
		J314UserAuthority j314UserAuthority = new J314UserAuthority(this,j314Authority);
		getAuthorities().add(j314UserAuthority);
		j314Authority.getUsers().add(j314UserAuthority);
	}
 
	public void removeAuthority(J314Authority j314Authority)
	{
		for (Iterator< J314UserAuthority > iterator = getAuthorities().iterator(); iterator.hasNext(); )
		{
			J314UserAuthority j314UserAuthority = iterator.next();
			if (j314UserAuthority.getAuthority().equals(j314Authority))
			{
			  iterator.remove();
				j314UserAuthority.removeMeFromAuthority();
				j314UserAuthority.clear();
			}
		}
	}




// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

  public J314User setId(Long valor){
    this.id=valor;
    return this;
  }

  public J314User id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public J314User setCreated_by(String valor){
    this.created_by=valor;
    return this;
  }

  public J314User created_by(String valor){
    this.created_by=valor;
    return this;
  }

  public String getCreated_by(){
    return this.created_by;
  }

  public J314User setCreated_date(Date valor){
    this.created_date=valor;
    return this;
  }

  public J314User created_date(Date valor){
    this.created_date=valor;
    return this;
  }

  public Date getCreated_date(){
    return this.created_date;
  }

  public J314User setLast_modified_by(String valor){
    this.last_modified_by=valor;
    return this;
  }

  public J314User last_modified_by(String valor){
    this.last_modified_by=valor;
    return this;
  }

  public String getLast_modified_by(){
    return this.last_modified_by;
  }

  public J314User setLast_modified_date(Date valor){
    this.last_modified_date=valor;
    return this;
  }

  public J314User last_modified_date(Date valor){
    this.last_modified_date=valor;
    return this;
  }

  public Date getLast_modified_date(){
    return this.last_modified_date;
  }

  public J314User setActivated(SiNo valor){
    this.activated=valor;
    return this;
  }

  public J314User activated(SiNo valor){
    this.activated=valor;
    return this;
  }

  public SiNo getActivated(){
    return this.activated;
  }

  public J314User setActivation_key(String valor){
    this.activation_key=valor;
    return this;
  }

  public J314User activation_key(String valor){
    this.activation_key=valor;
    return this;
  }

  public String getActivation_key(){
    return this.activation_key;
  }

  public J314User setLogin(String valor){
    this.login=valor;
    return this;
  }

  public J314User login(String valor){
    this.login=valor;
    return this;
  }

  public String getLogin(){
    return this.login;
  }

  public J314User setEmail(String valor){
    this.email=valor;
    return this;
  }

  public J314User email(String valor){
    this.email=valor;
    return this;
  }

  public String getEmail(){
    return this.email;
  }

  public J314User setFirst_name(String valor){
    this.first_name=valor;
    return this;
  }

  public J314User first_name(String valor){
    this.first_name=valor;
    return this;
  }

  public String getFirst_name(){
    return this.first_name;
  }

  public J314User setLast_name(String valor){
    this.last_name=valor;
    return this;
  }

  public J314User last_name(String valor){
    this.last_name=valor;
    return this;
  }

  public String getLast_name(){
    return this.last_name;
  }

  public J314User setImage_url(String valor){
    this.image_url=valor;
    return this;
  }

  public J314User image_url(String valor){
    this.image_url=valor;
    return this;
  }

  public String getImage_url(){
    return this.image_url;
  }

  public J314User setLang_key(String valor){
    this.lang_key=valor;
    return this;
  }

  public J314User lang_key(String valor){
    this.lang_key=valor;
    return this;
  }

  public String getLang_key(){
    return this.lang_key;
  }

  public J314User setPassword_hash(String valor){
    this.password_hash=valor;
    return this;
  }

  public J314User password_hash(String valor){
    this.password_hash=valor;
    return this;
  }

  public String getPassword_hash(){
    return this.password_hash;
  }

  public J314User setReset_date(Date valor){
    this.reset_date=valor;
    return this;
  }

  public J314User reset_date(Date valor){
    this.reset_date=valor;
    return this;
  }

  public Date getReset_date(){
    return this.reset_date;
  }

  public J314User setReset_key(String valor){
    this.reset_key=valor;
    return this;
  }

  public J314User reset_key(String valor){
    this.reset_key=valor;
    return this;
  }

  public String getReset_key(){
    return this.reset_key;
  }

  public J314User setTiempoSesion(Long valor){
    this.tiempoSesion=valor;
    return this;
  }

  public J314User tiempoSesion(Long valor){
    this.tiempoSesion=valor;
    return this;
  }

  public Long getTiempoSesion(){
    return this.tiempoSesion;
  }

// Campo: authorities
// Campo virtual = true 
/*
campo[attributes={nombre=authorities, idioma=Authorities, virtual=S, null=S, columna=AUTHORITIES, nombreBD=authorities}; value=[relacion[attributes={tipo=MAN, navegacion=M, nombre=authorities, entidad=J314UserAuthority, fk=usuario}; value=[extremo[attributes={nombre=authority, entidad=J314Authority, idioma=Authority, fk=users, fkEnlace=authority}; value=[]]]], list[attributes={show=S}; value=[campos[attributes={}; value=[campo[attributes={loc=authority, nombre=name, idioma=Nombre grupo}; value=[]]]]]], form[attributes={show=S, subtype=list}; value=[]]]]
*/
// Tipo relacion = MAN
// Navegacion = M 
  public List< J314Authority > getSoloAuthorities(){
	  List< J314Authority > res = new ArrayList<>();
	  if (this.authorities!=null)
	  {
		  for (J314UserAuthority o:this.authorities)
		  {
			  res.add(o.getAuthority());
		  }
	  }
    return res;
  }

  public J314User setAuthorities(List< J314UserAuthority > valor){
    this.authorities=valor;
    return this;
  }

  public J314User authorities(List< J314UserAuthority > valor){
    this.authorities=valor;
    return this;
  }

  public List< J314UserAuthority > getAuthorities(){
    return this.authorities;
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
		J314User obj = null;
		try {
			obj = (J314User) o;
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
		return "J314User{" +
			
			"id=" + getId() +
			
			", created_by=" + getCreated_by() +
			
			", created_date=" + getCreated_date() +
			
			", last_modified_by=" + getLast_modified_by() +
			
			", last_modified_date=" + getLast_modified_date() +
			
			", activated=" + getActivated() +
			
			", activation_key=" + getActivation_key() +
			
			", login=" + getLogin() +
			
			", email=" + getEmail() +
			
			", first_name=" + getFirst_name() +
			
			", last_name=" + getLast_name() +
			
			", image_url=" + getImage_url() +
			
			", lang_key=" + getLang_key() +
			
			", password_hash=" + getPassword_hash() +
			
			", reset_date=" + getReset_date() +
			
			", reset_key=" + getReset_key() +
			
			", tiempoSesion=" + getTiempoSesion() +
			
			"}";
	}




/*


*/
}


