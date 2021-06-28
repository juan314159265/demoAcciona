package org.jpgp.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;

@Entity(name = "Hashtag")
@Table(name = "Hashtags")
@SuppressWarnings("unused")
public class Hashtags implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenHashtag")
	@SequenceGenerator(name = "seqGenHashtag", sequenceName = "configuration_seq", allocationSize = 1)

	private Long id;
	@NotNull
	@Size(max = 300)
	@Column(name = "Hashtag", length = 300, nullable = false)
	private String Hashtag;
	@NotNull
	@Column(name = "CONTADOR", nullable = false)
	private Long contador;

	public Hashtags setId(Long valor) {
		this.id = valor;
		return this;
	}

	public Hashtags id(Long valor) {
		this.id = valor;
		return this;
	}

	public Long getId() {
		return this.id;
	}

	public Hashtags setHashtag(String valor) {
		this.Hashtag = valor;
		return this;
	}

	public Hashtags Hashtag(String valor) {
		this.Hashtag = valor;
		return this;
	}

	public String getHashtag() {
		return this.Hashtag;
	}

	public Hashtags setContador(Long valor) {
		this.contador = valor;
		return this;
	}

	public Hashtags contador(Long valor) {
		this.contador = valor;
		return this;
	}

	public Long getContador() {
		return this.contador;
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
		Hashtags obj = null;
		try {
			obj = (Hashtags) o;
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
		return "Hashtag{" +

				"id=" + getId() +

				", Hashtag=" + getHashtag() +

				", contador=" + getContador() +

				"}";
	}

}
