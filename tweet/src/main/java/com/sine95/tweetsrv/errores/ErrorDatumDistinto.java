
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorDatumDistinto implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorDatumDistinto.class);
 
  //Code:JSON_CMP_NOT_EQUAL
   
  public ErrorDatumDistinto(
    
   String clave
  , Object obj1
  , Object obj2
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "clave", clave
  , "obj1", obj1
  , "obj2", obj2
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorDatumDistinto ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(clave!=null)
      params.put("clave",clave.toString());
    else 
      params.put("clave","<NULL>");
    
    

    if(obj1!=null)
      params.put("obj1",obj1.toString());
    else 
      params.put("obj1","<NULL>");
    
    

    if(obj2!=null)
      params.put("obj2",obj2.toString());
    else 
      params.put("obj2","<NULL>");
    
    



  }
  

  public ErrorDatumDistinto(
    
   String clave
  , String obj1
  , String obj2
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "clave", clave
  , "obj1", obj1
  , "obj2", obj2
      
    );
    
    
    
      params.put("clave",clave);
    
      params.put("obj1",obj1);
    
      params.put("obj2",obj2);
    



  }


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("La clave ((clave)) no tiene los mismo valores. El primero es ((obj1)) y el segundo es ((obj2))",getParams());  
  }

	public String getCode(){
    return "JSON_CMP_NOT_EQUAL";
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

