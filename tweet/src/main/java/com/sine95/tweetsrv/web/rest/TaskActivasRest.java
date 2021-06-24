
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
 * REST controller for managing TaskActivas.
 */
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class TaskActivasRest extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(TaskActivasRest.class);

//    private static final String ENTITY_NAME = "taskactivas";

    private final TaskActivasRepository repository;
    private final TaskActivasServiceCRUD service;

    public TaskActivasRest(TaskActivasRepository repository,TaskActivasServiceCRUD service) {
        this.repository = repository;
        this.service = service;
    }


//import io.github.jhipster.web.util.ResponseUtil;



	/**
	 * POST  /tasksactivas : Cear un objeto de tipo TaskActivas nuevo.
	 *
	 * @param obj el TaskActivas a crear
	 * @return Un ResponseEntity con estado 201 (Created) y con el cuerpo (body) del nuevo TaskActivas, o con el estado 400 (Bad Request) si el  TaskActivas tiene un ID preexistente
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PostMapping("/tasksactivas")
	@Timed

	@Transactional
	
	public ResultExt< TaskActivasPoj> create(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody TaskActivasPoj obj)
	{
		
		String params=UtilParams.paramsToString("TaskActivasPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TASKACTIVAS_CREATE");
		ctx.put(Contexto.URL_SOLICITADA,"/tasksactivas");
		Result< TaskActivasPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:create("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TASKACTIVAS_CREATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TASKACTIVAS_CREATE","/tasksactivas"));
			}
			else
			{
				params=UtilParams.paramsToString("TaskActivasPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:create("+params+")"+params);

				TaskActivas obj_ = TaskActivasPoj.getModel(obj);

				Result< TaskActivas > res_=service.insert(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new TaskActivasPoj(res_.getData()):null);

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

		ResultExt< TaskActivasPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * PUT  /tasksactivas : Actualiza (Update) un objeto preexistente  (TaskActivas).
	 *
	 * @param obj El objeto de tipo TaskActivas a modificar
	 * @return El ResponseEntity con estado 200 (OK) y con el cuerpo (body) actualizado TaskActivas,
	 * o con estado 400 (Bad Request) si el objeto de tipo TaskActivas no es valido,
	 * o con estado 500 (Internal Server Error) si el objeto de tipo TaskActivas no puede ser actualizado
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PutMapping("/tasksactivas")
	@Timed

	@Transactional
	
	public ResultExt< TaskActivasPoj> update(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody TaskActivasPoj obj)
	{
		
		String params=UtilParams.paramsToString("TaskActivasPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TASKACTIVAS_UPDATE");
		ctx.put(Contexto.URL_SOLICITADA,"/tasksactivas");
		Result< TaskActivasPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:update("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TASKACTIVAS_UPDATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TASKACTIVAS_UPDATE","/tasksactivas"));
			}
			else
			{
				params=UtilParams.paramsToString("TaskActivasPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:update("+params+")"+params);

				TaskActivas obj_ = TaskActivasPoj.getModel(obj);

				Result< TaskActivas > res_=service.update(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new TaskActivasPoj(res_.getData()):null);

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

		ResultExt< TaskActivasPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /tasksactivas : obtener todos los objetos de tipo TaskActivas.
	 *
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo tasksactivas en el cuerpo (body)
	 */

	@GetMapping("/tasksactivas")
	@Timed
	
	public ResultExt< List< TaskActivasPoj >> getAll(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TASKACTIVAS_GETALL");
		ctx.put(Contexto.URL_SOLICITADA,"/tasksactivas");
		Result< List< TaskActivasPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getAll("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TASKACTIVAS_GETALL"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TASKACTIVAS_GETALL","/tasksactivas"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getAll("+params+")"+params);

				Result< List< TaskActivas > > res_=service.findAll();
				res.setInfoEWI(res_);

				res.setData( TaskActivasPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getAll("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getAll("+params+"). Resultado:"+res.toString());

		ResultExt< List< TaskActivasPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /tasksactivas : obtener todos los objetos de tipo TaskActivas.
	 *
	 * @param pageable informacion de paginacion
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo tasksactivas en el cuerpo (body)
	 */

	@PostMapping("/tasksactivas.pag")
	@Timed
	
	public ResultExt< Page< TaskActivasPoj >> getAllPag(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody TaskActivasCritPaged pag)
	{
		
		String params=UtilParams.paramsToString("TaskActivasCritPaged",pag);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TASKACTIVAS_GETALLPAG");
		ctx.put(Contexto.URL_SOLICITADA,"/tasksactivas.pag");
		Result< Page< TaskActivasPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getAllPag("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TASKACTIVAS_GETALLPAG"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TASKACTIVAS_GETALLPAG","/tasksactivas.pag"));
			}
			else
			{
				params=UtilParams.paramsToString("TaskActivasCritPaged",pag);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getAllPag("+params+")"+params);

				TaskActivasCritPaged pag_ = pag;

				Result< Page< TaskActivas > > res_=service.findAll(pag_);
				res.setInfoEWI(res_);

				res.setData(TaskActivasPoj.toPOJOPage(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getAllPag("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getAllPag("+params+"). Resultado:"+res.toString());

		ResultExt< Page< TaskActivasPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /tasksactivas/:id : obtiene el objeto con el "id" de tipo TaskActivas.
	 *
	 * @param id el id del tipo TaskActivas a devolver
	 * @return la ResponseEntity con estado 200 (OK) con el cuerpo (body) del tipo TaskActivas, o con estado 404 (Not Found)
	 */

	@GetMapping("/tasksactivas/{id1}")
	@Timed
	
	public ResultExt< TaskActivasPoj> get(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TASKACTIVAS_GET");
		ctx.put(Contexto.URL_SOLICITADA,"/tasksactivas/{id1}");
		Result< TaskActivasPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:get("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TASKACTIVAS_GET"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TASKACTIVAS_GET","/tasksactivas/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:get("+params+")"+params);

				Long id1_ = id1;

				Result< TaskActivas > res_=service.findWithResult(id1_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new TaskActivasPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:get("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:get("+params+"). Resultado:"+res.toString());

		ResultExt< TaskActivasPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /tasksactivas : devuelve los objetos de tipo tasksactivas filtrados por el criterio y paginados.
	 *
	 * @param pageable la informacion de paginacion
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo tasksactivas en el cuerpo (body)
	 */

	@PostMapping("/tasksactivas.querypaged")
	@Timed

	@Transactional
	
	public ResultExt< Page< TaskActivasPoj >> queryCritPaged(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody TaskActivasCritPaged param)
	{
		
		String params=UtilParams.paramsToString("TaskActivasCritPaged",param);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TASKACTIVAS_QUERYCRITPAGED");
		ctx.put(Contexto.URL_SOLICITADA,"/tasksactivas.querypaged");
		Result< Page< TaskActivasPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:queryCritPaged("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TASKACTIVAS_QUERYCRITPAGED"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TASKACTIVAS_QUERYCRITPAGED","/tasksactivas.querypaged"));
			}
			else
			{
				params=UtilParams.paramsToString("TaskActivasCritPaged",param);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:queryCritPaged("+params+")"+params);

				TaskActivasCritPaged param_ = param;

				Result< Page< TaskActivas > > res_=service.listByCriteriaPaged(param_);
				res.setInfoEWI(res_);

				res.setData(TaskActivasPoj.toPOJOPage(res_.getData()));

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

		ResultExt< Page< TaskActivasPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /tasksactivas : devuelve los objetos de tipo tasksactivas filtrados por el criterio.
	 *
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo tasksactivas en el cuerpo (body)
	 */

	@PostMapping("/tasksactivas.query")
	@Timed

	@Transactional
	
	public ResultExt< List< TaskActivasPoj >> getCrit2(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody TaskActivasCrit criteria)
	{
		
		String params=UtilParams.paramsToString("TaskActivasCrit",criteria);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TASKACTIVAS_GETCRIT2");
		ctx.put(Contexto.URL_SOLICITADA,"/tasksactivas.query");
		Result< List< TaskActivasPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getCrit2("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TASKACTIVAS_GETCRIT2"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TASKACTIVAS_GETCRIT2","/tasksactivas.query"));
			}
			else
			{
				params=UtilParams.paramsToString("TaskActivasCrit",criteria);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getCrit2("+params+")"+params);

				TaskActivasCrit criteria_ = criteria;

				Result< List< TaskActivas > > res_=service.listByCriteria(criteria_);
				res.setInfoEWI(res_);

				res.setData( TaskActivasPoj.toPOJOList(res_.getData()));

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

		ResultExt< List< TaskActivasPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * DELETE  /tasksactivas/:id : elimina el objeto de id "id" TaskActivas.
	 *
	 * @param id el id del objeto de tipo TaskActivas a borrar
	 * @return la ResponseEntity con estado 200 (OK)
	 */

	@DeleteMapping("/taskActivas/{id1}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> delete(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TASKACTIVAS_DELETE");
		ctx.put(Contexto.URL_SOLICITADA,"/taskActivas/{id1}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST DELETE:delete("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TASKACTIVAS_DELETE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TASKACTIVAS_DELETE","/taskActivas/{id1}"));
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

