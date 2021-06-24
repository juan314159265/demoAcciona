
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

//enum

import com.sine95.tweetsrv.enums.SiNo;
    


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


import org.springframework.data.domain.Example;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import org.apache.commons.collections.CollectionUtils;
import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.ResponseList;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterListener;
import twitter4j.TwitterMethod;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;


/**
* Logica de negocio para el acceso a Twitter
*/

@SuppressWarnings("unused")
@Service

public class ClienteTwitterLNService extends LNService
{
  private final Logger log = LoggerFactory.getLogger(ClienteTwitterLNService.class);

  @Autowired
  private PlatformTransactionManager transactionManager;



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected TweetsServiceCRUD tweetsService;

    @Autowired
    protected HashtagsServiceCRUD hashtagsService;



    private Long minNumSeguidores;
    private Set<String> idiomasPermitidos;




	/**
	* Precondiciones para el metodo InitCli.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsInitCli(Result< Vacio > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Arranca la escucha de twits
	*/




	@Transactional
	public Result< Vacio > InitCli()
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en ClienteTwitterService.InitCli ("+_params_+")");
		Map<String,Object> cache=preConditionsInitCli( res  );
		if(res.isOk())
		{
			try

			{


				
				inicializaConfiguracion();
				StatusListener listener = new StatusListener(){
					public void onStatus(Status status) {
						
						int numSeguidores = status.getUser().getFollowersCount();
						String idioma = status.getLang();
						GeoLocation localizacion = status.getGeoLocation();
						if (numSeguidores>minNumSeguidores && idiomasPermitidos.contains(idioma)) {
							// Definimos la transacción únicamente para el trozo de código que necesitamos
							DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
						    TransactionStatus transaction = transactionManager.getTransaction(definition);
							
							// Persistimos el Tweet
							Tweets twt = genTweet(status, localizacion);
							
							Result<Tweets> resInseertTweet = tweetsService.insert(twt);
							res.copyStatus(resInseertTweet);

							// Actualizamos hashtags
							HashtagEntity[] hashtags = status.getHashtagEntities();
							for(HashtagEntity hashtag:hashtags) {
								if (res.isOk()) {
									insertOrUpdateHashtag(res, hashtag);
								}
							}

							if (!res.isOk()) {
								// Rollback
								transactionManager.rollback(transaction);

								log.error(resInseertTweet.getErrores().get(0).toString());
							}
							else {
								// Commit 
								transactionManager.commit(transaction);

								log.info("Status insert/update correctamente: "+twt.toString());
							}
						}
					}
					private void insertOrUpdateHashtag(Result<Vacio> res, HashtagEntity hashtag) {
						Hashtags hashtagEntity = new Hashtags();
						hashtagEntity.setHashtags(hashtag.getText());
						Result<List<Hashtags>> rlHtg =  hashtagsService.findAll(Example.of(hashtagEntity));
						if (rlHtg.isOk()) {
							List<Hashtags> lstHashtag = rlHtg.getData();
							if (lstHashtag.isEmpty()) {
								// nuevo
								hashtagEntity.setContador(1L);

								Result<Hashtags> rHtg = hashtagsService.insert(hashtagEntity);
								res.copyStatus(rHtg);
							}
							else {
								// actualización
								hashtagEntity = lstHashtag.get(0);
								hashtagEntity.setContador(hashtagEntity.getContador()+1);
								Result<Hashtags> rHtg = hashtagsService.update(hashtagEntity);
								res.copyStatus(rHtg);
							}
						}
						else {
							res.copyStatus(rlHtg);
						}
					}
					private Tweets genTweet(Status status, GeoLocation localizacion) {
						Tweets twt = new Tweets();
						twt.setId(status.getId());
						try {
							twt.setLocalizacion(localizacion==null?"":JSON.stringify(localizacion));
						} catch (JsonProcessingException e) {
							e.printStackTrace();
						}
						twt.setTexto(status.getText());
						twt.setUsuario(status.getUser().getName());
						twt.setValidacion(SiNo.N);
						return twt;
					}
					//No lo implementamos
					public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
					//No lo implementamos
					public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
					public void onException(Exception ex) {
						ex.printStackTrace();
					}
					
					//No lo implementamos
					@Override
					public void onScrubGeo(long userId, long upToStatusId) {}
					//No lo implementamos
					@Override
					public void onStallWarning(StallWarning warning) {}
				};
				TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
				twitterStream.addListener(listener);
				twitterStream.sample();
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en ClienteTwitterServiceCRUD.InitCli ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de ClienteTwitterServiceCRUD.InitCli ("+UtilParams.paramsToString()+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de ClienteTwitterServiceCRUD.InitCli ("+UtilParams.paramsToString()+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo SendTwit.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsSendTwit(Result< Vacio > res ,String texto)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:texto Tipo:String 

		if(texto==null)
		{
			res.addError(new ErrorParametroObligatorio("texto"));
		}


		
		
		return cache;
	}

	/**
	* Envía un twit
	*/




	public Result< Vacio > SendTwit(String texto)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("texto",texto);
		if (log.isInfoEnabled()) log.info("Entrando en ClienteTwitterService.SendTwit ("+_params_+")");
		Map<String,Object> cache=preConditionsSendTwit( res , texto );
		if(res.isOk())
		{
			try

			{


				
				Twitter twitter = TwitterFactory.getSingleton();
				twitter.updateStatus(texto);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en ClienteTwitterServiceCRUD.SendTwit ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de ClienteTwitterServiceCRUD.SendTwit ("+UtilParams.paramsToString("texto",texto)+"). Result:"+res.toString());


		return res;
	}



	public void inicializaConfiguracion() {
	    minNumSeguidores = config.getNumMinSuscriptoresUsuarioParaPersistir();
	    idiomasPermitidos = new HashSet<>();
	    {
		    String sIdiomasPermitidos = config.getIdiomasPermitidosParaPersistir();
		    String[] aIdiomasPermitidos = sIdiomasPermitidos.split(",");
		    CollectionUtils.addAll(idiomasPermitidos, aIdiomasPermitidos);
	    }
	}


/*


*/
}

