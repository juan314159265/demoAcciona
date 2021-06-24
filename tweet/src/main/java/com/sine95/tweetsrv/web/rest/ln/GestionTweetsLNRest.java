package com.sine95.tweetsrv.web.rest.ln;

import com.sine95.tweetsrv.domain.*;
import com.sine95.tweetsrv.service.*;
import com.sine95.tweetsrv.service.crud.*;
import com.sine95.tweetsrv.service.ln.*;
import com.sine95.tweetsrv.*;
import java.util.*;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.web.rest.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Contexto;
import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.ResultExt;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.warnings.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import com.codahale.metrics.annotation.Timed;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;


//entity
import com.sine95.tweetsrv.domain.Tweets;
import com.sine95.tweetsrv.domain.TweetsCrit;
import com.sine95.tweetsrv.domain.TweetsCritPaged;
import com.sine95.tweetsrv.service.crud.TweetsServiceCRUD;

//import com.sine95.tweetsrv.domain.TweetsExt;
import com.sine95.tweetsrv.domain.TweetsExt;

//entity
import com.sine95.tweetsrv.domain.Hashtags;
import com.sine95.tweetsrv.domain.HashtagsCrit;
import com.sine95.tweetsrv.domain.HashtagsCritPaged;
import com.sine95.tweetsrv.service.crud.HashtagsServiceCRUD;

//import com.sine95.tweetsrv.domain.HashtagsExt;
import com.sine95.tweetsrv.domain.HashtagsExt;

//obj    
import com.sine95.tweetsrv.domain.In_GestionTweets_TweetsMasUsados;
    



import org.springframework.web.bind.annotation.*;



/**
* Controlador REST para la LN de GestionTweetsLNService
*/
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class GestionTweetsLNRest extends ControllerBase
{
  private final Logger log = LoggerFactory.getLogger(GestionTweetsLNRest.class);
  @Autowired
  GestionTweetsLNService service;



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected TweetsServiceCRUD tweetsService;

    @Autowired
    protected HashtagsServiceCRUD hashtagsService;


  
  
  

	@PutMapping("/gestiontweets.ValidarTweet/{tweetid}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> ValidarTweet(HttpServletRequest request,HttpServletResponse response, @PathVariable Long tweetid)
	{
		
		String params=UtilParams.paramsToString("Long",tweetid);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONTWEETS_ValidarTweet");
		ctx.put(Contexto.URL_SOLICITADA,"/gestiontweets.ValidarTweet/{tweetid}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:ValidarTweet("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONTWEETS_ValidarTweet"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONTWEETS_ValidarTweet","/gestiontweets.ValidarTweet/{tweetid}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",tweetid);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:ValidarTweet("+params+")"+params);

				Long tweetid_ = tweetid;

				Result< Vacio > res_=service.ValidarTweet(tweetid_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:ValidarTweet("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:ValidarTweet("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST PUT:ValidarTweet("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@GetMapping("/gestiontweets.TweetsValidos")
	@Timed

	@Transactional
	
	public ResultExt< List< TweetsPoj >> TweetsValidos(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONTWEETS_TweetsValidos");
		ctx.put(Contexto.URL_SOLICITADA,"/gestiontweets.TweetsValidos");
		Result< List< TweetsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:TweetsValidos("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONTWEETS_TweetsValidos"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONTWEETS_TweetsValidos","/gestiontweets.TweetsValidos"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:TweetsValidos("+params+")"+params);

				Result< List< Tweets > > res_=service.TweetsValidos();
				res.setInfoEWI(res_);

				res.setData( TweetsPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:TweetsValidos("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:TweetsValidos("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST GET:TweetsValidos("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< List< TweetsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@GetMapping("/gestiontweets.Tweets")
	@Timed

	@Transactional
	
	public ResultExt< List< TweetsPoj >> Tweets(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONTWEETS_Tweets");
		ctx.put(Contexto.URL_SOLICITADA,"/gestiontweets.Tweets");
		Result< List< TweetsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:Tweets("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONTWEETS_Tweets"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONTWEETS_Tweets","/gestiontweets.Tweets"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:Tweets("+params+")"+params);

				Result< List< Tweets > > res_=service.Tweets();
				res.setInfoEWI(res_);

				res.setData( TweetsPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:Tweets("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:Tweets("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST GET:Tweets("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< List< TweetsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/gestiontweets.HashtagsMasUsados")
	@Timed

	@Transactional
	
	public ResultExt< List< HashtagsPoj >> HashtagsMasUsados(HttpServletRequest request,HttpServletResponse response, @RequestBody In_GestionTweets_TweetsMasUsados info)
	{
		
		String params=UtilParams.paramsToString("In_GestionTweets_TweetsMasUsados",info);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONTWEETS_HashtagsMasUsados");
		ctx.put(Contexto.URL_SOLICITADA,"/gestiontweets.HashtagsMasUsados");
		Result< List< HashtagsPoj >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:HashtagsMasUsados("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONTWEETS_HashtagsMasUsados"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONTWEETS_HashtagsMasUsados","/gestiontweets.HashtagsMasUsados"));
			}
			else
			{
				params=UtilParams.paramsToString("In_GestionTweets_TweetsMasUsados",info);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:HashtagsMasUsados("+params+")"+params);

				In_GestionTweets_TweetsMasUsados info_ = info;

				Result< List< Hashtags > > res_=service.HashtagsMasUsados(info_);
				res.setInfoEWI(res_);

				res.setData( HashtagsPoj.toPOJOList(res_.getData()));

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:HashtagsMasUsados("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:HashtagsMasUsados("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:HashtagsMasUsados("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< List< HashtagsPoj > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




//Si hay que anadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

