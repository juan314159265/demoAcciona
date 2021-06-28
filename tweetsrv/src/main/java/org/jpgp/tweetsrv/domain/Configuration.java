package org.jpgp.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;

/**
* 
*/

@Entity(name = "Configuration")
@Table(name = "CONFIGURATION")
@SuppressWarnings("unused")
public class Configuration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenConfiguration")
	@SequenceGenerator(name = "seqGenConfiguration", sequenceName = "configuration_seq", allocationSize = 1)

	private Long id;
	@NotNull
	@Size(max = 300)
	@Column(name = "KEYID", length = 300, nullable = false)
	private String keyid;
	@NotNull
	@Size(max = 4000)
	@Column(name = "VALUE", length = 4000, nullable = false)
	private String value;
	@NotNull
	@Size(max = 30)
	@Column(name = "TYPE", length = 30, nullable = false)
	private String type;
	@NotNull
	@Size(max = 4000)
	@Column(name = "DESCRIPTION", length = 4000, nullable = false)
	private String description;



	public Configuration setId(Long valor) {
		this.id = valor;
		return this;
	}

	public Configuration id(Long valor) {
		this.id = valor;
		return this;
	}

	public Long getId() {
		return this.id;
	}

	public Configuration setKeyid(String valor) {
		this.keyid = valor;
		return this;
	}

	public Configuration keyid(String valor) {
		this.keyid = valor;
		return this;
	}

	public String getKeyid() {
		return this.keyid;
	}

	public Configuration setValue(String valor) {
		this.value = valor;
		return this;
	}

	public Configuration value(String valor) {
		this.value = valor;
		return this;
	}

	public String getValue() {
		return this.value;
	}

	public Configuration setType(String valor) {
		this.type = valor;
		return this;
	}

	public Configuration type(String valor) {
		this.type = valor;
		return this;
	}

	public String getType() {
		return this.type;
	}

	public Configuration setDescription(String valor) {
		this.description = valor;
		return this;
	}

	public Configuration description(String valor) {
		this.description = valor;
		return this;
	}

	public Configuration() {
		super();
	}

	public Configuration(@NotNull @Size(max = 300) String keyid, @NotNull @Size(max = 4000) String value,
			@NotNull @Size(max = 30) String type, @NotNull @Size(max = 4000) String description) {
		super();
		this.keyid = keyid;
		this.value = value;
		this.type = type;
		this.description = description;
	}

	public String getDescription() {
		return this.description;
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
		Configuration obj = null;
		try {
			obj = (Configuration) o;
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
		return "Configuration{" +

				"id=" + getId() +

				", keyid=" + getKeyid() +

				", value=" + getValue() +

				", type=" + getType() +

				", description=" + getDescription() +

				"}";
	}
}
