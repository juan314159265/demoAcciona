
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
 * REST controller for managing J314User.
 */
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class J314UserRest extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(J314UserRest.class);

//    private static final String ENTITY_NAME = "j314user";

    private final J314UserRepository repository;
    private final J314UserServiceCRUD service;

    public J314UserRest(J314UserRepository repository,J314UserServiceCRUD service) {
        this.repository = repository;
        this.service = service;
    }


//import io.github.jhipster.web.util.ResponseUtil;



	/**
	 * POST  /J314Users : Cear un objeto de tipo J314User nuevo.
	 *
	 * @param obj el J314User a crear
	 * @return Un ResponseEntity con estado 201 (Created) y con el cuerpo (body) del nuevo J314User, o con el estado 400 (Bad Request) si el  J314User tiene un ID preexistente
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PostMapping("/J314Users")
	@Timed

	@Transactional
	
	public ResultExt< J314UserPoj> create(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody J314UserPoj obj)
	{
		
		String params=UtilParams.paramsToString("J314UserPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_CREATE");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users");
		Result< J314UserPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:create("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_CREATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_CREATE","/J314Users"));
			}
			else
			{
				params=UtilParams.paramsToString("J314UserPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:create("+params+")"+params);

				J314User obj_ = J314UserPoj.getModel(obj);

				Result< J314User > res_=service.insert(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314UserPoj(res_.getData()):null);

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

		ResultExt< J314UserPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * PUT  /J314Users : Actualiza (Update) un objeto preexistente  (J314User).
	 *
	 * @param obj El objeto de tipo J314User a modificar
	 * @return El ResponseEntity con estado 200 (OK) y con el cuerpo (body) actualizado J314User,
	 * o con estado 400 (Bad Request) si el objeto de tipo J314User no es valido,
	 * o con estado 500 (Internal Server Error) si el objeto de tipo J314User no puede ser actualizado
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PutMapping("/J314Users")
	@Timed

	@Transactional
	
	public ResultExt< J314UserPoj> update(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody J314UserPoj obj)
	{
		
		String params=UtilParams.paramsToString("J314UserPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_UPDATE");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users");
		Result< J314UserPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:update("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_UPDATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_UPDATE","/J314Users"));
			}
			else
			{
				params=UtilParams.paramsToString("J314UserPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:update("+params+")"+params);

				J314User obj_ = J314UserPoj.getModel(obj);

				Result< J314User > res_=service.update(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314UserPoj(res_.getData()):null);

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

		ResultExt< J314UserPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /J314Users : obtener todos los objetos de tipo J314User.
	 *
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo J314Users en el cuerpo (body)
	 */

	@GetMapping("/J314Users")
	@Timed
	
	public ResultExt< List< J314UserPoj >> getAll(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_GETALL");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users");
		Result< List< J314UserPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getAll("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_GETALL"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_GETALL","/J314Users"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getAll("+params+")"+params);

				Result< List< J314User > > res_=service.findAll();
				res.setInfoEWI(res_);

				res.setData( J314UserPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getAll("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getAll("+params+"). Resultado:"+res.toString());

		ResultExt< List< J314UserPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /J314Users : obtener todos los objetos de tipo J314User.
	 *
	 * @param pageable informacion de paginacion
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo J314Users en el cuerpo (body)
	 */

	@PostMapping("/J314Users.pag")
	@Timed
	
	public ResultExt< Page< J314UserPoj >> getAllPag(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody J314UserCritPaged pag)
	{
		
		String params=UtilParams.paramsToString("J314UserCritPaged",pag);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_GETALLPAG");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users.pag");
		Result< Page< J314UserPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getAllPag("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_GETALLPAG"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_GETALLPAG","/J314Users.pag"));
			}
			else
			{
				params=UtilParams.paramsToString("J314UserCritPaged",pag);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getAllPag("+params+")"+params);

				J314UserCritPaged pag_ = pag;

				Result< Page< J314User > > res_=service.findAll(pag_);
				res.setInfoEWI(res_);

				res.setData(J314UserPoj.toPOJOPage(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getAllPag("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getAllPag("+params+"). Resultado:"+res.toString());

		ResultExt< Page< J314UserPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /J314Users/:id : obtiene el objeto con el "id" de tipo J314User.
	 *
	 * @param id el id del tipo J314User a devolver
	 * @return la ResponseEntity con estado 200 (OK) con el cuerpo (body) del tipo J314User, o con estado 404 (Not Found)
	 */

	@GetMapping("/J314Users/{id1}")
	@Timed
	
	public ResultExt< J314UserPoj> get(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_GET");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users/{id1}");
		Result< J314UserPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:get("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_GET"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_GET","/J314Users/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:get("+params+")"+params);

				Long id1_ = id1;

				Result< J314User > res_=service.findWithResult(id1_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314UserPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:get("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:get("+params+"). Resultado:"+res.toString());

		ResultExt< J314UserPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /J314Users : devuelve los objetos de tipo J314Users filtrados por el criterio y paginados.
	 *
	 * @param pageable la informacion de paginacion
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo J314Users en el cuerpo (body)
	 */

	@PostMapping("/J314Users.querypaged")
	@Timed

	@Transactional
	
	public ResultExt< Page< J314UserPoj >> queryCritPaged(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody J314UserCritPaged param)
	{
		
		String params=UtilParams.paramsToString("J314UserCritPaged",param);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_QUERYCRITPAGED");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users.querypaged");
		Result< Page< J314UserPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:queryCritPaged("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_QUERYCRITPAGED"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_QUERYCRITPAGED","/J314Users.querypaged"));
			}
			else
			{
				params=UtilParams.paramsToString("J314UserCritPaged",param);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:queryCritPaged("+params+")"+params);

				J314UserCritPaged param_ = param;

				Result< Page< J314User > > res_=service.listByCriteriaPaged(param_);
				res.setInfoEWI(res_);

				res.setData(J314UserPoj.toPOJOPage(res_.getData()));

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

		ResultExt< Page< J314UserPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /J314Users : devuelve los objetos de tipo J314Users filtrados por el criterio.
	 *
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo J314Users en el cuerpo (body)
	 */

	@PostMapping("/J314Users.query")
	@Timed

	@Transactional
	
	public ResultExt< List< J314UserPoj >> getCrit2(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody J314UserCrit criteria)
	{
		
		String params=UtilParams.paramsToString("J314UserCrit",criteria);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_GETCRIT2");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users.query");
		Result< List< J314UserPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getCrit2("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_GETCRIT2"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_GETCRIT2","/J314Users.query"));
			}
			else
			{
				params=UtilParams.paramsToString("J314UserCrit",criteria);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getCrit2("+params+")"+params);

				J314UserCrit criteria_ = criteria;

				Result< List< J314User > > res_=service.listByCriteria(criteria_);
				res.setInfoEWI(res_);

				res.setData( J314UserPoj.toPOJOList(res_.getData()));

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

		ResultExt< List< J314UserPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * DELETE  /J314Users/:id : elimina el objeto de id "id" J314User.
	 *
	 * @param id el id del objeto de tipo J314User a borrar
	 * @return la ResponseEntity con estado 200 (OK)
	 */

	@DeleteMapping("/j314User/{id1}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> delete(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_DELETE");
		ctx.put(Contexto.URL_SOLICITADA,"/j314User/{id1}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST DELETE:delete("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_DELETE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_DELETE","/j314User/{id1}"));
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

// Campo de relacion. Nombre: authorities; Tipo: MAN; Navegacion: M; Entidad remota: J314Authority

	@GetMapping("/J314Users.listauthorities/{id1}")
	@Timed
	
	public ResultExt< List< J314UserAuthorityPoj >> getListAuthorities(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_GETLISTAUTHORITIES");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users.listauthorities/{id1}");
		Result< List< J314UserAuthorityPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getListAuthorities("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_GETLISTAUTHORITIES"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_GETLISTAUTHORITIES","/J314Users.listauthorities/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getListAuthorities("+params+")"+params);

				Long id1_ = id1;

				Result< List< J314UserAuthority > > res_=service.getListAuthorities(id1_);
				res.setInfoEWI(res_);

				res.setData( J314UserAuthorityPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getListAuthorities("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getListAuthorities("+params+"). Resultado:"+res.toString());

		ResultExt< List< J314UserAuthorityPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@GetMapping("/J314Users.jsonrelauthorities/{id1}")
	@Timed
	
	public ResultExt< List< RelJ314UserAuthorityPoj >> getJsonRelAuthorities(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_GETJSONRELAUTHORITIES");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users.jsonrelauthorities/{id1}");
		Result< List< RelJ314UserAuthorityPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getJsonRelAuthorities("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_GETJSONRELAUTHORITIES"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_GETJSONRELAUTHORITIES","/J314Users.jsonrelauthorities/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getJsonRelAuthorities("+params+")"+params);

				Long id1_ = id1;

				Result< List< RelJ314UserAuthority > > res_=service.getListRelAuthorities(id1_);
				res.setInfoEWI(res_);

				res.setData( RelJ314UserAuthorityPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getJsonRelAuthorities("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getJsonRelAuthorities("+params+"). Resultado:"+res.toString());

		ResultExt< List< RelJ314UserAuthorityPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/J314Users.addauthority/{id1}")
	@Timed

	@Transactional
	
	public ResultExt< J314UserPoj> addAuthority(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1, @Valid @RequestBody J314AuthorityPoj obj)
	{
		
		String params=UtilParams.paramsToString("Long",id1, "J314AuthorityPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_ADDAUTHORITY");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users.addauthority/{id1}");
		Result< J314UserPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:addAuthority("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_ADDAUTHORITY"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_ADDAUTHORITY","/J314Users.addauthority/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1, "J314AuthorityPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:addAuthority("+params+")"+params);

				Long id1_ = id1;

				J314Authority obj_ = J314AuthorityPoj.getModel(obj);

				Result< J314User > res_=service.addAuthority(id1_, obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314UserPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:addAuthority("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:addAuthority("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST PUT:addAuthority("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< J314UserPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/J314Users.removeauthority/{id1}")
	@Timed

	@Transactional
	
	public ResultExt< J314UserPoj> removeAuthority(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1, @Valid @RequestBody J314AuthorityPoj obj)
	{
		
		String params=UtilParams.paramsToString("Long",id1, "J314AuthorityPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USER_REMOVEAUTHORITY");
		ctx.put(Contexto.URL_SOLICITADA,"/J314Users.removeauthority/{id1}");
		Result< J314UserPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:removeAuthority("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USER_REMOVEAUTHORITY"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USER_REMOVEAUTHORITY","/J314Users.removeauthority/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1, "J314AuthorityPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:removeAuthority("+params+")"+params);

				Long id1_ = id1;

				J314Authority obj_ = J314AuthorityPoj.getModel(obj);

				Result< J314User > res_=service.removeAuthority(id1_, obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314UserPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:removeAuthority("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:removeAuthority("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST PUT:removeAuthority("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< J314UserPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



// HASTA AQUI Campo de relacion. Nombre authorities; Tipo: MAN; Navegacion: M; Entidad remota: J314UserAuthority

// FIN de metodos para gestionar las relaciones
// LN de CRUD

// FIN LN de CRUD




//Si hay que anadir metodos se incluyen aqui,
// se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

