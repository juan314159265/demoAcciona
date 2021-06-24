
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorDecimalPrecision implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorDecimalPrecision.class);
 
  //Code:VAL_DECIMAL_PRECISION
   
  public ErrorDecimalPrecision(
    
   String clase
  , String campo
  , int precision
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "clase", clase
  , "campo", campo
  , "precision", precision
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorDecimalPrecision ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(clase!=null)
      params.put("clase",clase.toString());
    else 
      params.put("clase","<NULL>");
    
    

    if(campo!=null)
      params.put("campo",campo.toString());
    else 
      params.put("campo","<NULL>");
    
    
      params.put("precision",Integer.toString(precision));
    
    



  }
  

  public ErrorDecimalPrecision(
    
   String clase
  , String campo
  , String precision
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "clase", clase
  , "campo", campo
  , "precision", precision
      
    );
    
    
    
      params.put("clase",clase);
    
      params.put("campo",campo);
    
      params.put("precision",precision);
    



  }


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("La clase ((clase)) tiene en el campo ((campo)) una precisi?n (n?mero total de dígitos) mayor de la admitida: ((precision)) dígitos",getParams());  
  }

	public String getCode(){
    return "VAL_DECIMAL_PRECISION";
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

