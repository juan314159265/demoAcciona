
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorEnumeradoNoExistente implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorEnumeradoNoExistente.class);
 
  //Code:SERVER_GEN_004
   
  public ErrorEnumeradoNoExistente(
    
   String tipoEnumerado
  , String valor
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "tipoEnumerado", tipoEnumerado
  , "valor", valor
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorEnumeradoNoExistente ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(tipoEnumerado!=null)
      params.put("tipoEnumerado",tipoEnumerado.toString());
    else 
      params.put("tipoEnumerado","<NULL>");
    
    

    if(valor!=null)
      params.put("valor",valor.toString());
    else 
      params.put("valor","<NULL>");
    
    



  }
  


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("El enumerado ((tipoEnumerado)) no tiene el valor solicitado: ((valor))",getParams());  
  }

	public String getCode(){
    return "SERVER_GEN_004";
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

