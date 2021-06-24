
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorSinPermiso implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorSinPermiso.class);
 
  //Code:SERVER_SESION_001
   
  public ErrorSinPermiso(
    
   String clave
  , String ruta
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "clave", clave
  , "ruta", ruta
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorSinPermiso ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(clave!=null)
      params.put("clave",clave.toString());
    else 
      params.put("clave","<NULL>");
    
    

    if(ruta!=null)
      params.put("ruta",ruta.toString());
    else 
      params.put("ruta","<NULL>");
    
    



  }
  


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("No tiene permiso para ejecutar la acci?n",getParams());  
  }

	public String getCode(){
    return "SERVER_SESION_001";
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

