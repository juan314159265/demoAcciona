
package com.sine95.tweetsrv.service.ln;

import org.sine95.kernel.base.errores.IError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;


//entity
import com.sine95.tweetsrv.domain.Configuration;
import com.sine95.tweetsrv.domain.ConfigurationCrit;
import com.sine95.tweetsrv.domain.ConfigurationCritPaged;
import com.sine95.tweetsrv.service.crud.ConfigurationServiceCRUD;

//import com.sine95.tweetsrv.domain.ConfigurationExt;
import com.sine95.tweetsrv.domain.ConfigurationExt;

//entity
import com.sine95.tweetsrv.domain.J314User;
import com.sine95.tweetsrv.domain.J314UserCrit;
import com.sine95.tweetsrv.domain.J314UserCritPaged;
import com.sine95.tweetsrv.service.crud.J314UserServiceCRUD;

//import com.sine95.tweetsrv.domain.J314UserExt;
import com.sine95.tweetsrv.domain.J314UserExt;

//enum

import com.sine95.tweetsrv.enums.AreasCache;
    


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


import org.sine95.kernel.base.cache.*;
import org.sine95.kernel.base.cache.impl.*;
import com.sine95.tweetsrv.service.ln.impl.cache.ConfigurationAutoFind;
import com.sine95.tweetsrv.service.ln.impl.cache.SecurityAutoFind;
import java.util.Map.Entry;
import org.sine95.kernel.base.cache.RedisCache;
import org.sine95.kernel.util.Vacio;
import com.sine95.tweetsrv.config.StartAppConfiguration;


/**
* Lógica de negocio para la gestión caches
*/

@SuppressWarnings("unused")
@Service

public class CacheLNService extends LNService
{
  private final Logger log = LoggerFactory.getLogger(CacheLNService.class);

	@Autowired
  	protected StartAppConfiguration sac;


    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected ConfigurationServiceCRUD configurationService;

    @Autowired
    protected J314UserServiceCRUD j314UserService;







	/**
	* Precondiciones para el metodo getCacheAreaConfiguration.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetCacheAreaConfiguration(Result< ICache<Configuration> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Devuelve la instancia de cache del Area Configuration
	*/




