
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
 * REST controller for managing J314Authority.
 */
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class J314AuthorityRest extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(J314AuthorityRest.class);

//    private static final String ENTITY_NAME = "j314authority";

    private final J314AuthorityRepository repository;
    private final J314AuthorityServiceCRUD service;

    public J314AuthorityRest(J314AuthorityRepository repository,J314AuthorityServiceCRUD service) {
        this.repository = repository;
        this.service = service;
    }


//import io.github.jhipster.web.util.ResponseUtil;



	/**
	 * POST  /J314Authorities : Cear un objeto de tipo J314Authority nuevo.
	 *
	 * @param obj el J314Authority a crear
	 * @return Un ResponseEntity con estado 201 (Created) y con el cuerpo (body) del nuevo J314Authority, o con el estado 400 (Bad Request) si el  J314Authority tiene un ID preexistente
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PostMapping("/J314Authorities")
	@Timed

	@Transactional
	
	public ResultExt< J314AuthorityPoj> create(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody J314AuthorityPoj obj)
	{
		
		String params=UtilParams.paramsToString("J314AuthorityPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314AUTHORITY_CREATE");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Authorities");
		Result< J314AuthorityPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:create("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314AUTHORITY_CREATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314AUTHORITY_CREATE","/J314Authorities"));
			}
			else
			{
				params=UtilParams.paramsToString("J314AuthorityPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:create("+params+")"+params);

				J314Authority obj_ = J314AuthorityPoj.getModel(obj);

				Result< J314Authority > res_=service.insert(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314AuthorityPoj(res_.getData()):null);

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

		ResultExt< J314AuthorityPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * PUT  /J314Authorities : Actualiza (Update) un objeto preexistente  (J314Authority).
	 *
	 * @param obj El objeto de tipo J314Authority a modificar
	 * @return El ResponseEntity con estado 200 (OK) y con el cuerpo (body) actualizado J314Authority,
	 * o con estado 400 (Bad Request) si el objeto de tipo J314Authority no es valido,
	 * o con estado 500 (Internal Server Error) si el objeto de tipo J314Authority no puede ser actualizado
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PutMapping("/J314Authorities")
	@Timed

	@Transactional
	
	public ResultExt< J314AuthorityPoj> update(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody J314AuthorityPoj obj)
	{
		
		String params=UtilParams.paramsToString("J314AuthorityPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314AUTHORITY_UPDATE");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Authorities");
		Result< J314AuthorityPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:update("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314AUTHORITY_UPDATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314AUTHORITY_UPDATE","/J314Authorities"));
			}
			else
			{
				params=UtilParams.paramsToString("J314AuthorityPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:update("+params+")"+params);

				J314Authority obj_ = J314AuthorityPoj.getModel(obj);

				Result< J314Authority > res_=service.update(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314AuthorityPoj(res_.getData()):null);

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

		ResultExt< J314AuthorityPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /J314Authorities : obtener todos los objetos de tipo J314Authority.
	 *
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo J314Authorities en el cuerpo (body)
	 */

	@GetMapping("/J314Authorities")
	@Timed
	
	public ResultExt< List< J314AuthorityPoj >> getAll(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314AUTHORITY_GETALL");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Authorities");
		Result< List< J314AuthorityPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getAll("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314AUTHORITY_GETALL"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314AUTHORITY_GETALL","/J314Authorities"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getAll("+params+")"+params);

				Result< List< J314Authority > > res_=service.findAll();
				res.setInfoEWI(res_);

				res.setData( J314AuthorityPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getAll("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getAll("+params+"). Resultado:"+res.toString());

		ResultExt< List< J314AuthorityPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /J314Authorities : obtener todos los objetos de tipo J314Authority.
	 *
	 * @param pageable informacion de paginacion
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo J314Authorities en el cuerpo (body)
	 */

	@PostMapping("/J314Authorities.pag")
	@Timed
	
	public ResultExt< Page< J314AuthorityPoj >> getAllPag(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody J314AuthorityCritPaged pag)
	{
		
		String params=UtilParams.paramsToString("J314AuthorityCritPaged",pag);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314AUTHORITY_GETALLPAG");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Authorities.pag");
		Result< Page< J314AuthorityPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getAllPag("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314AUTHORITY_GETALLPAG"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314AUTHORITY_GETALLPAG","/J314Authorities.pag"));
			}
			else
			{
				params=UtilParams.paramsToString("J314AuthorityCritPaged",pag);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getAllPag("+params+")"+params);

				J314AuthorityCritPaged pag_ = pag;

				Result< Page< J314Authority > > res_=service.findAll(pag_);
				res.setInfoEWI(res_);

				res.setData(J314AuthorityPoj.toPOJOPage(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getAllPag("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getAllPag("+params+"). Resultado:"+res.toString());

		ResultExt< Page< J314AuthorityPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /J314Authorities/:id : obtiene el objeto con el "id" de tipo J314Authority.
	 *
	 * @param id el id del tipo J314Authority a devolver
	 * @return la ResponseEntity con estado 200 (OK) con el cuerpo (body) del tipo J314Authority, o con estado 404 (Not Found)
	 */

	@GetMapping("/J314Authorities/{id1}")
	@Timed
	
	public ResultExt< J314AuthorityPoj> get(HttpServletRequest request,HttpServletResponse response, @PathVariable String id1)
	{
		
		String params=UtilParams.paramsToString("String",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314AUTHORITY_GET");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Authorities/{id1}");
		Result< J314AuthorityPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:get("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314AUTHORITY_GET"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314AUTHORITY_GET","/J314Authorities/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("String",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:get("+params+")"+params);

				String id1_ = id1;

				Result< J314Authority > res_=service.findWithResult(id1_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314AuthorityPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:get("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:get("+params+"). Resultado:"+res.toString());

		ResultExt< J314AuthorityPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /J314Authorities : devuelve los objetos de tipo J314Authorities filtrados por el criterio y paginados.
	 *
	 * @param pageable la informacion de paginacion
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo J314Authorities en el cuerpo (body)
	 */

	@PostMapping("/J314Authorities.querypaged")
	@Timed

	@Transactional
	
	public ResultExt< Page< J314AuthorityPoj >> queryCritPaged(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody J314AuthorityCritPaged param)
	{
		
		String params=UtilParams.paramsToString("J314AuthorityCritPaged",param);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314AUTHORITY_QUERYCRITPAGED");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Authorities.querypaged");
		Result< Page< J314AuthorityPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:queryCritPaged("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314AUTHORITY_QUERYCRITPAGED"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314AUTHORITY_QUERYCRITPAGED","/J314Authorities.querypaged"));
			}
			else
			{
				params=UtilParams.paramsToString("J314AuthorityCritPaged",param);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:queryCritPaged("+params+")"+params);

				J314AuthorityCritPaged param_ = param;

				Result< Page< J314Authority > > res_=service.listByCriteriaPaged(param_);
				res.setInfoEWI(res_);

				res.setData(J314AuthorityPoj.toPOJOPage(res_.getData()));

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

		ResultExt< Page< J314AuthorityPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /J314Authorities : devuelve los objetos de tipo J314Authorities filtrados por el criterio.
	 *
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo J314Authorities en el cuerpo (body)
	 */

	@PostMapping("/J314Authorities.query")
	@Timed

	@Transactional
	
	public ResultExt< List< J314AuthorityPoj >> getCrit2(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody J314AuthorityCrit criteria)
	{
		
		String params=UtilParams.paramsToString("J314AuthorityCrit",criteria);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314AUTHORITY_GETCRIT2");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Authorities.query");
		Result< List< J314AuthorityPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getCrit2("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314AUTHORITY_GETCRIT2"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314AUTHORITY_GETCRIT2","/J314Authorities.query"));
			}
			else
			{
				params=UtilParams.paramsToString("J314AuthorityCrit",criteria);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getCrit2("+params+")"+params);

				J314AuthorityCrit criteria_ = criteria;

				Result< List< J314Authority > > res_=service.listByCriteria(criteria_);
				res.setInfoEWI(res_);

				res.setData( J314AuthorityPoj.toPOJOList(res_.getData()));

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

		ResultExt< List< J314AuthorityPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * DELETE  /J314Authorities/:id : elimina el objeto de id "id" J314Authority.
	 *
	 * @param id el id del objeto de tipo J314Authority a borrar
	 * @return la ResponseEntity con estado 200 (OK)
	 */

	@DeleteMapping("/j314Authority/{id1}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> delete(HttpServletRequest request,HttpServletResponse response, @PathVariable String id1)
	{
		
		String params=UtilParams.paramsToString("String",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314AUTHORITY_DELETE");
		ctx.put(Contexto.URL_SOLICITADA,"/j314Authority/{id1}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST DELETE:delete("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314AUTHORITY_DELETE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314AUTHORITY_DELETE","/j314Authority/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("String",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST DELETE:delete("+params+")"+params);

				String id1_ = id1;

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

// Campo de relacion. Nombre: users; Tipo: MAN; Navegacion: N; Entidad remota: J314User

	@GetMapping("/J314Authorities.listusers/{id1}")
	@Timed
	
	public ResultExt< List< J314UserAuthorityPoj >> getListUsers(HttpServletRequest request,HttpServletResponse response, @PathVariable String id1)
	{
		
		String params=UtilParams.paramsToString("String",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314AUTHORITY_GETLISTUSERS");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Authorities.listusers/{id1}");
		Result< List< J314UserAuthorityPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getListUsers("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314AUTHORITY_GETLISTUSERS"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314AUTHORITY_GETLISTUSERS","/J314Authorities.listusers/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("String",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getListUsers("+params+")"+params);

				String id1_ = id1;

				Result< List< J314UserAuthority > > res_=service.getListUsers(id1_);
				res.setInfoEWI(res_);

				res.setData( J314UserAuthorityPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getListUsers("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getListUsers("+params+"). Resultado:"+res.toString());

		ResultExt< List< J314UserAuthorityPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@GetMapping("/J314Authorities.jsonrelusers/{id1}")
	@Timed
	
	public ResultExt< List< RelJ314UserAuthorityPoj >> getJsonRelUsers(HttpServletRequest request,HttpServletResponse response, @PathVariable String id1)
	{
		
		String params=UtilParams.paramsToString("String",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314AUTHORITY_GETJSONRELUSERS");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Authorities.jsonrelusers/{id1}");
		Result< List< RelJ314UserAuthorityPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getJsonRelUsers("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314AUTHORITY_GETJSONRELUSERS"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314AUTHORITY_GETJSONRELUSERS","/J314Authorities.jsonrelusers/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("String",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getJsonRelUsers("+params+")"+params);

				String id1_ = id1;

				Result< List< RelJ314UserAuthority > > res_=service.getListRelUsers(id1_);
				res.setInfoEWI(res_);

				res.setData( RelJ314UserAuthorityPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getJsonRelUsers("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getJsonRelUsers("+params+"). Resultado:"+res.toString());

		ResultExt< List< RelJ314UserAuthorityPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



// HASTA AQUI Campo de relacion. Nombre users; Tipo: MAN; Navegacion: N; Entidad remota: J314UserAuthority

// FIN de metodos para gestionar las relaciones
// LN de CRUD

// FIN LN de CRUD




//Si hay que anadir metodos se incluyen aqui,
// se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

