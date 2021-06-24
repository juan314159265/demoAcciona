
package com.sine95.tweetsrv.warnings;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IWarning;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class WarningCacheElValorEsNulo implements IWarning
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(WarningCacheElValorEsNulo.class);
 
  //Code:CACHE_VALOR_NULO
   
  public WarningCacheElValorEsNulo(
    
   Object clave
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "clave", clave
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isWarnEnabled()) {
	    log.warn("Entrando en WarningCacheElValorEsNulo ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(clave!=null)
      params.put("clave",clave.toString());
    else 
      params.put("clave","<NULL>");
    
    



  }
  

  public WarningCacheElValorEsNulo(
    
   String clave
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "clave", clave
      
    );
    
    
    
      params.put("clave",clave);
    



  }


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("La clave ((tipo)) del cache tiene valor nulo",getParams());  
  }

	public String getCode(){
    return "CACHE_VALOR_NULO";
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

