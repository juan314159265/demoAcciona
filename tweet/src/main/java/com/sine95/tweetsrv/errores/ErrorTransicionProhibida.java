
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorTransicionProhibida implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorTransicionProhibida.class);
 
  //Code:SM_TRANSITION_FORBIDDEN
   
  public ErrorTransicionProhibida(
    
   String StateMachine
  , String origin
  , String destiny
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "StateMachine", StateMachine
  , "origin", origin
  , "destiny", destiny
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorTransicionProhibida ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(StateMachine!=null)
      params.put("StateMachine",StateMachine.toString());
    else 
      params.put("StateMachine","<NULL>");
    
    

    if(origin!=null)
      params.put("origin",origin.toString());
    else 
      params.put("origin","<NULL>");
    
    

    if(destiny!=null)
      params.put("destiny",destiny.toString());
    else 
      params.put("destiny","<NULL>");
    
    


    categorias.add(EnumCategoriasErrores.SM_LN);

    categorias.add(EnumCategoriasErrores.SM_TE);


  }
  


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("La transicion de la maquina de estados ((StateMachine)) del Estado ((origin)) al ((destiny)) no esta permitida",getParams());  
  }

	public String getCode(){
    return "SM_TRANSITION_FORBIDDEN";
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

