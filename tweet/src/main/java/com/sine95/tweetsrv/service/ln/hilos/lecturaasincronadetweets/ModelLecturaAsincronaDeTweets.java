package com.sine95.tweetsrv.service.ln.hilos.lecturaasincronadetweets;

import java.util.*;
import org.springframework.transaction.PlatformTransactionManager;
import com.sine95.tweetsrv.service.Config;
import javax.persistence.EntityManager;
import com.sine95.tweetsrv.service.MailService;
import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;





//Si hay que anadir Imports se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE
import com.sine95.tweetsrv.service.Config;


@SuppressWarnings("unused")
public class ModelLecturaAsincronaDeTweets {
	
	//Hay que añadir métodos y atributos se incluyen aqui, 
	//se recomienda utilizar este tipo de comentario para no interferir con el DELETE
	Config config;
	
	public Config getConfig() {
		return config;
	}

	
	

	

	private PlatformTransactionManager transactionManager;
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
		// TODO Auto-generated method stub
		
	}
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}


  public ModelLecturaAsincronaDeTweets(

  
	Config _config
	
  ){

  
  
	config=_config;
	
  }


/*


*/   

}

