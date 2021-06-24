
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;






/**
* 
*/

@SuppressWarnings("unused")
public class LogTaskExt  implements Serializable
{
	private static final long serialVersionUID = 1L;

	//id
	private Long id;
	private Collection< Long > id_IN;
	private Collection< Long > id_NOTIN;

	public Long getId()
	{
		return id;
	}
	public LogTaskExt setId(Long _id)
	{
		id=_id;
		return this;
	}
	public Collection< Long > getId_IN()
	{
		return id_IN;
	}
	public LogTaskExt setId_IN(Collection< Long > _id)
	{
		id_IN=_id;
		return this;
	}
	public Collection< Long > getId_NOTIN()
	{
		return id_NOTIN;
	}
	public LogTaskExt setId_NOTIN(Collection< Long > _id)
	{
		id_NOTIN=_id;
		return this;
	}





	private Long id_DISTINCT;
	private Long id_GREATERTHAN;
	private Long id_GREATEROREQUALTHAN;
	private Long id_LESSTHAN;
	private Long id_LESSOREQUALTHAN;

	public Long getId_DISTINCT()
	{
		return id_DISTINCT;
	}
	public LogTaskExt setId_DISTINCT(Long _id)
	{
		id_DISTINCT=_id;
		return this;
	}

	public Long getId_GREATERTHAN()
	{
		return id_GREATERTHAN;
	}
	public LogTaskExt setId_GREATERTHAN(Long _id)
	{
		id_GREATERTHAN=_id;
		return this;
	}

	public Long getId_GREATEROREQUALTHAN()
	{
		return id_GREATEROREQUALTHAN;
	}
	public LogTaskExt setId_GREATEROREQUALTHAN(Long _id)
	{
		id_GREATEROREQUALTHAN=_id;
		return this;
	}

	public Long getId_LESSTHAN()
	{
		return id_LESSTHAN;
	}
	public LogTaskExt setId_LESSTHAN(Long _id)
	{
		id_LESSTHAN=_id;
		return this;
	}

	public Long getId_LESSOREQUALTHAN()
	{
		return id_LESSOREQUALTHAN;
	}
	public LogTaskExt setId_LESSOREQUALTHAN(Long _id)
	{
		id_LESSOREQUALTHAN=_id;
		return this;
	}



	//horaInicio
	private Date horaInicio;
	private Collection< Date > horaInicio_IN;
	private Collection< Date > horaInicio_NOTIN;

	public Date getHoraInicio()
	{
		return horaInicio;
	}
	public LogTaskExt setHoraInicio(Date _horaInicio)
	{
		horaInicio=_horaInicio;
		return this;
	}
	public Collection< Date > getHoraInicio_IN()
	{
		return horaInicio_IN;
	}
	public LogTaskExt setHoraInicio_IN(Collection< Date > _horaInicio)
	{
		horaInicio_IN=_horaInicio;
		return this;
	}
	public Collection< Date > getHoraInicio_NOTIN()
	{
		return horaInicio_NOTIN;
	}
	public LogTaskExt setHoraInicio_NOTIN(Collection< Date > _horaInicio)
	{
		horaInicio_NOTIN=_horaInicio;
		return this;
	}





	private Date horaInicio_DISTINCT;
	private Date horaInicio_GREATERTHAN;
	private Date horaInicio_GREATEROREQUALTHAN;
	private Date horaInicio_LESSTHAN;
	private Date horaInicio_LESSOREQUALTHAN;

	public Date getHoraInicio_DISTINCT()
	{
		return horaInicio_DISTINCT;
	}
	public LogTaskExt setHoraInicio_DISTINCT(Date _horaInicio)
	{
		horaInicio_DISTINCT=_horaInicio;
		return this;
	}

	public Date getHoraInicio_GREATERTHAN()
	{
		return horaInicio_GREATERTHAN;
	}
	public LogTaskExt setHoraInicio_GREATERTHAN(Date _horaInicio)
	{
		horaInicio_GREATERTHAN=_horaInicio;
		return this;
	}

	public Date getHoraInicio_GREATEROREQUALTHAN()
	{
		return horaInicio_GREATEROREQUALTHAN;
	}
	public LogTaskExt setHoraInicio_GREATEROREQUALTHAN(Date _horaInicio)
	{
		horaInicio_GREATEROREQUALTHAN=_horaInicio;
		return this;
	}

