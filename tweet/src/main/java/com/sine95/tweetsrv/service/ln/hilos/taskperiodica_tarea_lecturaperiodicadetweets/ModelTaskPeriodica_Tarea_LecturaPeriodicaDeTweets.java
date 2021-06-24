package com.sine95.tweetsrv.service.ln.hilos.taskperiodica_tarea_lecturaperiodicadetweets;

import java.util.*;
import org.springframework.transaction.PlatformTransactionManager;
import com.sine95.tweetsrv.service.Config;
import javax.persistence.EntityManager;
import com.sine95.tweetsrv.service.MailService;
import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;


//entity
import com.sine95.tweetsrv.domain.J314User;
import com.sine95.tweetsrv.domain.J314UserCrit;
import com.sine95.tweetsrv.domain.J314UserCritPaged;
import com.sine95.tweetsrv.service.crud.J314UserServiceCRUD;

//import com.sine95.tweetsrv.domain.J314UserExt;
import com.sine95.tweetsrv.domain.J314UserExt;


//service
import com.sine95.tweetsrv.service.ln.GestionHilosLNService;
    



//Si hay que anadir Imports se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


@SuppressWarnings("unused")
public class ModelTaskPeriodica_Tarea_LecturaPeriodicaDeTweets {
	
	//Hay que añadir métodos y atributos se incluyen aqui, 
	//se recomienda utilizar este tipo de comentario para no interferir con el DELETE
	

	private PlatformTransactionManager transactionManager;
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
		// TODO Auto-generated method stub
		
	}
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
    protected Config config;

    public Config getConfig()
    {
        return config;
    }
    public void setConfig(Config obj)
    {
        config=obj;
    }

    protected EntityManager entityManager;

    public EntityManager getEntityManager()
    {
        return entityManager;
    }
    public void setEntityManager(EntityManager obj)
    {
        entityManager=obj;
    }

    protected MailService mailService;

    public MailService getMailService()
    {
        return mailService;
    }
    public void setMailService(MailService obj)
    {
        mailService=obj;
    }
    protected ApplicationContext appContext;

    public ApplicationContext getApplicationContext()
    {
        return appContext;
    }
    public void setApplicationContext(ApplicationContext obj)
    {
        appContext=obj;
    }



    protected J314UserServiceCRUD j314UserService;

    public J314UserServiceCRUD getJ314UserServiceCRUD()
    {
        return j314UserService;
    }
    public void setJ314UserServiceCRUD(J314UserServiceCRUD obj)
    {
        j314UserService=obj;
    }

    
    protected GestionHilosLNService gestionHilosService;

    public GestionHilosLNService getGestionHilosLNService()
    {
      return gestionHilosService;
    }
    public void setGestionHilosLNService(GestionHilosLNService obj)
    {
      gestionHilosService=obj;
    }


    protected Date fechaActual;

    public ModelTaskPeriodica_Tarea_LecturaPeriodicaDeTweets(Date fechaActual){
        this.fechaActual=fechaActual;
    }

    public Date getFechaActual()
    {
        return fechaActual;
    }


/*


*/   

}

