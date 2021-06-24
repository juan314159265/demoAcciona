
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorIdComplejoNoEncontrado implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorIdComplejoNoEncontrado.class);
 
  //Code:SERVER_CRUD_002_1
   
  public ErrorIdComplejoNoEncontrado(
    
   String clase
  , String id
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "clase", clase
  , "id", id
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorIdComplejoNoEncontrado ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(clase!=null)
      params.put("clase",clase.toString());
    else 
      params.put("clase","<NULL>");
    
    

    if(id!=null)
      params.put("id",id.toString());
    else 
      params.put("id","<NULL>");
    
    



  }
  


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("No se encuentra la entidad de la clase ((clase)) con el id ((id))",getParams());  
  }

	public String getCode(){
    return "SERVER_CRUD_002_1";
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

