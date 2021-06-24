
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorRelacionSinElementos implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorRelacionSinElementos.class);
 
  //Code:SERVER_CRUD_003
   
  public ErrorRelacionSinElementos(
    
   String relacion
  , Object entidad
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "relacion", relacion
  , "entidad", entidad
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorRelacionSinElementos ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(relacion!=null)
      params.put("relacion",relacion.toString());
    else 
      params.put("relacion","<NULL>");
    
    

    if(entidad!=null)
      params.put("entidad",entidad.toString());
    else 
      params.put("entidad","<NULL>");
    
    



  }
  

  public ErrorRelacionSinElementos(
    
   String relacion
  , String entidad
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "relacion", relacion
  , "entidad", entidad
      
    );
    
    
    
      params.put("relacion",relacion);
    
      params.put("entidad",entidad);
    



  }


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("No se encuentran elementos para la relacion ((relacion)) en la entidad ((entidad))",getParams());  
  }

	public String getCode(){
    return "SERVER_CRUD_003";
  }

	public Map<String, Object> getParams()
  {
    HashMap<String,Object> res= new HashMap<>();
    res.putAll(params);
    return res;
  }

  public boolean isPerteneceCategoria(EnumCategoriasErrores categ)
  {
    return categorias.contains(categ);
  }

  public Set<EnumCategoriasErrores> getCategorias()
  {
    Set<EnumCategoriasErrores> res=new HashSet<>();
    res.addAll(categorias);
    return res;
  }
  @Override
  public String toString()
  {
    return "Error:"+getCode()+"["+getMensaje()+"]";
  }
}

