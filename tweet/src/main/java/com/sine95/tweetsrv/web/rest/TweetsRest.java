
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
 * REST controller for managing Tweets.
 */
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class TweetsRest extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(TweetsRest.class);

//    private static final String ENTITY_NAME = "tweets";

    private final TweetsRepository repository;
    private final TweetsServiceCRUD service;

    public TweetsRest(TweetsRepository repository,TweetsServiceCRUD service) {
        this.repository = repository;
        this.service = service;
    }


//import io.github.jhipster.web.util.ResponseUtil;



	/**
	 * POST  /tweets : Cear un objeto de tipo Tweets nuevo.
	 *
	 * @param obj el Tweets a crear
	 * @return Un ResponseEntity con estado 201 (Created) y con el cuerpo (body) del nuevo Tweets, o con el estado 400 (Bad Request) si el  Tweets tiene un ID preexistente
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PostMapping("/tweets")
	@Timed

	@Transactional
	
	public ResultExt< TweetsPoj> create(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody TweetsPoj obj)
	{
		
		String params=UtilParams.paramsToString("TweetsPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TWEETS_CREATE");
		ctx.put(Contexto.URL_SOLICITADA,"/tweets");
		Result< TweetsPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:create("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TWEETS_CREATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TWEETS_CREATE","/tweets"));
			}
			else
			{
				params=UtilParams.paramsToString("TweetsPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:create("+params+")"+params);

				Tweets obj_ = TweetsPoj.getModel(obj);

				Result< Tweets > res_=service.insert(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new TweetsPoj(res_.getData()):null);

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

		ResultExt< TweetsPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * PUT  /tweets : Actualiza (Update) un objeto preexistente  (Tweets).
	 *
	 * @param obj El objeto de tipo Tweets a modificar
	 * @return El ResponseEntity con estado 200 (OK) y con el cuerpo (body) actualizado Tweets,
	 * o con estado 400 (Bad Request) si el objeto de tipo Tweets no es valido,
	 * o con estado 500 (Internal Server Error) si el objeto de tipo Tweets no puede ser actualizado
	 * @throws URISyntaxException si la sintaxis de la URI es incorrecta
	 */

	@PutMapping("/tweets")
	@Timed

	@Transactional
	
	public ResultExt< TweetsPoj> update(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody TweetsPoj obj)
	{
		
		String params=UtilParams.paramsToString("TweetsPoj",obj);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TWEETS_UPDATE");
		ctx.put(Contexto.URL_SOLICITADA,"/tweets");
		Result< TweetsPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:update("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TWEETS_UPDATE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TWEETS_UPDATE","/tweets"));
			}
			else
			{
				params=UtilParams.paramsToString("TweetsPoj",obj);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:update("+params+")"+params);

				Tweets obj_ = TweetsPoj.getModel(obj);

				Result< Tweets > res_=service.update(obj_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new TweetsPoj(res_.getData()):null);

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

		ResultExt< TweetsPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /tweets : obtener todos los objetos de tipo Tweets.
	 *
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo tweets en el cuerpo (body)
	 */

	@GetMapping("/tweets")
	@Timed
	
	public ResultExt< List< TweetsPoj >> getAll(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TWEETS_GETALL");
		ctx.put(Contexto.URL_SOLICITADA,"/tweets");
		Result< List< TweetsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:getAll("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TWEETS_GETALL"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TWEETS_GETALL","/tweets"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:getAll("+params+")"+params);

				Result< List< Tweets > > res_=service.findAll();
				res.setInfoEWI(res_);

				res.setData( TweetsPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:getAll("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:getAll("+params+"). Resultado:"+res.toString());

		ResultExt< List< TweetsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /tweets : obtener todos los objetos de tipo Tweets.
	 *
	 * @param pageable informacion de paginacion
	 * @return el ResponseEntity con estado 200 (OK) y la lista de objetos de tipo tweets en el cuerpo (body)
	 */

	@PostMapping("/tweets.pag")
	@Timed
	
	public ResultExt< Page< TweetsPoj >> getAllPag(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody TweetsCritPaged pag)
	{
		
		String params=UtilParams.paramsToString("TweetsCritPaged",pag);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TWEETS_GETALLPAG");
		ctx.put(Contexto.URL_SOLICITADA,"/tweets.pag");
		Result< Page< TweetsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getAllPag("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TWEETS_GETALLPAG"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TWEETS_GETALLPAG","/tweets.pag"));
			}
			else
			{
				params=UtilParams.paramsToString("TweetsCritPaged",pag);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getAllPag("+params+")"+params);

				TweetsCritPaged pag_ = pag;

				Result< Page< Tweets > > res_=service.findAll(pag_);
				res.setInfoEWI(res_);

				res.setData(TweetsPoj.toPOJOPage(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getAllPag("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getAllPag("+params+"). Resultado:"+res.toString());

		ResultExt< Page< TweetsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * GET  /tweets/:id : obtiene el objeto con el "id" de tipo Tweets.
	 *
	 * @param id el id del tipo Tweets a devolver
	 * @return la ResponseEntity con estado 200 (OK) con el cuerpo (body) del tipo Tweets, o con estado 404 (Not Found)
	 */

	@GetMapping("/tweets/{id1}")
	@Timed
	
	public ResultExt< TweetsPoj> get(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TWEETS_GET");
		ctx.put(Contexto.URL_SOLICITADA,"/tweets/{id1}");
		Result< TweetsPoj> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:get("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TWEETS_GET"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TWEETS_GET","/tweets/{id1}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",id1);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:get("+params+")"+params);

				Long id1_ = id1;

				Result< Tweets > res_=service.findWithResult(id1_);
				res.setInfoEWI(res_);

				res.setData(res_.getData()!=null?new TweetsPoj(res_.getData()):null);

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:get("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:get("+params+"). Resultado:"+res.toString());

		ResultExt< TweetsPoj > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /tweets : devuelve los objetos de tipo tweets filtrados por el criterio y paginados.
	 *
	 * @param pageable la informacion de paginacion
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo tweets en el cuerpo (body)
	 */

	@PostMapping("/tweets.querypaged")
	@Timed

	@Transactional
	
	public ResultExt< Page< TweetsPoj >> queryCritPaged(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody TweetsCritPaged param)
	{
		
		String params=UtilParams.paramsToString("TweetsCritPaged",param);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TWEETS_QUERYCRITPAGED");
		ctx.put(Contexto.URL_SOLICITADA,"/tweets.querypaged");
		Result< Page< TweetsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:queryCritPaged("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TWEETS_QUERYCRITPAGED"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TWEETS_QUERYCRITPAGED","/tweets.querypaged"));
			}
			else
			{
				params=UtilParams.paramsToString("TweetsCritPaged",param);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:queryCritPaged("+params+")"+params);

				TweetsCritPaged param_ = param;

				Result< Page< Tweets > > res_=service.listByCriteriaPaged(param_);
				res.setInfoEWI(res_);

				res.setData(TweetsPoj.toPOJOPage(res_.getData()));

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

		ResultExt< Page< TweetsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * POST  /tweets : devuelve los objetos de tipo tweets filtrados por el criterio.
	 *
	 * @param criteria criterio que deben cumplir los objetos que se devuelvan
	 * @return la ResponseEntity con estado 200 (OK) y la lista de objetos de tipo tweets en el cuerpo (body)
	 */

	@PostMapping("/tweets.query")
	@Timed

	@Transactional
	
	public ResultExt< List< TweetsPoj >> getCrit2(HttpServletRequest request,HttpServletResponse response, @Valid @RequestBody TweetsCrit criteria)
	{
		
		String params=UtilParams.paramsToString("TweetsCrit",criteria);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TWEETS_GETCRIT2");
		ctx.put(Contexto.URL_SOLICITADA,"/tweets.query");
		Result< List< TweetsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getCrit2("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TWEETS_GETCRIT2"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TWEETS_GETCRIT2","/tweets.query"));
			}
			else
			{
				params=UtilParams.paramsToString("TweetsCrit",criteria);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getCrit2("+params+")"+params);

				TweetsCrit criteria_ = criteria;

				Result< List< Tweets > > res_=service.listByCriteria(criteria_);
				res.setInfoEWI(res_);

				res.setData( TweetsPoj.toPOJOList(res_.getData()));

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

		ResultExt< List< TweetsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




	/**
	 * DELETE  /tweets/:id : elimina el objeto de id "id" Tweets.
	 *
	 * @param id el id del objeto de tipo Tweets a borrar
	 * @return la ResponseEntity con estado 200 (OK)
	 */

	@DeleteMapping("/tweets/{id1}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> delete(HttpServletRequest request,HttpServletResponse response, @PathVariable Long id1)
	{
		
		String params=UtilParams.paramsToString("Long",id1);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_ENTITY_TWEETS_DELETE");
		ctx.put(Contexto.URL_SOLICITADA,"/tweets/{id1}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST DELETE:delete("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_ENTITY_TWEETS_DELETE"))
			{
				res.addError(new ErrorSinPermiso("REST_ENTITY_TWEETS_DELETE","/tweets/{id1}"));
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

