

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import com.sine95.tweetsrv.enums.*;



/**
 */
@SuppressWarnings("unused")
public class ParamInCambiaPosTarea implements Serializable
{
	private static final long serialVersionUID = 1L;

	private ColaHilos cola;

	private String id;

	private Integer pos;

	public ParamInCambiaPosTarea()
	{
		super();
	}
	
	public ParamInCambiaPosTarea(ColaHilos cola,String id,Integer pos)
	{

		setCola(cola);

		setId(id);

		setPos(pos);

	}

  public ParamInCambiaPosTarea setCola(ColaHilos valor){
    this.cola=valor;
    return this;
  }

  public ParamInCambiaPosTarea cola(ColaHilos valor){
    this.cola=valor;
    return this;
  }

  public ColaHilos getCola(){
    return this.cola;
  }

  public ParamInCambiaPosTarea setId(String valor){
    this.id=valor;
    return this;
  }

  public ParamInCambiaPosTarea id(String valor){
    this.id=valor;
    return this;
  }

  public String getId(){
    return this.id;
  }

  public ParamInCambiaPosTarea setPos(Integer valor){
    this.pos=valor;
    return this;
  }

  public ParamInCambiaPosTarea pos(Integer valor){
    this.pos=valor;
    return this;
  }

  public Integer getPos(){
    return this.pos;
  }


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ParamInCambiaPosTarea obj = (ParamInCambiaPosTarea) o;

		if (obj.getCola() != getCola()) {
			if (obj.getCola() == null || getCola() == null) return false;
			if (!obj.getCola().equals(getCola())) return false;
		}

		if (obj.getId() != getId()) {
			if (obj.getId() == null || getId() == null) return false;
			if (!obj.getId().equals(getId())) return false;
		}

		if (obj.getPos() != getPos()) {
			if (obj.getPos() == null || getPos() == null) return false;
			if (!obj.getPos().equals(getPos())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getCola()==null?"":getCola().toString())+(getId()==null?"":getId().toString())+(getPos()==null?"":getPos().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "ParamInCambiaPosTarea{" +
			"cola=" + getCola() + ", id=" + getId() + ", pos=" + getPos() + "}";
	}
	



/*


*/
} // Eliminar