	public Date getHoraInicio_LESSTHAN()
	{
		return horaInicio_LESSTHAN;
	}
	public LogTaskExt setHoraInicio_LESSTHAN(Date _horaInicio)
	{
		horaInicio_LESSTHAN=_horaInicio;
		return this;
	}

	public Date getHoraInicio_LESSOREQUALTHAN()
	{
		return horaInicio_LESSOREQUALTHAN;
	}
	public LogTaskExt setHoraInicio_LESSOREQUALTHAN(Date _horaInicio)
	{
		horaInicio_LESSOREQUALTHAN=_horaInicio;
		return this;
	}



	//horaFin
	private Date horaFin;
	private Collection< Date > horaFin_IN;
	private Collection< Date > horaFin_NOTIN;

	public Date getHoraFin()
	{
		return horaFin;
	}
	public LogTaskExt setHoraFin(Date _horaFin)
	{
		horaFin=_horaFin;
		return this;
	}
	public Collection< Date > getHoraFin_IN()
	{
		return horaFin_IN;
	}
	public LogTaskExt setHoraFin_IN(Collection< Date > _horaFin)
	{
		horaFin_IN=_horaFin;
		return this;
	}
	public Collection< Date > getHoraFin_NOTIN()
	{
		return horaFin_NOTIN;
	}
	public LogTaskExt setHoraFin_NOTIN(Collection< Date > _horaFin)
	{
		horaFin_NOTIN=_horaFin;
		return this;
	}

	private boolean horaFin_ISNOTNULL;
	private boolean horaFin_ISNULL;

	public boolean getHoraFin_ISNOTNULL()
	{
		return horaFin_ISNOTNULL;
	}
	public LogTaskExt setHoraFin_ISNOTNULL(boolean _horaFin)
	{
		horaFin_ISNOTNULL=_horaFin;
		return this;
	}
	public boolean getHoraFin_ISNULL()
	{
		return horaFin_ISNULL;
	}
	public LogTaskExt setHoraFin_ISNULL(boolean _horaFin)
	{
		horaFin_ISNULL=_horaFin;
		return this;
	}





	private Date horaFin_DISTINCT;
	private Date horaFin_GREATERTHAN;
	private Date horaFin_GREATEROREQUALTHAN;
	private Date horaFin_LESSTHAN;
	private Date horaFin_LESSOREQUALTHAN;

	public Date getHoraFin_DISTINCT()
	{
		return horaFin_DISTINCT;
	}
	public LogTaskExt setHoraFin_DISTINCT(Date _horaFin)
	{
		horaFin_DISTINCT=_horaFin;
		return this;
	}

	public Date getHoraFin_GREATERTHAN()
	{
		return horaFin_GREATERTHAN;
	}
	public LogTaskExt setHoraFin_GREATERTHAN(Date _horaFin)
	{
		horaFin_GREATERTHAN=_horaFin;
		return this;
	}

	public Date getHoraFin_GREATEROREQUALTHAN()
	{
		return horaFin_GREATEROREQUALTHAN;
	}
	public LogTaskExt setHoraFin_GREATEROREQUALTHAN(Date _horaFin)
	{
		horaFin_GREATEROREQUALTHAN=_horaFin;
		return this;
	}

	public Date getHoraFin_LESSTHAN()
	{
		return horaFin_LESSTHAN;
	}
	public LogTaskExt setHoraFin_LESSTHAN(Date _horaFin)
	{
		horaFin_LESSTHAN=_horaFin;
		return this;
	}

	public Date getHoraFin_LESSOREQUALTHAN()
	{
		return horaFin_LESSOREQUALTHAN;
	}
	public LogTaskExt setHoraFin_LESSOREQUALTHAN(Date _horaFin)
	{
		horaFin_LESSOREQUALTHAN=_horaFin;
		return this;
	}



	//clase
	private String clase;
	private Collection< String > clase_IN;
	private Collection< String > clase_NOTIN;

