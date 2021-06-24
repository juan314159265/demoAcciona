package com.sine95.tweetsrv.service.task;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
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
    


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.sine95.kernel.base.Result;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.warnings.*;
import com.sine95.tweetsrv.service.Config;
import com.sine95.tweetsrv.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import com.sine95.tweetsrv.service.ln.LNService;
import org.sine95.kernel.base.task.*;
import com.sine95.tweetsrv.enums.*;
import javax.persistence.EntityManager;
import org.springframework.context.ApplicationContext;




import org.springframework.data.domain.Example;
import com.sine95.tweetsrv.enums.SiNo;
import com.sine95.tweetsrv.service.MailService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.joda.time.LocalDate;
import org.joda.time.LocalDate.Property;
import java.math.BigInteger;
import org.sine95.kernel.base.Contexto;
import org.sine95.kernel.base.informes.ResTaskInforme;


/**
* Logica de negocio para las tareas automáticas
*/

@SuppressWarnings("unused")
@Service
public class TareaTaskService extends LNService
{
  private final Logger log = LoggerFactory.getLogger(TareaTaskService.class);

  @Autowired 
  private PlatformTransactionManager transactionManager;

  @Autowired
  protected EntityManager entityManager;
    
  @Autowired
  protected MailService mailService;


	

	


    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected J314UserServiceCRUD j314UserService;

    
    protected GestionHilosLNService gestionHilosService;

    protected synchronized GestionHilosLNService getGestionHilosLNService()
    {
      if(gestionHilosService==null)
      {
        gestionHilosService=appContext.getBean(GestionHilosLNService.class);
      }
      return gestionHilosService;
    }




    
   







/*


*/
}
