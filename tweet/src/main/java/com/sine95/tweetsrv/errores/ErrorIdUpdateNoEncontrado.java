
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorIdUpdateNoEncontrado implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorIdUpdateNoEncontrado.class);
 
  //Code:SERVER_CRUD_001
   
  public ErrorIdUpdateNoEncontrado(
    
   Object objeto
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "objeto", objeto
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorIdUpdateNoEncontrado ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(objeto!=null)
      params.put("objeto",objeto.toString());
    else 
      params.put("objeto","<NULL>");
    
    



  }
  

  public ErrorIdUpdateNoEncontrado(
    
   String objeto
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "objeto", objeto
      
    );
    
    
    
      params.put("objeto",objeto);
    



  }


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("No se encuentra el id del objeto:((objeto))",getParams());  
  }

	public String getCode(){
    return "SERVER_CRUD_001";
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

