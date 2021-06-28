package org.jpgp.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.*;
import java.math.*;

/**
* 
*/

@Entity(name = "Tweet")
@Table(name = "Tweet")
@SuppressWarnings("unused")
public class Tweet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenTweet")
	@SequenceGenerator(name = "seqGenTweet", sequenceName = "configuration_seq", allocationSize = 1)

	private Long id;
	@NotNull
	@Size(max = 300)
	@Column(name = "USUARIO", length = 300, nullable = false)
	private String usuario;
	@NotNull
	@Size(max = 500)
	@Column(name = "TEXTO", length = 500, nullable = false)
	private String texto;
	@Nullable
	@Size(max = 200)
	@Column(name = "LOCALIZACION_LATITUD", length = 200, nullable = true)
	private String localizacionLatidud;
	@Nullable
	@Size(max = 200)
	@Column(name = "LOCALIZACION_LONGITUD", length = 200, nullable = true)
	private String localizacionLongitud;
	@NotNull
	@Column(name = "validacion", nullable = false)
	private Boolean validacion;


	public Tweet setId(Long valor) {
		this.id = valor;
		return this;
	}

	public Tweet id(Long valor) {
		this.id = valor;
		return this;
	}

	public Long getId() {
		return this.id;
	}

	public Tweet setUsuario(String valor) {
		this.usuario = valor;
		return this;
	}

	public Tweet usuario(String valor) {
		this.usuario = valor;
		return this;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public Tweet setTexto(String valor) {
		this.texto = valor;
		return this;
	}

	public Tweet texto(String valor) {
		this.texto = valor;
		return this;
	}

	public String getTexto() {
		return this.texto;
	}

	public Tweet setLocalizacionLatitud(String valor) {
		this.localizacionLatidud = valor;
		return this;
	}

	public Tweet localizacionLatidud(String valor) {
		this.localizacionLatidud = valor;
		return this;
	}

	public String getLocalizacionLatitud() {
		return this.localizacionLatidud;
	}

	public Tweet setLocalizacionLongitud(String valor) {
		this.localizacionLongitud = valor;
		return this;
	}

	public Tweet localizacionLongitud(String valor) {
		this.localizacionLongitud = valor;
		return this;
	}

	public String getLocalizacionLongitud() {
		return this.localizacionLongitud;
	}

	public Tweet setValidacion(Boolean valor) {
		this.validacion = valor;
		return this;
	}

	public Tweet validacion(Boolean valor) {
		this.validacion = valor;
		return this;
	}

	public Boolean getValidacion() {
		return this.validacion;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		/*
		 * Con clases controladas por hibernate esto no funciona porque usa clases proxy
		 * (mediante herencia) y las considera distintas if (o == null || getClass() !=
		 * o.getClass()) { return false; }
		 */
		Tweet obj = null;
		try {
			obj = (Tweet) o;
		} catch (ClassCastException cce) {
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
		return "Tweet{" +

				"id=" + getId() +

				", usuario=" + getUsuario() +

				", texto=" + getTexto() +

				", localizacionLatitud=" + getLocalizacionLatitud() +

				", localizacionLongitud=" + getLocalizacionLongitud() +

				", validacion=" + getValidacion() +

				"}";
	}

}
