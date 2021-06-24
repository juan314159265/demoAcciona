
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
 * REST controller for managing LogTask.
 */
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class LogTaskRest extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(LogTaskRest.class);

//    private static final String ENTITY_NAME = "logtask";

    private final LogTaskRepository repository;
    private final LogTaskServiceCRUD service;

    public LogTaskRest(LogTaskRepository repository,LogTaskServiceCRUD service) {
        this.repository = repository;
        this.service = service;
    }


//import io.github.jhipster.web.util.ResponseUtil;



	/**
	 * POST  /logtasks : Cear un objeto de tipo LogTask nuevo.
	 *
	 * @param obj el LogTask a crear
	 * @return Un ResponseEntity con estado 201 (Created) y con el cuerpo (body) del nuevo LogTask, o con el estado 400 (Bad Request) si el  LogTask tiene un ID preexistente
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PostMapping("/logtasks")
	@Timed

	@Transactional
	
	public ResultExt< LogTaskPoj> create(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody LogTaskPoj obj)
	{
		
		String params=UtilParams.paramsToString("LogTaskPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_LOGTASK_CREATE");
		ctx.put(Contexto.URL_SOLICITADA,"/logtasks");
		Result< LogTaskPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:create("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_LOGTASK_CREATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_LOGTASK_CREATE","/logtasks"));
			}
			else
			{
				params=UtilParams.paramsToString("LogTaskPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:create("+params+")"+params);

				LogTask obj_ = LogTaskPoj.getModel(obj);

				Result< LogTask > res_=service.insert(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new LogTaskPoj(res_.getData()):null);

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

		ResultExt< LogTaskPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * PUT  /logtasks : Actualiza (Update) un objeto preexistente  (LogTask).
	 *
	 * @param obj El objeto de tipo LogTask a modificar
	 * @return El ResponseEntity con estado 200 (OK) y con el cuerpo (body) actualizado LogTask,
	 * o con estado 400 (Bad Request) si el objeto de tipo LogTask no es valido,
	 * o con estado 500 (Internal Server Error) si el objeto de tipo LogTask no puede ser actualizado
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PutMapping("/logtasks")
	@Timed

	@Transactional
	
	public ResultExt< LogTaskPoj> update(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody LogTaskPoj obj)
	{
		
		String params=UtilParams.paramsToString("LogTaskPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_LOGTASK_UPDATE");
		ctx.put(Contexto.URL_SOLICITADA,"/logtasks");
		Result< LogTaskPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:update("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_LOGTASK_UPDATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_LOGTASK_UPDATE","/logtasks"));
			}
			else
			{
				params=UtilParams.paramsToString("LogTaskPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:update("+params+")"+params);

				LogTask obj_ = LogTaskPoj.getModel(obj);

				Result< LogTask > res_=service.update(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new LogTaskPoj(res_.getData()):null);

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

		ResultExt< LogTaskPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /logtasks : obtener todos los objetos de tipo LogTask.
	 *
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo logtasks en el cuerpo (body)
	 */

	@GetMapping("/logtasks")
	@Timed
	
	public ResultExt< List< LogTaskPoj >> getAll(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_LOGTASK_GETALL");
		ctx.put(Contexto.URL_SOLICITADA,"/logtasks");
		Result< List< LogTaskPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getAll("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_LOGTASK_GETALL"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_LOGTASK_GETALL","/logtasks"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getAll("+params+")"+params);

				Result< List< LogTask > > res_=service.findAll();
				res.setInfoEWI(res_);

				res.setData( LogTaskPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getAll("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getAll("+params+"). Resultado:"+res.toString());

		ResultExt< List< LogTaskPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /logtasks : obtener todos los objetos de tipo LogTask.
	 *
	 * @param pageable informacion de paginacion
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo logtasks en el cuerpo (body)
	 */

	@PostMapping("/logtasks.pag")
	@Timed
	
	public ResultExt< Page< LogTaskPoj >> getAllPag(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody LogTaskCritPaged pag)
	{
		
		String params=UtilParams.paramsToString("LogTaskCritPaged",pag);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_LOGTASK_GETALLPAG");
		ctx.put(Contexto.URL_SOLICITADA,"/logtasks.pag");
		Result< Page< LogTaskPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getAllPag("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_LOGTASK_GETALLPAG"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_LOGTASK_GETALLPAG","/logtasks.pag"));
			}
			else
			{
				params=UtilParams.paramsToString("LogTaskCritPaged",pag);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getAllPag("+params+")"+params);

				LogTaskCritPaged pag_ = pag;

				Result< Page< LogTask > > res_=service.findAll(pag_);
				res.setInfoEWI(res_);

				res.setData(LogTaskPoj.toPOJOPage(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getAllPag("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getAllPag("+params+"). Resultado:"+res.toString());

		ResultExt< Page< LogTaskPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /logtasks/:id : obtiene el objeto con el "id" de tipo LogTask.
	 *
	 * @param id el id del tipo LogTask a devolver
	 * @return la ResponseEntity con estado 200 (OK) con el cuerpo (body) del tipo LogTask, o con estado 404 (Not Found)
	 */

	@GetMapping("/logtasks/{id1}")
	@Timed
	
	public ResultExt< LogTaskPoj> get(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_LOGTASK_GET");
		ctx.put(Contexto.URL_SOLICITADA,"/logtasks/{id1}");
		Result< LogTaskPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:get("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_LOGTASK_GET"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_LOGTASK_GET","/logtasks/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:get("+params+")"+params);

				Long id1_ = id1;

				Result< LogTask > res_=service.findWithResult(id1_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new LogTaskPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:get("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:get("+params+"). Resultado:"+res.toString());

		ResultExt< LogTaskPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /logtasks : devuelve los objetos de tipo logtasks filtrados por el criterio y paginados.
	 *
	 * @param pageable la informacion de paginacion
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo logtasks en el cuerpo (body)
	 */

	@PostMapping("/logtasks.querypaged")
	@Timed

	@Transactional
	
	public ResultExt< Page< LogTaskPoj >> queryCritPaged(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody LogTaskCritPaged param)
	{
		
		String params=UtilParams.paramsToString("LogTaskCritPaged",param);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_LOGTASK_QUERYCRITPAGED");
		ctx.put(Contexto.URL_SOLICITADA,"/logtasks.querypaged");
		Result< Page< LogTaskPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:queryCritPaged("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_LOGTASK_QUERYCRITPAGED"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_LOGTASK_QUERYCRITPAGED","/logtasks.querypaged"));
			}
			else
			{
				params=UtilParams.paramsToString("LogTaskCritPaged",param);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:queryCritPaged("+params+")"+params);

				LogTaskCritPaged param_ = param;

				Result< Page< LogTask > > res_=service.listByCriteriaPaged(param_);
				res.setInfoEWI(res_);

				res.setData(LogTaskPoj.toPOJOPage(res_.getData()));

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

		ResultExt< Page< LogTaskPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /logtasks : devuelve los objetos de tipo logtasks filtrados por el criterio.
	 *
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo logtasks en el cuerpo (body)
	 */

	@PostMapping("/logtasks.query")
	@Timed

	@Transactional
	
	public ResultExt< List< LogTaskPoj >> getCrit2(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody LogTaskCrit criteria)
	{
		
		String params=UtilParams.paramsToString("LogTaskCrit",criteria);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_LOGTASK_GETCRIT2");
		ctx.put(Contexto.URL_SOLICITADA,"/logtasks.query");
		Result< List< LogTaskPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getCrit2("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_LOGTASK_GETCRIT2"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_LOGTASK_GETCRIT2","/logtasks.query"));
			}
			else
			{
				params=UtilParams.paramsToString("LogTaskCrit",criteria);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getCrit2("+params+")"+params);

				LogTaskCrit criteria_ = criteria;

				Result< List< LogTask > > res_=service.listByCriteria(criteria_);
				res.setInfoEWI(res_);

				res.setData( LogTaskPoj.toPOJOList(res_.getData()));

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

		ResultExt< List< LogTaskPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * DELETE  /logtasks/:id : elimina el objeto de id "id" LogTask.
	 *
	 * @param id el id del objeto de tipo LogTask a borrar
	 * @return la ResponseEntity con estado 200 (OK)
	 */

	@DeleteMapping("/logTask/{id1}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> delete(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_LOGTASK_DELETE");
		ctx.put(Contexto.URL_SOLICITADA,"/logTask/{id1}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST DELETE:delete("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_LOGTASK_DELETE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_LOGTASK_DELETE","/logTask/{id1}"));
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

