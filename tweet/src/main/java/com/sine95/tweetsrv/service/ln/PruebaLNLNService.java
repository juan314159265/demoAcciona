
package com.sine95.tweetsrv.service.ln;

import org.sine95.kernel.base.errores.IError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;




import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.warnings.*;
import com.sine95.tweetsrv.infos.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.*;
import com.sine95.tweetsrv.service.Config;
import com.sine95.tweetsrv.domain.validator.*;
import java.util.*;
import java.util.stream.*;




/**
* Logica de negocio para probar métodos privados
*/

@SuppressWarnings("unused")
@Service

public class PruebaLNLNService extends LNService
{
  private final Logger log = LoggerFactory.getLogger(PruebaLNLNService.class);



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;







	/**
	* Precondiciones para el metodo Suma.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsSuma(Result< Long > res ,Long num1,Long num2)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:num1 Tipo:Long 

		if(num1==null)
		{
			res.addError(new ErrorParametroObligatorio("num1"));
		}


		//Param:num2 Tipo:Long 

		if(num2==null)
		{
			res.addError(new ErrorParametroObligatorio("num2"));
		}


		
		
		return cache;
	}

	/**
	* Devuelve la suma de los dos enteros como otro entero
	*/




	@Transactional
	public Result< Long > Suma(Long num1,Long num2)
	{
		Result< Long > res=new Result<>();
		String _params_=UtilParams.paramsToString("num1",num1,"num2",num2);
		if (log.isInfoEnabled()) log.info("Entrando en PruebaLNService.Suma ("+_params_+")");
		Map<String,Object> cache=preConditionsSuma( res , num1, num2 );
		if(res.isOk())
		{
			try

			(

			var cacheCachePrueba = cacheService.getCacheAreaCachePrueba().getData();

			)

			{


				
				
				
				String clave = ""+num1+"+"+num2;
				Result<Long> result = cacheCachePrueba.get(clave);
				if(result.isOk() && result.getData()==null)
				{
					Long numRes=num1+num2;
					cacheCachePrueba.set(clave, (Long)numRes);
					res.setData(numRes);
				}
				else
				{
					res.setData(result.getData());
				}
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en PruebaLNServiceCRUD.Suma ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de PruebaLNServiceCRUD.Suma ("+UtilParams.paramsToString("num1",num1,"num2",num2)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de PruebaLNServiceCRUD.Suma ("+UtilParams.paramsToString("num1",num1,"num2",num2)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo Multiplicacion.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsMultiplicacion(Result< Long > res ,Long num1,Long num2)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:num1 Tipo:Long 

		if(num1==null)
		{
			res.addError(new ErrorParametroObligatorio("num1"));
		}


		//Param:num2 Tipo:Long 

		if(num2==null)
		{
			res.addError(new ErrorParametroObligatorio("num2"));
		}


		
		
		return cache;
	}

	/**
	* Devuelve la multiplicación de los dos enteros como otro entero
	*/




	@Transactional
	public Result< Long > Multiplicacion(Long num1,Long num2)
	{
		Result< Long > res=new Result<>();
		String _params_=UtilParams.paramsToString("num1",num1,"num2",num2);
		if (log.isInfoEnabled()) log.info("Entrando en PruebaLNService.Multiplicacion ("+_params_+")");
		Map<String,Object> cache=preConditionsMultiplicacion( res , num1, num2 );
		if(res.isOk())
		{
			try

			{


				
				res.setData(num1*num2);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en PruebaLNServiceCRUD.Multiplicacion ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de PruebaLNServiceCRUD.Multiplicacion ("+UtilParams.paramsToString("num1",num1,"num2",num2)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de PruebaLNServiceCRUD.Multiplicacion ("+UtilParams.paramsToString("num1",num1,"num2",num2)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



//Si hay que annadir metodos se incluyen aqui, se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

