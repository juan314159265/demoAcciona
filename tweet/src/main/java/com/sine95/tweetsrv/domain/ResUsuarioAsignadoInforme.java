

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import com.sine95.tweetsrv.enums.*;



/**
 */
@SuppressWarnings("unused")
public class ResUsuarioAsignadoInforme implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long iduser;

	private String login;

	private String userfirstname;

	private String userlastname;

	private Long id_informe;

	private String nombreinforme;

	private String descripcion;

	private SiNo edita;

	public ResUsuarioAsignadoInforme()
	{
		super();
	}
	
	public ResUsuarioAsignadoInforme(Long iduser,String login,String userfirstname,String userlastname,Long id_informe,String nombreinforme,String descripcion,SiNo edita)
	{

		setIduser(iduser);

		setLogin(login);

		setUserfirstname(userfirstname);

		setUserlastname(userlastname);

		setId_informe(id_informe);

		setNombreinforme(nombreinforme);

		setDescripcion(descripcion);

		setEdita(edita);

	}

  public ResUsuarioAsignadoInforme setIduser(Long valor){
    this.iduser=valor;
    return this;
  }

  public ResUsuarioAsignadoInforme iduser(Long valor){
    this.iduser=valor;
    return this;
  }

  public Long getIduser(){
    return this.iduser;
  }

  public ResUsuarioAsignadoInforme setLogin(String valor){
    this.login=valor;
    return this;
  }

  public ResUsuarioAsignadoInforme login(String valor){
    this.login=valor;
    return this;
  }

  public String getLogin(){
    return this.login;
  }

  public ResUsuarioAsignadoInforme setUserfirstname(String valor){
    this.userfirstname=valor;
    return this;
  }

  public ResUsuarioAsignadoInforme userfirstname(String valor){
    this.userfirstname=valor;
    return this;
  }

  public String getUserfirstname(){
    return this.userfirstname;
  }

  public ResUsuarioAsignadoInforme setUserlastname(String valor){
    this.userlastname=valor;
    return this;
  }

  public ResUsuarioAsignadoInforme userlastname(String valor){
    this.userlastname=valor;
    return this;
  }

  public String getUserlastname(){
    return this.userlastname;
  }

  public ResUsuarioAsignadoInforme setId_informe(Long valor){
    this.id_informe=valor;
    return this;
  }

  public ResUsuarioAsignadoInforme id_informe(Long valor){
    this.id_informe=valor;
    return this;
  }

  public Long getId_informe(){
    return this.id_informe;
  }

  public ResUsuarioAsignadoInforme setNombreinforme(String valor){
    this.nombreinforme=valor;
    return this;
  }

  public ResUsuarioAsignadoInforme nombreinforme(String valor){
    this.nombreinforme=valor;
    return this;
  }

  public String getNombreinforme(){
    return this.nombreinforme;
  }

  public ResUsuarioAsignadoInforme setDescripcion(String valor){
    this.descripcion=valor;
    return this;
  }

  public ResUsuarioAsignadoInforme descripcion(String valor){
    this.descripcion=valor;
    return this;
  }

  public String getDescripcion(){
    return this.descripcion;
  }

  public ResUsuarioAsignadoInforme setEdita(SiNo valor){
    this.edita=valor;
    return this;
  }

  public ResUsuarioAsignadoInforme edita(SiNo valor){
    this.edita=valor;
    return this;
  }

  public SiNo getEdita(){
    return this.edita;
  }

	public Long getId_()
	{
		return this.id_informe;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResUsuarioAsignadoInforme obj = (ResUsuarioAsignadoInforme) o;

		if (obj.getIduser() != getIduser()) {
			if (obj.getIduser() == null || getIduser() == null) return false;
			if (!obj.getIduser().equals(getIduser())) return false;
		}

		if (obj.getLogin() != getLogin()) {
			if (obj.getLogin() == null || getLogin() == null) return false;
			if (!obj.getLogin().equals(getLogin())) return false;
		}

		if (obj.getUserfirstname() != getUserfirstname()) {
			if (obj.getUserfirstname() == null || getUserfirstname() == null) return false;
			if (!obj.getUserfirstname().equals(getUserfirstname())) return false;
		}

		if (obj.getUserlastname() != getUserlastname()) {
			if (obj.getUserlastname() == null || getUserlastname() == null) return false;
			if (!obj.getUserlastname().equals(getUserlastname())) return false;
		}

		if (obj.getId_informe() != getId_informe()) {
			if (obj.getId_informe() == null || getId_informe() == null) return false;
			if (!obj.getId_informe().equals(getId_informe())) return false;
		}

		if (obj.getNombreinforme() != getNombreinforme()) {
			if (obj.getNombreinforme() == null || getNombreinforme() == null) return false;
			if (!obj.getNombreinforme().equals(getNombreinforme())) return false;
		}

		if (obj.getDescripcion() != getDescripcion()) {
			if (obj.getDescripcion() == null || getDescripcion() == null) return false;
			if (!obj.getDescripcion().equals(getDescripcion())) return false;
		}

		if (obj.getEdita() != getEdita()) {
			if (obj.getEdita() == null || getEdita() == null) return false;
			if (!obj.getEdita().equals(getEdita())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getIduser()==null?"":getIduser().toString())+(getLogin()==null?"":getLogin().toString())+(getUserfirstname()==null?"":getUserfirstname().toString())+(getUserlastname()==null?"":getUserlastname().toString())+(getId_informe()==null?"":getId_informe().toString())+(getNombreinforme()==null?"":getNombreinforme().toString())+(getDescripcion()==null?"":getDescripcion().toString())+(getEdita()==null?"":getEdita().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "ResUsuarioAsignadoInforme{" +
			"iduser=" + getIduser() + ", login=" + getLogin() + ", userfirstname=" + getUserfirstname() + ", userlastname=" + getUserlastname() + ", id_informe=" + getId_informe() + ", nombreinforme=" + getNombreinforme() + ", descripcion=" + getDescripcion() + ", edita=" + getEdita() + "}";
	}
	



/*


*/
} // Eliminar