	public String getClase()
	{
		return clase;
	}
	public LogTaskExt setClase(String _clase)
	{
		clase=_clase;
		return this;
	}
	public Collection< String > getClase_IN()
	{
		return clase_IN;
	}
	public LogTaskExt setClase_IN(Collection< String > _clase)
	{
		clase_IN=_clase;
		return this;
	}
	public Collection< String > getClase_NOTIN()
	{
		return clase_NOTIN;
	}
	public LogTaskExt setClase_NOTIN(Collection< String > _clase)
	{
		clase_NOTIN=_clase;
		return this;
	}



	private String clase_LIKE;
	private String clase_NOTLIKE;

	public String getClase_LIKE()
	{
		return clase_LIKE;
	}
	public LogTaskExt setClase_LIKE(String _clase)
	{
		clase_LIKE=_clase;
		return this;
	}
	public String getClase_NOTLIKE()
	{
		return clase_NOTLIKE;
	}
	public LogTaskExt setClase_NOTLIKE(String _clase)
	{
		clase_NOTLIKE=_clase;
		return this;
	}





	//metodo
	private String metodo;
	private Collection< String > metodo_IN;
	private Collection< String > metodo_NOTIN;

	public String getMetodo()
	{
		return metodo;
	}
	public LogTaskExt setMetodo(String _metodo)
	{
		metodo=_metodo;
		return this;
	}
	public Collection< String > getMetodo_IN()
	{
		return metodo_IN;
	}
	public LogTaskExt setMetodo_IN(Collection< String > _metodo)
	{
		metodo_IN=_metodo;
		return this;
	}
	public Collection< String > getMetodo_NOTIN()
	{
		return metodo_NOTIN;
	}
	public LogTaskExt setMetodo_NOTIN(Collection< String > _metodo)
	{
		metodo_NOTIN=_metodo;
		return this;
	}



	private String metodo_LIKE;
	private String metodo_NOTLIKE;

	public String getMetodo_LIKE()
	{
		return metodo_LIKE;
	}
	public LogTaskExt setMetodo_LIKE(String _metodo)
	{
		metodo_LIKE=_metodo;
		return this;
	}
	public String getMetodo_NOTLIKE()
	{
		return metodo_NOTLIKE;
	}
	public LogTaskExt setMetodo_NOTLIKE(String _metodo)
	{
		metodo_NOTLIKE=_metodo;
		return this;
	}





	//errores
	private String errores;
	private Collection< String > errores_IN;
	private Collection< String > errores_NOTIN;

	public String getErrores()
	{
		return errores;
	}
	public LogTaskExt setErrores(String _errores)
	{
		errores=_errores;
		return this;
	}
	public Collection< String > getErrores_IN()
	{
		return errores_IN;
	}
	public LogTaskExt setErrores_IN(Collection< String > _errores)
	{
		errores_IN=_errores;
		return this;
	}
	public Collection< String > getErrores_NOTIN()
	{
		return errores_NOTIN;
	}
	public LogTaskExt setErrores_NOTIN(Collection< String > _errores)
	{
		errores_NOTIN=_errores;
		return this;
	}

	private boolean errores_ISNOTNULL;
	private boolean errores_ISNULL;

	public boolean getErrores_ISNOTNULL()
	{
		return errores_ISNOTNULL;
	}
	public LogTaskExt setErrores_ISNOTNULL(boolean _errores)
	{
		errores_ISNOTNULL=_errores;
		return this;
	}
	public boolean getErrores_ISNULL()
	{
		return errores_ISNULL;
	}
	public LogTaskExt setErrores_ISNULL(boolean _errores)
	{
		errores_ISNULL=_errores;
		return this;
	}



	private String errores_LIKE;
	private String errores_NOTLIKE;

	public String getErrores_LIKE()
	{
		return errores_LIKE;
	}
	public LogTaskExt setErrores_LIKE(String _errores)
	{
		errores_LIKE=_errores;
		return this;
	}
	public String getErrores_NOTLIKE()
	{
		return errores_NOTLIKE;
	}
	public LogTaskExt setErrores_NOTLIKE(String _errores)
	{
		errores_NOTLIKE=_errores;
		return this;
	}





	//warnings
	private String warnings;
	private Collection< String > warnings_IN;
	private Collection< String > warnings_NOTIN;

