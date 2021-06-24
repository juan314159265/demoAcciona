

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import com.sine95.tweetsrv.enums.*;



/**
 */
@SuppressWarnings("unused")
public class ParamOutITicket implements Serializable
{
	private static final long serialVersionUID = 1L;

	private ColaHilos cola;

	private String id;

	private String info;

	private Integer pos;

	private String status;

	public ParamOutITicket()
	{
		super();
	}
	
	public ParamOutITicket(ColaHilos cola,String id,String info,Integer pos,String status)
	{

		setCola(cola);

		setId(id);

		setInfo(info);

		setPos(pos);

		setStatus(status);

	}

  public ParamOutITicket setCola(ColaHilos valor){
    this.cola=valor;
    return this;
  }

  public ParamOutITicket cola(ColaHilos valor){
    this.cola=valor;
    return this;
  }

  public ColaHilos getCola(){
    return this.cola;
  }

  public ParamOutITicket setId(String valor){
    this.id=valor;
    return this;
  }

  public ParamOutITicket id(String valor){
    this.id=valor;
    return this;
  }

  public String getId(){
    return this.id;
  }

  public ParamOutITicket setInfo(String valor){
    this.info=valor;
    return this;
  }

  public ParamOutITicket info(String valor){
    this.info=valor;
    return this;
  }

  public String getInfo(){
    return this.info;
  }

  public ParamOutITicket setPos(Integer valor){
    this.pos=valor;
    return this;
  }

  public ParamOutITicket pos(Integer valor){
    this.pos=valor;
    return this;
  }

  public Integer getPos(){
    return this.pos;
  }

  public ParamOutITicket setStatus(String valor){
    this.status=valor;
    return this;
  }

  public ParamOutITicket status(String valor){
    this.status=valor;
    return this;
  }

  public String getStatus(){
    return this.status;
  }


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ParamOutITicket obj = (ParamOutITicket) o;

		if (obj.getCola() != getCola()) {
			if (obj.getCola() == null || getCola() == null) return false;
			if (!obj.getCola().equals(getCola())) return false;
		}

		if (obj.getId() != getId()) {
			if (obj.getId() == null || getId() == null) return false;
			if (!obj.getId().equals(getId())) return false;
		}

		if (obj.getInfo() != getInfo()) {
			if (obj.getInfo() == null || getInfo() == null) return false;
			if (!obj.getInfo().equals(getInfo())) return false;
		}

		if (obj.getPos() != getPos()) {
			if (obj.getPos() == null || getPos() == null) return false;
			if (!obj.getPos().equals(getPos())) return false;
		}

		if (obj.getStatus() != getStatus()) {
			if (obj.getStatus() == null || getStatus() == null) return false;
			if (!obj.getStatus().equals(getStatus())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getCola()==null?"":getCola().toString())+(getId()==null?"":getId().toString())+(getInfo()==null?"":getInfo().toString())+(getPos()==null?"":getPos().toString())+(getStatus()==null?"":getStatus().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "ParamOutITicket{" +
			"cola=" + getCola() + ", id=" + getId() + ", info=" + getInfo() + ", pos=" + getPos() + ", status=" + getStatus() + "}";
	}
	



/*


*/
} // Eliminar


