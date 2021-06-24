
package com.sine95.tweetsrv.warnings;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IWarning;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class WarningCorreoNoEnviado implements IWarning
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(WarningCorreoNoEnviado.class);
 
  //Code:MAIL_NOT_SEND
   
  public WarningCorreoNoEnviado(
    
   String tipo
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "tipo", tipo
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isWarnEnabled()) {
	    log.warn("Entrando en WarningCorreoNoEnviado ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(tipo!=null)
      params.put("tipo",tipo.toString());
    else 
      params.put("tipo","<NULL>");
    
    



  }
  


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("No se pudo enviar el correo ((tipo))",getParams());  
  }

	public String getCode(){
    return "MAIL_NOT_SEND";
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
    return "Warning:"+getCode()+"["+getMensaje()+"]";
  }
}