	public String getWarnings()
	{
		return warnings;
	}
	public LogTaskExt setWarnings(String _warnings)
	{
		warnings=_warnings;
		return this;
	}
	public Collection< String > getWarnings_IN()
	{
		return warnings_IN;
	}
	public LogTaskExt setWarnings_IN(Collection< String > _warnings)
	{
		warnings_IN=_warnings;
		return this;
	}
	public Collection< String > getWarnings_NOTIN()
	{
		return warnings_NOTIN;
	}
	public LogTaskExt setWarnings_NOTIN(Collection< String > _warnings)
	{
		warnings_NOTIN=_warnings;
		return this;
	}

	private boolean warnings_ISNOTNULL;
	private boolean warnings_ISNULL;

	public boolean getWarnings_ISNOTNULL()
	{
		return warnings_ISNOTNULL;
	}
	public LogTaskExt setWarnings_ISNOTNULL(boolean _warnings)
	{
		warnings_ISNOTNULL=_warnings;
		return this;
	}
	public boolean getWarnings_ISNULL()
	{
		return warnings_ISNULL;
	}
	public LogTaskExt setWarnings_ISNULL(boolean _warnings)
	{
		warnings_ISNULL=_warnings;
		return this;
	}



	private String warnings_LIKE;
	private String warnings_NOTLIKE;

	public String getWarnings_LIKE()
	{
		return warnings_LIKE;
	}
	public LogTaskExt setWarnings_LIKE(String _warnings)
	{
		warnings_LIKE=_warnings;
		return this;
	}
	public String getWarnings_NOTLIKE()
	{
		return warnings_NOTLIKE;
	}
	public LogTaskExt setWarnings_NOTLIKE(String _warnings)
	{
		warnings_NOTLIKE=_warnings;
		return this;
	}





	//infos
	private String infos;
	private Collection< String > infos_IN;
	private Collection< String > infos_NOTIN;

	public String getInfos()
	{
		return infos;
	}
	public LogTaskExt setInfos(String _infos)
	{
		infos=_infos;
		return this;
	}
	public Collection< String > getInfos_IN()
	{
		return infos_IN;
	}
	public LogTaskExt setInfos_IN(Collection< String > _infos)
	{
		infos_IN=_infos;
		return this;
	}
	public Collection< String > getInfos_NOTIN()
	{
		return infos_NOTIN;
	}
	public LogTaskExt setInfos_NOTIN(Collection< String > _infos)
	{
		infos_NOTIN=_infos;
		return this;
	}

	private boolean infos_ISNOTNULL;
	private boolean infos_ISNULL;

	public boolean getInfos_ISNOTNULL()
	{
		return infos_ISNOTNULL;
	}
	public LogTaskExt setInfos_ISNOTNULL(boolean _infos)
	{
		infos_ISNOTNULL=_infos;
		return this;
	}
	public boolean getInfos_ISNULL()
	{
		return infos_ISNULL;
	}
	public LogTaskExt setInfos_ISNULL(boolean _infos)
	{
		infos_ISNULL=_infos;
		return this;
	}



	private String infos_LIKE;
	private String infos_NOTLIKE;

	public String getInfos_LIKE()
	{
		return infos_LIKE;
	}
	public LogTaskExt setInfos_LIKE(String _infos)
	{
		infos_LIKE=_infos;
		return this;
	}
	public String getInfos_NOTLIKE()
	{
		return infos_NOTLIKE;
	}
	public LogTaskExt setInfos_NOTLIKE(String _infos)
	{
		infos_NOTLIKE=_infos;
		return this;
	}





	private String orderby[];

	public String [] getOrderBy()
	{
		return orderby;
	}

	public LogTaskExt setOrderBy(String[] order)
	{
		orderby=order;
		return this;
	}

	private Integer maxElemsPerPage=10;
	private Integer page=0;

	public Integer  getMaxElemsPerPage()
	{
		return maxElemsPerPage;
	}

	public LogTaskExt setMaxElemsPerPage(Integer max)
	{
		maxElemsPerPage=max;
		return this;
	}
	public Integer  getPage()
	{
		return page;
	}

	public LogTaskExt setPage(Integer page)
	{
		this.page=page;
		return this;
	}





/*


*/
}