	public Result< ICache<Configuration> > getCacheAreaConfiguration()
	{
		Result< ICache<Configuration> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en CacheService.getCacheAreaConfiguration ("+_params_+")");
		Map<String,Object> cache=preConditionsGetCacheAreaConfiguration( res  );
		if(res.isOk())
		{
			try

			{


				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				
				
				                ICacheExt< Configuration > obj = null;
				try {
					
					if("N".equalsIgnoreCase(sac.getModeTest()))
					{
						obj = MapCache.getInstance(AreasCache.Configuration);
					}
					else {
						obj = NullCache.getInstance(AreasCache.Configuration);
					}
					if(obj.getAutoFind()==null)
					{
						obj.setAutoFind(new com.sine95.tweetsrv.service.ln.impl.cache.ConfigurationAutoFind(appContext));
					}

                	
				}catch(Exception e)
				{
					obj=new NullCache<>();
					res.addError(new ErrorGeneral(e));
				}
				res.setData(obj);

				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				


			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en CacheServiceCRUD.getCacheAreaConfiguration ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de CacheServiceCRUD.getCacheAreaConfiguration ("+UtilParams.paramsToString()+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo getCacheAreaSecurity.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetCacheAreaSecurity(Result< ICache<Set<String>> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Devuelve la instancia de cache del Area Security
	*/




	public Result< ICache<Set<String>> > getCacheAreaSecurity()
	{
		Result< ICache<Set<String>> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en CacheService.getCacheAreaSecurity ("+_params_+")");
		Map<String,Object> cache=preConditionsGetCacheAreaSecurity( res  );
		if(res.isOk())
		{
			try

			{


				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				
				
				                ICacheExt< Set<String> > obj = null;
				try {
					
					if("N".equalsIgnoreCase(sac.getModeTest()))
					{
						obj = MapCache.getInstance(AreasCache.Security);
					}
					else {
						obj = NullCache.getInstance(AreasCache.Security);
					}
					if(obj.getAutoFind()==null)
					{
						obj.setAutoFind(new com.sine95.tweetsrv.service.ln.impl.cache.SecurityAutoFind(appContext));
					}

                	
				}catch(Exception e)
				{
					obj=new NullCache<>();
					res.addError(new ErrorGeneral(e));
				}
				res.setData(obj);

				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				


			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en CacheServiceCRUD.getCacheAreaSecurity ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de CacheServiceCRUD.getCacheAreaSecurity ("+UtilParams.paramsToString()+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo getCacheAreaUserFromId.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetCacheAreaUserFromId(Result< ICache<J314User> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Devuelve la instancia de cache del Area UserFromId
	*/




	public Result< ICache<J314User> > getCacheAreaUserFromId()
	{
		Result< ICache<J314User> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en CacheService.getCacheAreaUserFromId ("+_params_+")");
		Map<String,Object> cache=preConditionsGetCacheAreaUserFromId( res  );
		if(res.isOk())
		{
			try

			{


				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				
				
				                ICacheExt< J314User > obj = null;
				try {
					
					if("N".equalsIgnoreCase(sac.getModeTest()))
					{
						obj = MapCache.getInstance(AreasCache.UserFromId);
					}
					else {
						obj = NullCache.getInstance(AreasCache.UserFromId);
					}
					if(obj.getAutoFind()==null)
					{
						obj.setAutoFind(new com.sine95.tweetsrv.service.ln.impl.cache.UserFromIdAutoFind(appContext));
					}

                	
				}catch(Exception e)
				{
					obj=new NullCache<>();
					res.addError(new ErrorGeneral(e));
				}
				res.setData(obj);

				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				


			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en CacheServiceCRUD.getCacheAreaUserFromId ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de CacheServiceCRUD.getCacheAreaUserFromId ("+UtilParams.paramsToString()+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo getCacheAreaUserFromLogin.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetCacheAreaUserFromLogin(Result< ICache<J314User> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Devuelve la instancia de cache del Area UserFromLogin
	*/




	public Result< ICache<J314User> > getCacheAreaUserFromLogin()
	{
		Result< ICache<J314User> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en CacheService.getCacheAreaUserFromLogin ("+_params_+")");
		Map<String,Object> cache=preConditionsGetCacheAreaUserFromLogin( res  );
		if(res.isOk())
		{
			try

			{


				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				
				
				                ICacheExt< J314User > obj = null;
				try {
					
					if("N".equalsIgnoreCase(sac.getModeTest()))
					{
						obj = MapCache.getInstance(AreasCache.UserFromLogin);
					}
					else {
						obj = NullCache.getInstance(AreasCache.UserFromLogin);
					}
					if(obj.getAutoFind()==null)
					{
						obj.setAutoFind(new com.sine95.tweetsrv.service.ln.impl.cache.UserFromLoginAutoFind(appContext));
					}

                	
				}catch(Exception e)
				{
					obj=new NullCache<>();
					res.addError(new ErrorGeneral(e));
				}
				res.setData(obj);

				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				


			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en CacheServiceCRUD.getCacheAreaUserFromLogin ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de CacheServiceCRUD.getCacheAreaUserFromLogin ("+UtilParams.paramsToString()+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo getCacheAreaCachePrueba.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetCacheAreaCachePrueba(Result< ICache<Long> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Devuelve la instancia de cache del Area CachePrueba
	*/




	public Result< ICache<Long> > getCacheAreaCachePrueba()
	{
		Result< ICache<Long> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en CacheService.getCacheAreaCachePrueba ("+_params_+")");
		Map<String,Object> cache=preConditionsGetCacheAreaCachePrueba( res  );
		if(res.isOk())
		{
			try

			{


				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				
				
				                ICacheExt< Long > obj = null;
				try {
					
					if("N".equalsIgnoreCase(sac.getModeTest()))
					{
						obj = MapCache.getInstance(AreasCache.CachePrueba);
					}
					else {
						obj = NullCache.getInstance(AreasCache.CachePrueba);
					}
					
                	
				}catch(Exception e)
				{
					obj=new NullCache<>();
					res.addError(new ErrorGeneral(e));
				}
				res.setData(obj);

				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				


			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en CacheServiceCRUD.getCacheAreaCachePrueba ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de CacheServiceCRUD.getCacheAreaCachePrueba ("+UtilParams.paramsToString()+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo resetArea.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsResetArea(Result< Vacio > res ,AreasCache area)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:area Tipo:AreasCache 

		if(area==null)
		{
			res.addError(new ErrorParametroObligatorio("area"));
		}


		
		
		return cache;
	}

	/**
	* Vacia la cache del area seleccionada
	*/




	public Result< Vacio > resetArea(AreasCache area)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("area",area);
		if (log.isInfoEnabled()) log.info("Entrando en CacheService.resetArea ("+_params_+")");
		Map<String,Object> cache=preConditionsResetArea( res , area );
		if(res.isOk())
		{
			try

			{


				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				
				
				                IResult<ICache<Object>> data=getArea(area);
				if(data.isOk())
				{
					data.getData().reset();
				}
				else {
					res.setInfoEWI(data);
				}

				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				


			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en CacheServiceCRUD.resetArea ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de CacheServiceCRUD.resetArea ("+UtilParams.paramsToString("area",area)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo getArea.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetArea(Result< ICache<Object> > res ,AreasCache area)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:area Tipo:AreasCache 

		if(area==null)
		{
			res.addError(new ErrorParametroObligatorio("area"));
		}


		
		
		return cache;
	}

	/**
	* Obtener el cache del area indicada
	*/




	public Result< ICache<Object> > getArea(AreasCache area)
	{
		Result< ICache<Object> > res=new Result<>();
		String _params_=UtilParams.paramsToString("area",area);
		if (log.isInfoEnabled()) log.info("Entrando en CacheService.getArea ("+_params_+")");
		Map<String,Object> cache=preConditionsGetArea( res , area );
		if(res.isOk())
		{
			try

			{


				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				
				
				                IResult data = null;
                switch(area)
				{

				case Configuration:
					data = getCacheAreaConfiguration();
					if(data.isOk())
					{
						res.setData((ICache<Object>)data.getData());
					}
					else {
						res.setInfoEWI(data);
					}
					break;

				case Security:
					data = getCacheAreaSecurity();
					if(data.isOk())
					{
						res.setData((ICache<Object>)data.getData());
					}
					else {
						res.setInfoEWI(data);
					}
					break;

				case UserFromId:
					data = getCacheAreaUserFromId();
					if(data.isOk())
					{
						res.setData((ICache<Object>)data.getData());
					}
					else {
						res.setInfoEWI(data);
					}
					break;

				case UserFromLogin:
					data = getCacheAreaUserFromLogin();
					if(data.isOk())
					{
						res.setData((ICache<Object>)data.getData());
					}
					else {
						res.setInfoEWI(data);
					}
					break;

				case CachePrueba:
					data = getCacheAreaCachePrueba();
					if(data.isOk())
					{
						res.setData((ICache<Object>)data.getData());
					}
					else {
						res.setInfoEWI(data);
					}
					break;

				}

				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				


			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en CacheServiceCRUD.getArea ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de CacheServiceCRUD.getArea ("+UtilParams.paramsToString("area",area)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo getAllArea.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetAllArea(Result< Map <String,String> > res ,AreasCache area)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:area Tipo:AreasCache 

		if(area==null)
		{
			res.addError(new ErrorParametroObligatorio("area"));
		}


		
		
		return cache;
	}

	/**
	* Obtener el cache del area indicada
	*/




	public Result< Map <String,String> > getAllArea(AreasCache area)
	{
		Result< Map <String,String> > res=new Result<>();
		String _params_=UtilParams.paramsToString("area",area);
		if (log.isInfoEnabled()) log.info("Entrando en CacheService.getAllArea ("+_params_+")");
		Map<String,Object> cache=preConditionsGetAllArea( res , area );
		if(res.isOk())
		{
			try

			{


				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				
				
				                IResult<ICache<Object>> data = getArea(area);
                Map<String,String> sal=new HashMap<>();
                if(data.isOk())
                {
                	Result<Map<Object,Object>> all = data.getData().getAll();
                	for(Entry<Object, Object> entry:all.getData().entrySet())
                	{
                		sal.put(entry.getKey().toString(),JSON.stringify(entry.getValue()));
                	}
                	res.setData(sal);
                }
                else {
                	res.setInfoEWI(data);
                }


				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				


			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en CacheServiceCRUD.getAllArea ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de CacheServiceCRUD.getAllArea ("+UtilParams.paramsToString("area",area)+"). Result:"+res.toString());


		return res;
	}



//Si hay que annadir metodos se incluyen aqui, se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

