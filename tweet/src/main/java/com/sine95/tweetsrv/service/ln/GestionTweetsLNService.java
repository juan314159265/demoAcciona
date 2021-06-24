
package com.sine95.tweetsrv.service.ln;

import org.sine95.kernel.base.errores.IError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
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


import com.sine95.tweetsrv.enums.SiNo;
import org.springframework.data.domain.Page;


/**
* Logica de negocio para los tweets
*/

@SuppressWarnings("unused")
@Service

public class GestionTweetsLNService extends LNService
{
  private final Logger log = LoggerFactory.getLogger(GestionTweetsLNService.class);



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected TweetsServiceCRUD tweetsService;

    @Autowired
    protected HashtagsServiceCRUD hashtagsService;







	/**
	* Precondiciones para el metodo ValidarTweet.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsValidarTweet(Result< Vacio > res ,Long tweetid)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:tweetid Tipo:Long 

		if(tweetid==null)
		{
			res.addError(new ErrorParametroObligatorio("tweetid"));
		}


		if(tweetid!=null)
		{
			Result<Optional< Tweets >> byId = tweetsService.findById(tweetid);
			if(byId.isOk() && byId.getData().isPresent())
			{
				cache.put("TweetsFromTweetid",byId.getData().get());
			}
			else {
				res.addError( new ErrorIdNoEncontrado(
						Tweets.class.getName()
						, tweetid
						)
				);
			}
		}

		
		
		return cache;
	}

	/**
	* Marcar un tweet como válido
	*/




	@Transactional
	public Result< Vacio > ValidarTweet(Long tweetid)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("tweetid",tweetid);
		if (log.isInfoEnabled()) log.info("Entrando en GestionTweetsService.ValidarTweet ("+_params_+")");
		Map<String,Object> cache=preConditionsValidarTweet( res , tweetid );
		if(res.isOk())
		{
			try

			{

				Tweets tweetsFromTweetid = (Tweets) cache.get("TweetsFromTweetid");


				
				Tweets tweet=tweetsFromTweetid;
				tweet.setValidacion(SiNo.S);
				tweetsService.update(tweet);

				//insert_end)
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionTweetsServiceCRUD.ValidarTweet ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionTweetsServiceCRUD.ValidarTweet ("+UtilParams.paramsToString("tweetid",tweetid)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de GestionTweetsServiceCRUD.ValidarTweet ("+UtilParams.paramsToString("tweetid",tweetid)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo TweetsValidos.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsTweetsValidos(Result< List <Tweets> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Consultar los tweets validados por usuario.
	*/




	@Transactional
	public Result< List <Tweets> > TweetsValidos()
	{
		Result< List <Tweets> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en GestionTweetsService.TweetsValidos ("+_params_+")");
		Map<String,Object> cache=preConditionsTweetsValidos( res  );
		if(res.isOk())
		{
			try

			{


				
				
				Tweets example=new Tweets();
				example.setValidacion(SiNo.S);
				Result<List<Tweets>> listByExample = tweetsService.listByExample(example);
				
				res.setInfoEWI(listByExample);
				if(listByExample.isOk())
				{
					res.setData(listByExample.getData());
				}
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionTweetsServiceCRUD.TweetsValidos ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionTweetsServiceCRUD.TweetsValidos ("+UtilParams.paramsToString()+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de GestionTweetsServiceCRUD.TweetsValidos ("+UtilParams.paramsToString()+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo Tweets.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsTweets(Result< List <Tweets> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Consultar los tweets
	*/




	@Transactional
	public Result< List <Tweets> > Tweets()
	{
		Result< List <Tweets> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en GestionTweetsService.Tweets ("+_params_+")");
		Map<String,Object> cache=preConditionsTweets( res  );
		if(res.isOk())
		{
			try

			{


				
				Result<List<Tweets>> findAll = tweetsService.findAll();
				res.setInfoEWI(findAll);
				if(findAll.isOk())
				{
					res.setData(findAll.getData());
				}
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionTweetsServiceCRUD.Tweets ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionTweetsServiceCRUD.Tweets ("+UtilParams.paramsToString()+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de GestionTweetsServiceCRUD.Tweets ("+UtilParams.paramsToString()+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo HashtagsMasUsados.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsHashtagsMasUsados(Result< List <Hashtags> > res ,In_GestionTweets_TweetsMasUsados info)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:info Tipo:In_GestionTweets_TweetsMasUsados 

		if(info==null)
		{
			res.addError(new ErrorParametroObligatorio("info"));
		}


		if( info !=null )
		{
			In_GestionTweets_TweetsMasUsadosObjValidator val=new In_GestionTweets_TweetsMasUsadosObjValidator(appContext);
			res.addErrores(val.validate(info));
		}

		
		
		return cache;
	}

	/**
	* Consultar una clasificación de los N hashtags más usados.
	*/




	@Transactional
	public Result< List <Hashtags> > HashtagsMasUsados(In_GestionTweets_TweetsMasUsados info)
	{
		Result< List <Hashtags> > res=new Result<>();
		String _params_=UtilParams.paramsToString("info",info);
		if (log.isInfoEnabled()) log.info("Entrando en GestionTweetsService.HashtagsMasUsados ("+_params_+")");
		Map<String,Object> cache=preConditionsHashtagsMasUsados( res , info );
		if(res.isOk())
		{
			try

			{


				
				Integer num=info.getMaxHashtags();
				if(num==null)
				{
					num=config.getMaxNumHashTags();
				}
				
				HashtagsCritPaged pageable = new HashtagsCritPaged();
				pageable.setSort(new String[] {"contador,desc"});
				pageable.setPageSize(num);
				pageable.setPaged(true);
				Result<Page<Hashtags>> findAll = hashtagsService.findAll(pageable);
				res.setInfoEWI(findAll); 
				res.setData(findAll.getData().getContent());
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionTweetsServiceCRUD.HashtagsMasUsados ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionTweetsServiceCRUD.HashtagsMasUsados ("+UtilParams.paramsToString("info",info)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de GestionTweetsServiceCRUD.HashtagsMasUsados ("+UtilParams.paramsToString("info",info)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



//Si hay que annadir metodos se incluyen aqui, se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


	


		





				
				
				


*/
}

