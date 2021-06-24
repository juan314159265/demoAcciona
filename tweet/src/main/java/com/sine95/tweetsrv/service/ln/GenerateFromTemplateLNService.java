
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


import org.springframework.core.io.ClassPathResource;
import groovy.json.JsonSlurper;
import groovy.lang.Writable;
import groovy.text.StreamingTemplateEngine;
import groovy.text.Template;


/**
* Logica de negocio para probar métodos privados
*/

@SuppressWarnings("unused")
@Service

public class GenerateFromTemplateLNService extends LNService
{
  private final Logger log = LoggerFactory.getLogger(GenerateFromTemplateLNService.class);



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;







	/**
	* Precondiciones para el metodo GenerateFromWithJSON.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGenerateFromWithJSON(Result< String > res ,String template,String JSonStringParams)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:template Tipo:String 

		if(template==null)
		{
			res.addError(new ErrorParametroObligatorio("template"));
		}


		//Param:JSonStringParams Tipo:String 

		if(JSonStringParams==null)
		{
			res.addError(new ErrorParametroObligatorio("JSonStringParams"));
		}


		
		
		return cache;
	}

	/**
	* Devuelve El contenido del correo después de haber hecho las sustituciones de los parámetros. El conenido se toma como una template de groovy
	*/




	public Result< String > GenerateFromWithJSON(String template,String JSonStringParams)
	{
		Result< String > res=new Result<>();
		String _params_=UtilParams.paramsToString("template",template,"JSonStringParams",JSonStringParams);
		if (log.isInfoEnabled()) log.info("Entrando en GenerateFromTemplateService.GenerateFromWithJSON ("+_params_+")");
		Map<String,Object> cache=preConditionsGenerateFromWithJSON( res , template, JSonStringParams );
		if(res.isOk())
		{
			try

			{


				
				ClassPathResource cpr = new ClassPathResource("ang_templates/"+template+".tpl");
				InputStream inputStream = cpr.getInputStream();

				JsonSlurper jsonSlurper = new JsonSlurper();
				Object obj = jsonSlurper.parseText(JSonStringParams);
				StreamingTemplateEngine engine=new StreamingTemplateEngine();

				InputStreamReader reader = new InputStreamReader(inputStream);
				Template tmp = engine.createTemplate(reader);
				reader.close();

				Map<String,Object> contexto=getContexto(obj);

				Writable make = tmp.make(contexto);

				res.setData(make.toString());

				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GenerateFromTemplateServiceCRUD.GenerateFromWithJSON ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GenerateFromTemplateServiceCRUD.GenerateFromWithJSON ("+UtilParams.paramsToString("template",template,"JSonStringParams",JSonStringParams)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo GenerateFromStringTemplateWithJSON.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGenerateFromStringTemplateWithJSON(Result< String > res ,String template,String JSonStringParams)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:template Tipo:String 

		if(template==null)
		{
			res.addError(new ErrorParametroObligatorio("template"));
		}


		//Param:JSonStringParams Tipo:String 

		if(JSonStringParams==null)
		{
			res.addError(new ErrorParametroObligatorio("JSonStringParams"));
		}


		
		
		return cache;
	}

	/**
	* Devuelve El contenido la cadena del template después de haber hecho las sustituciones de los parámetros. El contenido se toma como una template de groovy
	*/




	public Result< String > GenerateFromStringTemplateWithJSON(String template,String JSonStringParams)
	{
		Result< String > res=new Result<>();
		String _params_=UtilParams.paramsToString("template",template,"JSonStringParams",JSonStringParams);
		if (log.isInfoEnabled()) log.info("Entrando en GenerateFromTemplateService.GenerateFromStringTemplateWithJSON ("+_params_+")");
		Map<String,Object> cache=preConditionsGenerateFromStringTemplateWithJSON( res , template, JSonStringParams );
		if(res.isOk())
		{
			try

			{


				
				
				JsonSlurper jsonSlurper = new JsonSlurper();
				Object obj = jsonSlurper.parseText(JSonStringParams);
				StreamingTemplateEngine engine=new StreamingTemplateEngine();
				
				Template tmp = engine.createTemplate(template);

				Map<String,Object> contexto=getContexto(obj);

				Writable make = tmp.make(contexto);

				res.setData(make.toString());
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GenerateFromTemplateServiceCRUD.GenerateFromStringTemplateWithJSON ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GenerateFromTemplateServiceCRUD.GenerateFromStringTemplateWithJSON ("+UtilParams.paramsToString("template",template,"JSonStringParams",JSonStringParams)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo GenerateFromStringTemplateWithMap.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGenerateFromStringTemplateWithMap(Result< String > res ,String template,Map<String,Object> model)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:template Tipo:String 

		if(template==null)
		{
			res.addError(new ErrorParametroObligatorio("template"));
		}


		//Param:model Tipo:String,Object 

		if(model==null)
		{
			res.addError(new ErrorParametroObligatorio("model"));
		}


		
		
		return cache;
	}

	/**
	* Devuelve El contenido la cadena del template después de haber hecho las sustituciones de los parámetros. El contenido se toma como una template de groovy.
	* Nota: el model debe ser un Map<String,Object>
	*/




	public Result< String > GenerateFromStringTemplateWithMap(String template,Map<String,Object> model)
	{
		Result< String > res=new Result<>();
		String _params_=UtilParams.paramsToString("template",template,"model",model);
		if (log.isInfoEnabled()) log.info("Entrando en GenerateFromTemplateService.GenerateFromStringTemplateWithMap ("+_params_+")");
		Map<String,Object> cache=preConditionsGenerateFromStringTemplateWithMap( res , template, model );
		if(res.isOk())
		{
			try

			{


				
				StreamingTemplateEngine engine=new StreamingTemplateEngine();
				
				Template tmp = engine.createTemplate(template);
				
				Writable make = tmp.make(getContexto(model));

				res.setData(make.toString());
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GenerateFromTemplateServiceCRUD.GenerateFromStringTemplateWithMap ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GenerateFromTemplateServiceCRUD.GenerateFromStringTemplateWithMap ("+UtilParams.paramsToString("template",template,"model",model)+"). Result:"+res.toString());


		return res;
	}




	private Map<String, Object> getContexto(Object obj) {

		Map<String, Object> res=new HashMap<String, Object>();
		res.put("model",obj);
		return res;
	}


/*


*/
}

