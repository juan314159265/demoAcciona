
package com.sine95.tweetsrv.web.rest;

import com.sine95.tweetsrv.domain.*;
import com.sine95.tweetsrv.repository.*;
import com.sine95.tweetsrv.service.crud.*;
import java.net.URISyntaxException;
import java.util.*;
import javax.validation.Valid;
import javax.transaction.Transactional;

import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.ResultExt;
import org.sine95.kernel.base.Contexto;

import org.sine95.kernel.base.web.rest.ControllerBase;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.sine95.tweetsrv.errores.ErrorGeneral;
import com.sine95.tweetsrv.errores.ErrorSinPermiso;
import com.codahale.metrics.annotation.Timed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing Configuration.
 */
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class ConfigurationRest extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(ConfigurationRest.class);

//    private static final String ENTITY_NAME = "configuration";

    private final ConfigurationRepository repository;
    private final ConfigurationServiceCRUD service;

    public ConfigurationRest(ConfigurationRepository repository,ConfigurationServiceCRUD service) {
        this.repository = repository;
        this.service = service;
    }


//import io.github.jhipster.web.util.ResponseUtil;



	/**
	 * POST  /configurations : Cear un objeto de tipo Configuration nuevo.
	 *
	 * @param obj el Configuration a crear
	 * @return Un ResponseEntity con estado 201 (Created) y con el cuerpo (body) del nuevo Configuration, o con el estado 400 (Bad Request) si el  Configuration tiene un ID preexistente
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PostMapping("/configurations")
	@Timed

	@Transactional
	
	public ResultExt< ConfigurationPoj> create(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody ConfigurationPoj obj)
	{
		
		String params=UtilParams.paramsToString("ConfigurationPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_CONFIGURATION_CREATE");
		ctx.put(Contexto.URL_SOLICITADA,"/configurations");
		Result< ConfigurationPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:create("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_CONFIGURATION_CREATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_CONFIGURATION_CREATE","/configurations"));
			}
			else
			{
				params=UtilParams.paramsToString("ConfigurationPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:create("+params+")"+params);

				Configuration obj_ = ConfigurationPoj.getModel(obj);

				Result< Configuration > res_=service.insert(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new ConfigurationPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:create("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:create("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:create("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< ConfigurationPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * PUT  /configurations : Actualiza (Update) un objeto preexistente  (Configuration).
	 *
	 * @param obj El objeto de tipo Configuration a modificar
	 * @return El ResponseEntity con estado 200 (OK) y con el cuerpo (body) actualizado Configuration,
	 * o con estado 400 (Bad Request) si el objeto de tipo Configuration no es valido,
	 * o con estado 500 (Internal Server Error) si el objeto de tipo Configuration no puede ser actualizado
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PutMapping("/configurations")
	@Timed

	@Transactional
	
	public ResultExt< ConfigurationPoj> update(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody ConfigurationPoj obj)
	{
		
		String params=UtilParams.paramsToString("ConfigurationPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_CONFIGURATION_UPDATE");
		ctx.put(Contexto.URL_SOLICITADA,"/configurations");
		Result< ConfigurationPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:update("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_CONFIGURATION_UPDATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_CONFIGURATION_UPDATE","/configurations"));
			}
			else
			{
				params=UtilParams.paramsToString("ConfigurationPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:update("+params+")"+params);

				Configuration obj_ = ConfigurationPoj.getModel(obj);

				Result< Configuration > res_=service.update(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new ConfigurationPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:update("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:update("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST PUT:update("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< ConfigurationPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /configurations : obtener todos los objetos de tipo Configuration.
	 *
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo configurations en el cuerpo (body)
	 */

	@GetMapping("/configurations")
	@Timed
	
	public ResultExt< List< ConfigurationPoj >> getAll(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_CONFIGURATION_GETALL");
		ctx.put(Contexto.URL_SOLICITADA,"/configurations");
		Result< List< ConfigurationPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getAll("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_CONFIGURATION_GETALL"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_CONFIGURATION_GETALL","/configurations"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getAll("+params+")"+params);

				Result< List< Configuration > > res_=service.findAll();
				res.setInfoEWI(res_);

				res.setData( ConfigurationPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getAll("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getAll("+params+"). Resultado:"+res.toString());

		ResultExt< List< ConfigurationPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /configurations : obtener todos los objetos de tipo Configuration.
	 *
	 * @param pageable informacion de paginacion
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo configurations en el cuerpo (body)
	 */

	@PostMapping("/configurations.pag")
	@Timed
	
	public ResultExt< Page< ConfigurationPoj >> getAllPag(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody ConfigurationCritPaged pag)
	{
		
		String params=UtilParams.paramsToString("ConfigurationCritPaged",pag);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_CONFIGURATION_GETALLPAG");
		ctx.put(Contexto.URL_SOLICITADA,"/configurations.pag");
		Result< Page< ConfigurationPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getAllPag("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_CONFIGURATION_GETALLPAG"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_CONFIGURATION_GETALLPAG","/configurations.pag"));
			}
			else
			{
				params=UtilParams.paramsToString("ConfigurationCritPaged",pag);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getAllPag("+params+")"+params);

				ConfigurationCritPaged pag_ = pag;

				Result< Page< Configuration > > res_=service.findAll(pag_);
				res.setInfoEWI(res_);

				res.setData(ConfigurationPoj.toPOJOPage(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getAllPag("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getAllPag("+params+"). Resultado:"+res.toString());

		ResultExt< Page< ConfigurationPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /configurations/:id : obtiene el objeto con el "id" de tipo Configuration.
	 *
	 * @param id el id del tipo Configuration a devolver
	 * @return la ResponseEntity con estado 200 (OK) con el cuerpo (body) del tipo Configuration, o con estado 404 (Not Found)
	 */

	@GetMapping("/configurations/{id1}")
	@Timed
	
	public ResultExt< ConfigurationPoj> get(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_CONFIGURATION_GET");
		ctx.put(Contexto.URL_SOLICITADA,"/configurations/{id1}");
		Result< ConfigurationPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:get("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_CONFIGURATION_GET"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_CONFIGURATION_GET","/configurations/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:get("+params+")"+params);

				Long id1_ = id1;

				Result< Configuration > res_=service.findWithResult(id1_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new ConfigurationPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:get("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:get("+params+"). Resultado:"+res.toString());

		ResultExt< ConfigurationPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /configurations : devuelve los objetos de tipo configurations filtrados por el criterio y paginados.
	 *
	 * @param pageable la informacion de paginacion
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo configurations en el cuerpo (body)
	 */

	@PostMapping("/configurations.querypaged")
	@Timed

	@Transactional
	
	public ResultExt< Page< ConfigurationPoj >> queryCritPaged(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody ConfigurationCritPaged param)
	{
		
		String params=UtilParams.paramsToString("ConfigurationCritPaged",param);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_CONFIGURATION_QUERYCRITPAGED");
		ctx.put(Contexto.URL_SOLICITADA,"/configurations.querypaged");
		Result< Page< ConfigurationPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:queryCritPaged("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_CONFIGURATION_QUERYCRITPAGED"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_CONFIGURATION_QUERYCRITPAGED","/configurations.querypaged"));
			}
			else
			{
				params=UtilParams.paramsToString("ConfigurationCritPaged",param);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:queryCritPaged("+params+")"+params);

				ConfigurationCritPaged param_ = param;

				Result< Page< Configuration > > res_=service.listByCriteriaPaged(param_);
				res.setInfoEWI(res_);

				res.setData(ConfigurationPoj.toPOJOPage(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:queryCritPaged("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:queryCritPaged("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:queryCritPaged("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Page< ConfigurationPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /configurations : devuelve los objetos de tipo configurations filtrados por el criterio.
	 *
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo configurations en el cuerpo (body)
	 */

	@PostMapping("/configurations.query")
	@Timed

	@Transactional
	
	public ResultExt< List< ConfigurationPoj >> getCrit2(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody ConfigurationCrit criteria)
	{
		
		String params=UtilParams.paramsToString("ConfigurationCrit",criteria);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_CONFIGURATION_GETCRIT2");
		ctx.put(Contexto.URL_SOLICITADA,"/configurations.query");
		Result< List< ConfigurationPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getCrit2("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_CONFIGURATION_GETCRIT2"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_CONFIGURATION_GETCRIT2","/configurations.query"));
			}
			else
			{
				params=UtilParams.paramsToString("ConfigurationCrit",criteria);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getCrit2("+params+")"+params);

				ConfigurationCrit criteria_ = criteria;

				Result< List< Configuration > > res_=service.listByCriteria(criteria_);
				res.setInfoEWI(res_);

				res.setData( ConfigurationPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getCrit2("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getCrit2("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:getCrit2("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< List< ConfigurationPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * DELETE  /configurations/:id : elimina el objeto de id "id" Configuration.
	 *
	 * @param id el id del objeto de tipo Configuration a borrar
	 * @return la ResponseEntity con estado 200 (OK)
	 */

	@DeleteMapping("/configuration/{id1}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> delete(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_CONFIGURATION_DELETE");
		ctx.put(Contexto.URL_SOLICITADA,"/configuration/{id1}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST DELETE:delete("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_CONFIGURATION_DELETE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_CONFIGURATION_DELETE","/configuration/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST DELETE:delete("+params+")"+params);

				Long id1_ = id1;

				Result< Vacio > res_=service.delete(id1_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST DELETE:delete("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST DELETE:delete("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST DELETE:delete("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



// Metodos para gestionar las relaciones

// FIN de metodos para gestionar las relaciones
// LN de CRUD

// FIN LN de CRUD




//Si hay que anadir metodos se incluyen aqui,
// se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

