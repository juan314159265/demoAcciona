
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
 * REST controller for managing SecurityGroup.
 */
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class SecurityGroupRest extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(SecurityGroupRest.class);

//    private static final String ENTITY_NAME = "securitygroup";

    private final SecurityGroupRepository repository;
    private final SecurityGroupServiceCRUD service;

    public SecurityGroupRest(SecurityGroupRepository repository,SecurityGroupServiceCRUD service) {
        this.repository = repository;
        this.service = service;
    }


//import io.github.jhipster.web.util.ResponseUtil;



	/**
	 * POST  /securitygroups : Cear un objeto de tipo SecurityGroup nuevo.
	 *
	 * @param obj el SecurityGroup a crear
	 * @return Un ResponseEntity con estado 201 (Created) y con el cuerpo (body) del nuevo SecurityGroup, o con el estado 400 (Bad Request) si el  SecurityGroup tiene un ID preexistente
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PostMapping("/securitygroups")
	@Timed

	@Transactional
	
	public ResultExt< SecurityGroupPoj> create(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody SecurityGroupPoj obj)
	{
		
		String params=UtilParams.paramsToString("SecurityGroupPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_SECURITYGROUP_CREATE");
		ctx.put(Contexto.URL_SOLICITADA,"/securitygroups");
		Result< SecurityGroupPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:create("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_SECURITYGROUP_CREATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_SECURITYGROUP_CREATE","/securitygroups"));
			}
			else
			{
				params=UtilParams.paramsToString("SecurityGroupPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:create("+params+")"+params);

				SecurityGroup obj_ = SecurityGroupPoj.getModel(obj);

				Result< SecurityGroup > res_=service.insert(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new SecurityGroupPoj(res_.getData()):null);

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

		ResultExt< SecurityGroupPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * PUT  /securitygroups : Actualiza (Update) un objeto preexistente  (SecurityGroup).
	 *
	 * @param obj El objeto de tipo SecurityGroup a modificar
	 * @return El ResponseEntity con estado 200 (OK) y con el cuerpo (body) actualizado SecurityGroup,
	 * o con estado 400 (Bad Request) si el objeto de tipo SecurityGroup no es valido,
	 * o con estado 500 (Internal Server Error) si el objeto de tipo SecurityGroup no puede ser actualizado
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PutMapping("/securitygroups")
	@Timed

	@Transactional
	
	public ResultExt< SecurityGroupPoj> update(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody SecurityGroupPoj obj)
	{
		
		String params=UtilParams.paramsToString("SecurityGroupPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_SECURITYGROUP_UPDATE");
		ctx.put(Contexto.URL_SOLICITADA,"/securitygroups");
		Result< SecurityGroupPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:update("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_SECURITYGROUP_UPDATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_SECURITYGROUP_UPDATE","/securitygroups"));
			}
			else
			{
				params=UtilParams.paramsToString("SecurityGroupPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:update("+params+")"+params);

				SecurityGroup obj_ = SecurityGroupPoj.getModel(obj);

				Result< SecurityGroup > res_=service.update(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new SecurityGroupPoj(res_.getData()):null);

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

		ResultExt< SecurityGroupPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /securitygroups : obtener todos los objetos de tipo SecurityGroup.
	 *
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo securitygroups en el cuerpo (body)
	 */

	@GetMapping("/securitygroups")
	@Timed
	
	public ResultExt< List< SecurityGroupPoj >> getAll(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_SECURITYGROUP_GETALL");
		ctx.put(Contexto.URL_SOLICITADA,"/securitygroups");
		Result< List< SecurityGroupPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getAll("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_SECURITYGROUP_GETALL"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_SECURITYGROUP_GETALL","/securitygroups"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getAll("+params+")"+params);

				Result< List< SecurityGroup > > res_=service.findAll();
				res.setInfoEWI(res_);

				res.setData( SecurityGroupPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getAll("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getAll("+params+"). Resultado:"+res.toString());

		ResultExt< List< SecurityGroupPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /securitygroups : obtener todos los objetos de tipo SecurityGroup.
	 *
	 * @param pageable informacion de paginacion
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo securitygroups en el cuerpo (body)
	 */

	@PostMapping("/securitygroups.pag")
	@Timed
	
	public ResultExt< Page< SecurityGroupPoj >> getAllPag(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody SecurityGroupCritPaged pag)
	{
		
		String params=UtilParams.paramsToString("SecurityGroupCritPaged",pag);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_SECURITYGROUP_GETALLPAG");
		ctx.put(Contexto.URL_SOLICITADA,"/securitygroups.pag");
		Result< Page< SecurityGroupPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getAllPag("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_SECURITYGROUP_GETALLPAG"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_SECURITYGROUP_GETALLPAG","/securitygroups.pag"));
			}
			else
			{
				params=UtilParams.paramsToString("SecurityGroupCritPaged",pag);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getAllPag("+params+")"+params);

				SecurityGroupCritPaged pag_ = pag;

				Result< Page< SecurityGroup > > res_=service.findAll(pag_);
				res.setInfoEWI(res_);

				res.setData(SecurityGroupPoj.toPOJOPage(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getAllPag("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getAllPag("+params+"). Resultado:"+res.toString());

		ResultExt< Page< SecurityGroupPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /securitygroups/:id : obtiene el objeto con el "id" de tipo SecurityGroup.
	 *
	 * @param id el id del tipo SecurityGroup a devolver
	 * @return la ResponseEntity con estado 200 (OK) con el cuerpo (body) del tipo SecurityGroup, o con estado 404 (Not Found)
	 */

	@GetMapping("/securitygroups/{id1}")
	@Timed
	
	public ResultExt< SecurityGroupPoj> get(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_SECURITYGROUP_GET");
		ctx.put(Contexto.URL_SOLICITADA,"/securitygroups/{id1}");
		Result< SecurityGroupPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:get("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_SECURITYGROUP_GET"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_SECURITYGROUP_GET","/securitygroups/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:get("+params+")"+params);

				Long id1_ = id1;

				Result< SecurityGroup > res_=service.findWithResult(id1_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new SecurityGroupPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:get("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:get("+params+"). Resultado:"+res.toString());

		ResultExt< SecurityGroupPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /securitygroups : devuelve los objetos de tipo securitygroups filtrados por el criterio y paginados.
	 *
	 * @param pageable la informacion de paginacion
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo securitygroups en el cuerpo (body)
	 */

	@PostMapping("/securitygroups.querypaged")
	@Timed

	@Transactional
	
	public ResultExt< Page< SecurityGroupPoj >> queryCritPaged(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody SecurityGroupCritPaged param)
	{
		
		String params=UtilParams.paramsToString("SecurityGroupCritPaged",param);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_SECURITYGROUP_QUERYCRITPAGED");
		ctx.put(Contexto.URL_SOLICITADA,"/securitygroups.querypaged");
		Result< Page< SecurityGroupPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:queryCritPaged("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_SECURITYGROUP_QUERYCRITPAGED"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_SECURITYGROUP_QUERYCRITPAGED","/securitygroups.querypaged"));
			}
			else
			{
				params=UtilParams.paramsToString("SecurityGroupCritPaged",param);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:queryCritPaged("+params+")"+params);

				SecurityGroupCritPaged param_ = param;

				Result< Page< SecurityGroup > > res_=service.listByCriteriaPaged(param_);
				res.setInfoEWI(res_);

				res.setData(SecurityGroupPoj.toPOJOPage(res_.getData()));

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

		ResultExt< Page< SecurityGroupPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /securitygroups : devuelve los objetos de tipo securitygroups filtrados por el criterio.
	 *
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo securitygroups en el cuerpo (body)
	 */

	@PostMapping("/securitygroups.query")
	@Timed

	@Transactional
	
	public ResultExt< List< SecurityGroupPoj >> getCrit2(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody SecurityGroupCrit criteria)
	{
		
		String params=UtilParams.paramsToString("SecurityGroupCrit",criteria);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_SECURITYGROUP_GETCRIT2");
		ctx.put(Contexto.URL_SOLICITADA,"/securitygroups.query");
		Result< List< SecurityGroupPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getCrit2("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_SECURITYGROUP_GETCRIT2"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_SECURITYGROUP_GETCRIT2","/securitygroups.query"));
			}
			else
			{
				params=UtilParams.paramsToString("SecurityGroupCrit",criteria);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getCrit2("+params+")"+params);

				SecurityGroupCrit criteria_ = criteria;

				Result< List< SecurityGroup > > res_=service.listByCriteria(criteria_);
				res.setInfoEWI(res_);

				res.setData( SecurityGroupPoj.toPOJOList(res_.getData()));

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

		ResultExt< List< SecurityGroupPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * DELETE  /securitygroups/:id : elimina el objeto de id "id" SecurityGroup.
	 *
	 * @param id el id del objeto de tipo SecurityGroup a borrar
	 * @return la ResponseEntity con estado 200 (OK)
	 */

	@DeleteMapping("/securityGroup/{id1}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> delete(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_SECURITYGROUP_DELETE");
		ctx.put(Contexto.URL_SOLICITADA,"/securityGroup/{id1}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST DELETE:delete("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_SECURITYGROUP_DELETE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_SECURITYGROUP_DELETE","/securityGroup/{id1}"));
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

	@PostMapping("/securitygroup.findAllAutorized")
	@Timed

	@Transactional
	
	public ResultExt< Set< String >> findAllAutorized(HttpServletRequest request,HttpServletResponse response,  List< String > authorities)
	{
		
		String params=UtilParams.paramsToString("List< String >",authorities);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYGROUP_findAllAutorized");
		ctx.put(Contexto.URL_SOLICITADA,"/securitygroup.findAllAutorized");
		Result< Set< String >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:findAllAutorized("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYGROUP_findAllAutorized"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYGROUP_findAllAutorized","/securitygroup.findAllAutorized"));
			}
			else
			{
				params=UtilParams.paramsToString("List< String >",authorities);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:findAllAutorized("+params+")"+params);

				List< String > authorities_ = authorities;

				Result< Set< String > > res_=service.findAllAutorized(authorities_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:findAllAutorized("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:findAllAutorized("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:findAllAutorized("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Set< String > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/securitygroup.findAllRestAuthorized")
	@Timed

	@Transactional
	
	public ResultExt< Map< String,Set<String> >> findAllRestAuthorized(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYGROUP_findAllRestAuthorized");
		ctx.put(Contexto.URL_SOLICITADA,"/securitygroup.findAllRestAuthorized");
		Result< Map< String,Set<String> >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:findAllRestAuthorized("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYGROUP_findAllRestAuthorized"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYGROUP_findAllRestAuthorized","/securitygroup.findAllRestAuthorized"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:findAllRestAuthorized("+params+")"+params);

				Result< Map< String,Set<String> > > res_=service.findAllRestAuthorized();
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:findAllRestAuthorized("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:findAllRestAuthorized("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:findAllRestAuthorized("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Map< String,Set<String> > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



// FIN LN de CRUD




//Si hay que anadir metodos se incluyen aqui,
// se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

