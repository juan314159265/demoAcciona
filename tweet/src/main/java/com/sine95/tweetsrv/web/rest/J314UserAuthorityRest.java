
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

import java.util.Map;

/**
 * REST controller for managing J314UserAuthority.
 */
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class J314UserAuthorityRest extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(J314UserAuthorityRest.class);

//    private static final String ENTITY_NAME = "j314userauthority";

    private final J314UserAuthorityRepository repository;
    private final J314UserAuthorityServiceCRUD service;

    public J314UserAuthorityRest(J314UserAuthorityRepository repository,J314UserAuthorityServiceCRUD service) {
        this.repository = repository;
        this.service = service;
    }


//import io.github.jhipster.web.util.ResponseUtil;


	
	/**
	 * POST  /J314UserAuthority : Cear un objeto de tipo J314UserAuthority nuevo.
	 *
	 * @param id1 el id del padre de la relación J314UserAuthority
	 * @param id2 el id del hijo de la relación J314UserAuthority
	 * @param obj el POJO de la relación J314UserAuthority
	 * @return Un ResponseEntity con estado 201 (Created) y con el cuerpo (body) de la nueva instancia de J314UserAuthority, o con el estado 400 (Bad Request) si el J314UserAuthority ya existe
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PostMapping("/J314UserAuthoritys/{id1}/{id2}")
	@Timed

	@Transactional
	
	public ResultExt< J314UserAuthorityPoj> create(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1, @PathVariable String id2, @Valid @RequestBody J314UserAuthorityPoj obj)
	{
		
		String params=UtilParams.paramsToString("Long",id1, "String",id2, "J314UserAuthorityPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USERAUTHORITY_CREATE");
		ctx.put(Contexto.URL_SOLICITADA,"/J314UserAuthoritys/{id1}/{id2}");
		Result< J314UserAuthorityPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:create("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USERAUTHORITY_CREATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USERAUTHORITY_CREATE","/J314UserAuthoritys/{id1}/{id2}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1, "String",id2, "J314UserAuthorityPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:create("+params+")"+params);

				Long id1_ = id1;

				String id2_ = id2;

				J314UserAuthority obj_ = J314UserAuthorityPoj.getModel(obj);

				Result< J314UserAuthority > res_=service.create(id1_, id2_, obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314UserAuthorityPoj(res_.getData()):null);

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

		ResultExt< J314UserAuthorityPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * PUT  /J314UserAuthority : Actualiza (Update) un objeto de tipo J314UserAuthority ya existente.
	 *
	 * @param id1 el id del padre de la relación J314UserAuthority
	 * @param id2 el id del hijo de la relación J314UserAuthority
	 * @param obj el POJO de la relación J314UserAuthority
	 * @return El ResponseEntity con estado 200 (OK) y con el cuerpo (body) actualizado J314UserAuthority,
	 * o con estado 400 (Bad Request) si el objeto de tipo J314UserAuthority no es valido,
	 * o con estado 500 (Internal Server Error) si el objeto de tipo J314UserAuthority no puede ser actualizado
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	
	 */

	@PutMapping("/J314UserAuthoritys/{id1}/{id2}")
	@Timed

	@Transactional
	
	public ResultExt< J314UserAuthorityPoj> update(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1, @PathVariable String id2, @Valid @RequestBody J314UserAuthorityPoj obj)
	{
		
		String params=UtilParams.paramsToString("Long",id1, "String",id2, "J314UserAuthorityPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USERAUTHORITY_UPDATE");
		ctx.put(Contexto.URL_SOLICITADA,"/J314UserAuthoritys/{id1}/{id2}");
		Result< J314UserAuthorityPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:update("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USERAUTHORITY_UPDATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USERAUTHORITY_UPDATE","/J314UserAuthoritys/{id1}/{id2}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1, "String",id2, "J314UserAuthorityPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:update("+params+")"+params);

				Long id1_ = id1;

				String id2_ = id2;

				J314UserAuthority obj_ = J314UserAuthorityPoj.getModel(obj);

				Result< J314UserAuthority > res_=service.update(id1_, id2_, obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314UserAuthorityPoj(res_.getData()):null);

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

		ResultExt< J314UserAuthorityPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /J314UserAuthority : obtener el objeto de relación J314UserAuthority correspondiente al id del padre y del hijo recibidos como parámetros.
	 *
	 * @param id1 el id del padre de la relación J314UserAuthority
	 * @param id2 el id del hijo de la relación J314UserAuthority
	 * @return el ResponseEntity con estado 200 (OK) y el objeto de tipo J314UserAuthority en el cuerpo (body)
	 */

	@GetMapping("/J314UserAuthoritys/{id1}/{id2}")
	@Timed
	
	public ResultExt< J314UserAuthorityPoj> get(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1, @PathVariable String id2)
	{
		
		String params=UtilParams.paramsToString("Long",id1, "String",id2);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USERAUTHORITY_GET");
		ctx.put(Contexto.URL_SOLICITADA,"/J314UserAuthoritys/{id1}/{id2}");
		Result< J314UserAuthorityPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:get("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USERAUTHORITY_GET"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USERAUTHORITY_GET","/J314UserAuthoritys/{id1}/{id2}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1, "String",id2);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:get("+params+")"+params);

				Long id1_ = id1;

				String id2_ = id2;

				Result< J314UserAuthority > res_=service.get(id1_, id2_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new J314UserAuthorityPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:get("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:get("+params+"). Resultado:"+res.toString());

		ResultExt< J314UserAuthorityPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * DELETE  /J314UserAuthoritys/:id : elimina el objeto de la relación J314UserAuthority correspondiente al padre e hijo recibidos como parámetros.
	 *
	 * @param id1 el id del padre de la relación J314UserAuthority
	 * @param id2 el id del hijo de la relación J314UserAuthority
	 * @return la ResponseEntity con estado 200 (OK)
	 */

	@DeleteMapping("/J314UserAuthoritys/{id1}/{id2}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> delete(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1, @PathVariable String id2)
	{
		
		String params=UtilParams.paramsToString("Long",id1, "String",id2);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_J314USERAUTHORITY_DELETE");
		ctx.put(Contexto.URL_SOLICITADA,"/J314UserAuthoritys/{id1}/{id2}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST DELETE:delete("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_J314USERAUTHORITY_DELETE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_J314USERAUTHORITY_DELETE","/J314UserAuthoritys/{id1}/{id2}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1, "String",id2);
				if (log.isInfoEnabled()) log.info("Verificado en REST DELETE:delete("+params+")"+params);

				Long id1_ = id1;

				String id2_ = id2;

				Result< Vacio > res_=service.delete(id1_, id2_);
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

// Campo de relacion. Nombre: usuario; Tipo: MAN; Navegacion: A
// HASTA AQUI Campo de relacion. Nombre usuario; Tipo: MAN; Navegacion: A; Entidad remota: J314User

// Campo de relacion. Nombre: authority; Tipo: MAN; Navegacion: A
// HASTA AQUI Campo de relacion. Nombre authority; Tipo: MAN; Navegacion: A; Entidad remota: J314Authority

// FIN de metodos para gestionar las relaciones
// LN de CRUD

// FIN LN de CRUD




//Si hay que anadir metodos se incluyen aqui,
// se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

