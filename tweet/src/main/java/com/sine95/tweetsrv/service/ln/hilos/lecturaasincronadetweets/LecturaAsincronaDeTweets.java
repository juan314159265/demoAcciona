package com.sine95.tweetsrv.service.ln.hilos.lecturaasincronadetweets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.base.task.TaskBase;
import org.sine95.kernel.base.Result;
import org.sine95.kernel.util.*;

import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.warnings.*;
import com.sine95.tweetsrv.infos.*;
import com.sine95.tweetsrv.service.Config;
import com.sine95.tweetsrv.enums.*;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;







//Si hay que anadir Imports se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


@SuppressWarnings("unused")
public class LecturaAsincronaDeTweets extends TaskBase< Vacio > {

	private final Logger log = LoggerFactory.getLogger(LecturaAsincronaDeTweets.class);

	//Variables heredadas que son importantes:
	//removeWhenFinish : tipo boolean => pensado para que cuando acabe la ejecución se mantenga o no en la lista de hilos, si se mantiene , para quitarlo hay que llamar al método Cancel
	//result : el result del tipo definido para devolver el resultado, se puede Usar Vacio si no queremos que devuelva nada, pero se necesita el result para devolver errores que puedan ocurrir
	//pleaseStop : tipo boolean => cuando desde fuera se intenta cancelar, habría que comprobar su valor en cada fase para pararlo tan pronto como sea posible
	
	
	private String id="";//Se usa para devolver el valor de id en el método getId()
	private String fase="";//Se usa para rastrear por donde se va ejecutando el hilo, lo usamos en getInfo()
	private ModelLecturaAsincronaDeTweets model;
	private Config config;

	
	

	public LecturaAsincronaDeTweets(ModelLecturaAsincronaDeTweets model)
	{
		super();
		this.model=model;
		String _params_=UtilParams.paramsToString("model",model);
		if (log.isInfoEnabled()) log.info("Entrando en el constructor de LecturaAsincronaDeTweets ("+_params_+")");
		removeWhenFinish=true;
		id="LecturaAsincronaDeTweets["+UtilString.newUUID()+"]";
		config=model.getConfig();
		fase="Inicializando";
		if (log.isInfoEnabled()) log.info("Saliendo en el constructor de LecturaAsincronaDeTweets ("+_params_+")");
	}
	

/**
* Este hilo se usa para buscar los tweets a persistir
*/


	@Override
	public Result< Vacio > exec() {
		if (log.isInfoEnabled()) log.info("Entrando en el exec de LecturaAsincronaDeTweets ()");
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		
		
		TransactionStatus status = model.getTransactionManager().getTransaction(definition);
		boolean commit=true;
		try {
			
			//Usar model y si es multifase no olvidar usar pleaseStop para comprobar si nos han cancelado la ejecución
			fase="Ejecutando";
			
		} catch(Throwable t)
		{
			result.addError(new ErrorGeneral(t));
			if (log.isErrorEnabled()) log.error("Error en exec de LecturaAsincronaDeTweets () (). Excepcion:"+UtilException.printStackTrace(t));
			commit=false;
		}
		if (log.isInfoEnabled()) log.info("Saliendo en el exec de LecturaAsincronaDeTweets ().Result:"+result.toString());
		if(commit)
		{
			 model.getTransactionManager().commit(status);
		}
		else 
		{
			model.getTransactionManager().rollback(status);
		}
		return result;
	}

	@Override
	public String getId() {
		
		return id;
		
	}

	@Override
	public String getInfo() {
		
		return fase;
		
	}

	
	


	/*
	Help:
		Ejemplo de uso de pleaseStop:

		fase="Buscado datos 1";
		//xxxx
		if(!pleaseStop)
		{
			fase="Buscando datos2";
			//xxxx
		}
		fase="fin"
	*/

/*


*/   

}
